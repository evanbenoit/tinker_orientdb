package com.ebenoit;


import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Graph graph = TinkerGraph.open();
        Vertex marko = graph.addVertex("name","marko","age",29);
        Vertex lop = graph.addVertex("name","lop","lang","java");
        marko.addEdge("created",lop,"weight",0.6d);

        GraphTraversalSource g = graph.traversal();

        String name = (String)graph.vertices().next().property("name").value();

        System.out.println(name);

        String creation = g.V().has("name","marko").out("created").next().property("name").value().toString();

        System.out.println(creation);

    }

}