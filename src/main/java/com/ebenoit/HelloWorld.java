package com.ebenoit;


import com.tinkerpop.blueprints.TransactionalGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import com.tinkerpop.blueprints.impls.orient.OrientVertex;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");

//        OrientGraph graph = new OrientGraph("memory:test");
//        OrientGraph graph = new OrientGraph("plocal:c:/temp/graph");
        //https://orientdb.com/docs/2.2/Gremlin.html
        //https://orientdb.com/docs/2.2/Graph-Database-Tinkerpop.html
        OrientGraphFactory factory = new OrientGraphFactory("plocal:C:/orientdb-community-2.2.22/databases/GratefulDeadConcerts").setupPool(1,10);

        OrientGraph graph = factory.getTx();

        OrientVertex v1 = graph.addVertex(null);
        v1.setProperties("name", "foo", "attitude", "happy", "height", "tall");

        OrientVertex v2 = graph.addVertex(null);
        v2.setProperty("name", "bar");

        graph.addEdge(null, v1, v2, "created");

        graph.commit();


        System.out.println("Vertex count:" + graph.countVertices());

        /*
        Graph graph = TinkerGraph.open();
        Vertex marko = graph.addVertex("name","marko","age",29);
        Vertex sandwich = graph.addVertex("name","sandwich","lang","java");
        marko.addEdge("created",sandwich,"weight",0.6d);
        */

/*
        GraphTraversalSource g = graph.traversal();

        String name = graph.vertices().next().property("name").value().toString();

        System.out.println(name);

        String creation = g.V().has("name","marko").out("created").next().property("name").value().toString();

        System.out.println(creation);
*/
    }

}