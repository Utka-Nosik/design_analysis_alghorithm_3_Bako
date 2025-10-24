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
            System.out.println("Loading graph from: " + filePath);
            for (String vertex : graphData.vertices) {
                graph.addVertex(vertex);
            }
            for (EdgeData edgeData : graphData.edges) {
                graph.addEdge(edgeData.source, edgeData.destination, edgeData.weight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return graph;
    }

    public static void main(String[] args) {
        Graph graph = loadGraphFromFile("data/small_graph.json");

        KruskalAlgorithm kruskal = new KruskalAlgorithm();
        MSTResult kruskalResult = kruskal.findMST(graph);
        kruskalResult.printResult();

        PrimAlgorithm prim = new PrimAlgorithm();
        MSTResult primResult = prim.findMST(graph);
        primResult.printResult();
    }
}