package app.model;


import app.GraphOperations;
import app.GraphBuildingUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Lab2Runner {

    public static void main(String[] args) {
        GraphOperations operations = new GraphOperations();
        GraphBuildingUtils.buildGraph(operations);


        System.out.println("Lets sort graphs by children amount: ");
        List<Vertex> results = operations.getSortedByChildrenAmount(operations.getVertexList());
        printWithChildrenWeight(results);

    }

    private static void printWithChildrenWeight(List<Vertex> results) {
        for (Vertex result : results) {
            System.out.println(
                    result.getNumber() + "(" + result.getChildren().size() + ") childrens: " +
                            Arrays.toString(result.getChildren().stream().mapToInt(v -> v.getNumber()).toArray())
            );
        }
    }



}
