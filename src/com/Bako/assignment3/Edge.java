package com.Bako.assignment3;

public class Edge implements Comparable<Edge> {
    private final String source;
    private final String destination;
    private final int weight;

    public Edge(String source, String destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return source + " - " + destination + " (" + weight + ")";
    }
}