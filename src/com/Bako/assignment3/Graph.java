package com.Bako.assignment3;

import java.util.*;

public class Graph {
    private final Set<String> vertices = new HashSet<>();
    private final List<Edge> allEdges = new ArrayList<>();
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public void addVertex(String vertex) {
        vertices.add(vertex);
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String source, String destination, int weight) {
        if (!vertices.contains(source) || !vertices.contains(destination)) {
            throw new IllegalArgumentException("One or both vertices not in graph");
        }

        Edge edge = new Edge(source, destination, weight);
        allEdges.add(edge);

        adjacencyList.get(source).add(edge);

        // Поскольку граф неориентированный, добавляем ребро и для второй вершины
        Edge reverseEdge = new Edge(destination, source, weight);
        adjacencyList.get(destination).add(reverseEdge);
    }

    public Set<String> getVertices() {
        return vertices;
    }

    public List<Edge> getAllEdges() {
        return allEdges;
    }

    public List<Edge> getEdges(String vertex) {
        return adjacencyList.getOrDefault(vertex, Collections.emptyList());
    }
}