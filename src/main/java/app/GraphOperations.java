package app;


import app.model.Prioritie;
import app.model.Vertex;
import app.model.WayResult;

import java.util.*;
import java.util.stream.Collectors;

public class GraphOperations {

    private List<Vertex> vertexList = new ArrayList<>();


    public void addVertexToSet(Vertex vertex) {
        vertexList.add(vertex);
    }

    public void link(int parentNum, int childNum) {
        Vertex parent = vertexList.get(parentNum - 1);
        Vertex child = vertexList.get(childNum - 1);
        int parentLevel = parent.getLevel();
        if (parentLevel > child.getLevel()) child.setLevel(++parentLevel);
        parent.getChildren().add(child);
        child.getParents().add(parent);
    }

    public List<WayResult> countAllWays() {
        List<WayResult> results = new ArrayList<WayResult>() {{
            for (Vertex vertexx : vertexList) {
                List<List<Vertex>> res = new ArrayList<>();
                goDown(res, new ArrayList<>(), vertexx);
                for (List<Vertex> vertexList : res) {
                    add(new WayResult(vertexList, vertexList.stream().mapToInt(v -> v.getVes()).sum(), vertexx.getNumber()));
                }

            }
        }};
        return results;
    }


    private void goDown(List<List<Vertex>> result, List<Vertex> gone, Vertex currentVertex) {
        // TODO: 08.03.17 if have cicles what to do then?
        gone.add(currentVertex);
        if (currentVertex.getChildren().isEmpty()) {
            result.add(new ArrayList<>(gone));
            gone.remove(currentVertex);
            return;
        } else
            for (Vertex child : currentVertex.getChildren()) {
                if (!gone.contains(child)) {
                    goDown(result, gone, child);
                    gone.remove(child);
                }
            }
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public List<WayResult> getCriticalWayTime(List<WayResult> input) {
        List<WayResult> res = new ArrayList<>();
        for (int i = 1; i < vertexList.size() + 1; i++) {
            int finalI = i;
            List<WayResult> vertexWithNumI = input.stream().filter(v -> (v.getVertexNum() == finalI)).collect(Collectors.toList());
            int max = vertexWithNumI.stream().mapToInt(v -> v.getVertexList().size()).max().getAsInt();
            WayResult filtered = vertexWithNumI.stream().filter(v -> v.getVertexList().size() == max).max(Comparator.comparingDouble(v -> Double.valueOf(v.getTime()))).get();
            res.add(filtered);
        }
        return res;
    }

    public int findCriticalWay(List<WayResult> input) {
        return input.stream().mapToInt(v -> v.getVertexList().size()).max().getAsInt();
    }

    public double findCriticalTime(List<WayResult> input) {
        return input.stream().mapToDouble(v -> v.getTime()).max().getAsDouble();
    }

    public List<Prioritie> countPriorities(int maxWay, double maxTime, List<WayResult> vertexesToCount) {
        List<Prioritie> res = new ArrayList<>();
        for (WayResult wayResult : vertexesToCount) {
            res.add(new Prioritie(
                    Double.valueOf(wayResult.getVertexList().size()) / Double.valueOf(maxWay) + wayResult.getTime() / maxTime,
                    wayResult.getVertexNum()
            ));
        }
        return res.stream().sorted().collect(Collectors.toList());
    }

    public List<Vertex> getSortedByChildrenAmount(List<Vertex> input) {
        return input.stream().sorted((v1, v2) -> Integer.compare(v2.getChildren().size(), v1.getChildren().size())).collect(Collectors.toList());
    }
}
