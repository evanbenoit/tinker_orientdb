package com.ebenoit;


import com.orientechnologies.orient.graph.gremlin.OCommandGremlin;
import com.orientechnologies.orient.graph.gremlin.OGremlinHelper;
import com.tinkerpop.blueprints.TransactionalGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import com.tinkerpop.blueprints.impls.orient.OrientVertex;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

import java.util.List;

public class HelloOrientDB {
    public static void main(String[] args) {

        //Toy example that opens a previously-installed OrientDB database using Tinkerpop's "Blueprints" framework,
        //adds a couple nodes and an edge, and gets the count of nodes.
        //Note this assumes you've installed OrientDB, in the location specified below.
        System.out.println("Hello World");

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

        //todo: I'm still querying this using Blueprints.  How can I query this using Gremlin, running a query similar
        //to what's in HelloTinkerpop?  I'm trying to use OGremlinHelper or OCommandGremlin, but I can't figure it out...

        //todo: How can I generalize the code so I could run the same code against Neo4J?

        //todo: I'm just storing properties containing simple key-value pairs.  How can I store more complex items, JSON, etc?

    }

}