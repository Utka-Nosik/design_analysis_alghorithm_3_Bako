package com.Bako.assignment3;

/*************************************************************************************
**    ######           #         ##    ##       ####                ##   #####        **
**    ##    ##        ###        ##   ##      ##    ##            ##    ##   ##       **
**    ##    ##       ## ##       ##  ##      ##      ##         ##           ##       **
**    ######        ##   ##      #####      ##        ##      ##           ##         **
**    ##    ##     #########     ##  ##      ##      ##         ##           ##       **
**    ##    ##    ##       ##    ##   ##      ##    ##            ##    ##   ##       **
**    ######     ##         ##   ##    ##       ####                ##   #####        **
****************************************************************************************/


import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;

public class Main {
    public static Graph loadGraphFromFile(String filePath) {
        Gson gson = new Gson();
        Graph graph = new Graph();

        try (Reader reader = new FileReader(filePath)) {
            GraphData graphData = gson.fromJson(reader, GraphData.class);

            for (String vertex : graphData.vertices) {
                graph.addVertex(vertex);
            }

            for (EdgeData edgeData : graphData.edges) {
                graph.addEdge(edgeData.source, edgeData.destination, edgeData.weight);
            }

            System.out.println("Successfully loaded graph: " + graphData.graph_name);
            System.out.println("Total vertices: " + graph.getVertices().size());
            System.out.println("Total edges: " + graph.getAllEdges().size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return graph;
    }

    public static void main(String[] args) {
        Graph graph = loadGraphFromFile("data/small_graph.json");

        System.out.println("\n--- Graph structure check ---");
        for (String vertex : graph.getVertices()) {
            System.out.println("Edges from " + vertex + ": " + graph.getEdges(vertex));
        }
    }
}