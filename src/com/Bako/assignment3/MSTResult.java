package com.Bako.assignment3;

import java.util.List;

public class MSTResult {
    private final String algorithmName;
    private final List<Edge> mstEdges;
    private final int totalCost;
    private final long executionTimeMs;
    private long operationCount;

    public MSTResult(String algorithmName, List<Edge> mstEdges, int totalCost, long executionTimeMs, long operationCount) {
        this.algorithmName = algorithmName;
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.executionTimeMs = executionTimeMs;
        this.operationCount = operationCount;
    }

    public void printResult() {
        System.out.println("\n--- Results for " + algorithmName + " ---");
        System.out.println("Execution Time: " + executionTimeMs + " ms");
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Operation Count: " + operationCount);
        System.out.println("Edges in MST:");
        for (Edge edge : mstEdges) {
            System.out.println("- " + edge);
        }
    }
}