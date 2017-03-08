package app.model;


import java.util.Comparator;

public class Prioritie implements Comparable<Prioritie> {

    private double priority;
    private int vertex;

    public Prioritie(double priority, int vertex) {
        this.priority = priority;
        this.vertex = vertex;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }


    @Override
    public String toString() {
        return "Prioritie{" +
                "priority=" + priority +
                ", vertex=" + vertex +
                '}';
    }

    @Override
    public int compareTo(Prioritie o) {
        return Double.compare(o.getPriority(), this.priority);
    }
}
