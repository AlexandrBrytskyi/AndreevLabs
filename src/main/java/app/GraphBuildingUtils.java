package app;

import app.model.Vertex;

import java.util.ArrayList;
import java.util.List;

public class GraphBuildingUtils {

    public static void buildGraph(GraphOperations builder) {
        builder.addVertexToSet(new Vertex(1, 6, new ArrayList<Vertex>(), new ArrayList<Vertex>(), 1));
        builder.addVertexToSet(new Vertex(2, 9, new ArrayList<Vertex>(), new ArrayList<Vertex>(), 1));
        builder.addVertexToSet(new Vertex(3, 3, new ArrayList<Vertex>(), new ArrayList<Vertex>(), 1));
        builder.addVertexToSet(new Vertex(4, 2, new ArrayList<Vertex>(), new ArrayList<Vertex>(), 1));
        builder.addVertexToSet(new Vertex(5, 1, new ArrayList<Vertex>(), new ArrayList<Vertex>(), 1));
        builder.addVertexToSet(new Vertex(6, 5, new ArrayList<Vertex>(), new ArrayList<Vertex>(), 1));
        builder.addVertexToSet(new Vertex(7, 8, new ArrayList<Vertex>(), new ArrayList<Vertex>(), 1));
        builder.addVertexToSet(new Vertex(8, 13, new ArrayList<Vertex>(), new ArrayList<Vertex>(), 1));


        List<Vertex> list = builder.getVertexList();

        builder.link(1, 3);
        builder.link(2, 3);
        builder.link(1, 4);
        builder.link(2, 5);
        builder.link(3, 4);
        builder.link(3, 5);
        builder.link(3, 6);
        builder.link(2, 6);
        builder.link(4, 7);
        builder.link(5, 7);
        builder.link(6, 7);
    }
}
