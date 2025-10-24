package com.Bako.assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {
    public MSTResult findMST(Graph graph) {
        long startTime = System.nanoTime();
        long operationCount = 0;

        List<Edge> allEdges = new ArrayList<>(graph.getAllEdges());
        Collections.sort(allEdges);
        operationCount += allEdges.size() * Math.log(allEdges.size());

        DisjointSetUnion dsu = new DisjointSetUnion(graph.getVertices());

        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;

        for (Edge edge : allEdges) {
            operationCount++;
            String root1 = dsu.find(edge.getSource());
            String root2 = dsu.find(edge.getDestination());

            if (!root1.equals(root2)) {
                mstEdges.add(edge);
                totalCost += edge.getWeight();
                dsu.union(edge.getSource(), edge.getDestination());
            }

            if (mstEdges.size() == graph.getVertices().size() - 1) {
                break;
            }
        }

        long endTime = System.nanoTime();
        long executionTimeMs = (endTime - startTime) / 1_000_000;

        operationCount += dsu.getOperationCount();

        return new MSTResult("Kruskal's Algorithm", mstEdges, totalCost, executionTimeMs, operationCount);
    }
}