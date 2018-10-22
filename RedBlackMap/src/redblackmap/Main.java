package redblackmap;

public class Main {

    public static void main(String[] args) {
        Graph setValueGraph = new Graph();
        Graph getValueGraph = new Graph();
        setValueGraph.generateSetValueGraph();
        getValueGraph.generateGetValueGraph();
    }
}
