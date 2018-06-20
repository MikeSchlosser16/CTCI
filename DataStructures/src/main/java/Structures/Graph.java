package Structures;

/**
 * Created by MikeS on 6/19/18.
 */

/*
    A graph is a set of vertices and a collection of edges that connect a pair of vertices.
    We use the names 0 through V-1 for the vertices in a V-vertex graph.
    Graphs used in many real life applications
        1. Networks, such as city of telephone network
        2. Social media, such as Facebook, each person represented as a vertex and each
            vertex has info such as person id, gender etc.
    Some terminology:
        Self-loop: Edge that connects vertex to itself
        Parallel edges: Two edges are parallel if they connect the same pair of vertices
        When an edge connects two vertices, we say that the verticies are adjacent to one another and that the edge is incident on both vertices.
        Degree: The degree of a vertex is the number of edges incident on it(number of edges it touches)
        Path: Sequence of vertices connected by edges.
        Simple path: A ppath with no repeated vertices
        Length of a path: Its number of edges

        Photos here: https://algs4.cs.princeton.edu/41graph/

 */
public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    // Creates a V-vertex graph with no edges
    Graph(int V){

    }

    // Read graph from input stream in
    Graph(In in){

    }

    // Number of vertices
    int V(){

    }

    // Number of edges
    int E(){

    }

    // Add edge v-w to this graph
    void addEdge(int v, int w){

    }

    // Vertices adjacent to v
    Iterable<Integer> adj(int v){

    }

    // String representaiton of graph
    public String toString(){

    }
}
