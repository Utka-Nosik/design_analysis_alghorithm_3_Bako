package com.Bako.assignment3;

import java.util.*;

public class PrimAlgorithm {
    public MSTResult findMST(Graph graph) {
        long startTime = System.nanoTime();
        long operationCount = 0;

        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;
        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        Set<String> vertices = graph.getVertices();
        if (vertices.isEmpty()) {
            return new MSTResult("Prim's Algorithm", mstEdges, 0, 0, 0);
        }

        String startVertex = vertices.iterator().next();
        visited.add(startVertex);
        operationCount++;

        List<Edge> initialEdges = graph.getEdges(startVertex);
        pq.addAll(initialEdges);
        operationCount += initialEdges.size();

        while (!pq.isEmpty() && visited.size() < vertices.size()) {
            Edge currentEdge = pq.poll();
            operationCount++;

            String destination = currentEdge.getDestination();
            if (visited.contains(destination)) {
                continue;
            }

            visited.add(destination);
            mstEdges.add(currentEdge);
            totalCost += currentEdge.getWeight();
            operationCount++;

            List<Edge> newEdges = graph.getEdges(destination);
            for (Edge edge : newEdges) {
                operationCount++;
                if (!visited.contains(edge.getDestination())) {
                    pq.add(edge);
                }
            }
        }

        long endTime = System.nanoTime();
        long executionTimeMs = (endTime - startTime) / 1_000_000;

        return new MSTResult("Prim's Algorithm", mstEdges, totalCost, executionTimeMs, operationCount);
    }
}