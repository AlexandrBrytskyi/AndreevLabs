package app.model;


import java.util.List;
import java.util.stream.Collectors;

public class Vertex {

    private int number;
    private int ves;
    private List<Vertex> children;
    private List<Vertex> parents;
    private int level;

    public Vertex(int number, int ves, List<Vertex> children, List<Vertex> parents, int level) {
        this.number = number;
        this.ves = ves;
        this.children = children;
        this.parents = parents;
        this.level = level;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getVes() {
        return ves;
    }

    public void setVes(int ves) {
        this.ves = ves;
    }

    public List<Vertex> getChildren() {
        return children;
    }

    public void setChildren(List<Vertex> children) {
        this.children = children;
    }

    public List<Vertex> getParents() {
        return parents;
    }

    public void setParents(List<Vertex> parents) {
        this.parents = parents;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (number != vertex.number) return false;
        return ves == vertex.ves;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + ves;
        return result;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "number=" + number +
                ", ves=" + ves +
                ", children=" + children.stream().mapToInt(v->v.getNumber()).boxed().collect(Collectors.<Integer>toList()) +
                ", parents=" + children.stream().mapToInt(v->v.getNumber()).boxed().collect(Collectors.<Integer>toList()) +
                ", level=" + level +
                '}';
    }
}
