package app.model;


import java.util.List;

public class WayResult {

    private List<Vertex> vertexList;
    private double time;
    private int vertexNum;

    public WayResult(List<Vertex> vertexList, double time, int vertexNum) {
        this.vertexList = vertexList;
        this.time = time;
        this.vertexNum = vertexNum;
    }

    @Override
    public String toString() {
        return "Way for vertex: " + vertexNum + "  " +
                buildWayString(vertexList) +
                ", length = " + vertexList.size() +
                ", time = " + time ;
    }

    private String buildWayString(List<Vertex> vertexList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertexList.size() - 1; i++) {
            sb.append(vertexList.get(i).getNumber()).append(" => ");
        }
        sb.append(vertexList.get(vertexList.size() - 1).getNumber());
        return sb.toString();
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public double getTime() {
        return time;
    }

    public int getVertexNum() {
        return vertexNum;
    }
}
