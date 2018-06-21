package Structures;

/**
 * Created by MikeS on 6/19/18.
 */

/*
    A graph is a set of vertices and a collection of edges that connect a pair of vertices.

        No rules dictating the connection among the nodes. Edges can connect nodes in any way. A tree is also a graph.
        A graph G is an ordered pair of a set V of vertices and a set E of edges
            G = (V, E) <--- order matters, so V is first object and E is the second. (a,b) != (b,a)
            The first object in this def is a SET of vertices and the second a SET of edges
                Reminder: {a,b} is an unordered pair, so {a,b} == {b,a}
        An edge is uniquely identified by its two end points. We can write the name of two edges as a pair to represent it.
        2 Types:
            1. Directed edge (One way) -- (u,v)
                World wide web is a directed edge. A unique URL would be a node in graph.
                We have directed edge if page links to another page. Relationship here not mutual, dont always link back
                Search engines perform web crawling often. This systematically browses WWW to collect and store data to use in search engines.
                Web crawling basically web traversal, or visiting all nodes in a graph.
            2. Undirected (Two way)  -- {u,v} origin and direction not fixed. We would have {{v1,v2}, {v1,v3}...} for nodes {v1,v2,...}
                Facebook would be undirected, with billions of nodes and undirected because friendship is mutual relationship
                Think of suggesting friends to users, easy to suggest friends of friends for example
                Problem here is finding all nodes having length of shortest path from person equal to 2
            Graph can be both(or mixed -- less common)
        Weighted graphs
            Think road network. Roads would be different lengths and to solve problems we need to take length of road into account.
            In some cases we associated weight with an edge, in this case length of a road.
            To pick best route from City A to City D, with weights assigned to edges, we can use them to calculate total cost.
            This could be example of mixed directed and undirected, think one way. We can represent undirected with two way directed edges.


 */
public class Graph {

}
