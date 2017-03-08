package app.model;


import app.GraphOperations;
import app.GraphBuildingUtils;

import java.util.Collection;
import java.util.List;

public class Lab1Runner {

    public static void main(String[] args) {
        GraphOperations operations = new GraphOperations();
        GraphBuildingUtils.buildGraph(operations);


        System.out.println("All possible ways: ");
        List<WayResult> results = operations.countAllWays();
        print(results);

        results = operations.getCriticalWayTime(results);
        System.out.println("Sorted by critical way and time");
        print(results);

        int criticalWay = operations.findCriticalWay(results);
        System.out.println("So, critical way is " + criticalWay);

        double criticalTime = operations.findCriticalTime(results);
        System.out.println("and critical time is " + criticalTime);

        List<Prioritie> priorities = operations.countPriorities(criticalWay, criticalTime, results);
        System.out.println("Count Priorities");
        print(priorities);
    }

    private static <T extends Collection> void print(T results) {
        results.stream().forEach(System.out::println);
    }

}
