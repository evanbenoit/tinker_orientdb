package com.ebenoit;


import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;


public class HelloTinkerpop {
    public static void main(String[] args) {

        //Toy example that opens a graph using Tinkerpop's built-in in-memory DB, adds a couple nodes and an edge, then queries it using gremlin
        System.out.println("Hello World");

        Graph graph = TinkerGraph.open();
        Vertex marko = graph.addVertex("name","marko","age",29);
        Vertex sandwich = graph.addVertex("name","sandwich","lang","java");
        marko.addEdge("created",sandwich,"weight",0.6d);

        GraphTraversalSource g = graph.traversal();

        String name = graph.vertices().next().property("name").value().toString();

        System.out.println(name);

        String creation = g.V().has("name","marko").out("created").next().property("name").value().toString();

        System.out.println(creation);
    }

}