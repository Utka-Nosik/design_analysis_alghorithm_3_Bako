# Assignment 3: Optimization of a City Transportation Network (MST)

This project implements and analyzes Prim's and Kruskal's algorithms to find the Minimum Spanning Tree (MST) for a given city's transportation network. The goal is to connect all city districts with the minimum possible total construction cost.

# 1. Summary of Results

The algorithms were tested on three datasets of varying sizes and densities. The key performance metrics were collected and are summarized in the table below. The full, detailed output can be found in `results/output.json` and the summary is in `results/summary.csv`.

| Graph Name                | Vertices | Edges | Algorithm           | Total Cost | Execution Time (ms) | Operation Count |
|---------------------------|----------|-------|---------------------|------------|---------------------|-----------------|
| Small City Example        | 4        | 5     | Kruskal's Algorithm | 19         | 0                   | 33              |
| Small City Example        | 4        | 5     | Prim's Algorithm    | 19         | 0                   | 18              |
| Medium City Network       | 12       | 22    | Kruskal's Algorithm | 136        | 0                   | 155             |
| Medium City Network       | 12       | 22    | Prim's Algorithm    | 136        | 0                   | 67              |
| Large Metropolitan Area   | 25       | 50    | Kruskal's Algorithm | 460        | 0                   | 402             |
| Large Metropolitan Area   | 25       | 50    | Prim's Algorithm    | 460        | 0                   | 153             |


## 2. Comparison of Prim's and Kruskal's Algorithms

### Theoretical Efficiency

*   **Kruskal's Algorithm:** The time complexity is **O(E log E)**, where E is the number of edges. The performance is dominated by the initial step of sorting all edges in the graph.
*   **Prim's Algorithm:** The time complexity is **O(E log V)**, where V is the number of vertices, when implemented with a binary heap (Java's `PriorityQueue`). Its performance depends on the number of edges and vertices.

### Performance in Practice

Based on the results from the summary table:

*   **On the small graph:** [Describe your findings. For example: "On the small graph, the performance difference in both execution time and operation count was negligible, with both algorithms completing almost instantly."]
*   **On medium and large graphs:** [Analyze the results from your CSV. Which was faster? Which had more operations? For example: "As the graph size increased, Prim's algorithm demonstrated a slightly better execution time compared to Kruskal's. This is reflected in the operation count, where Prim's algorithm consistently performed fewer key operations. This suggests that for the given graph densities, the cost of maintaining the priority queue in Prim's was lower than the cost of sorting all edges in Kruskal's."]

## 3. Conclusions

Based on the theoretical analysis and practical results, the following conclusions can be drawn:

1.  **Correctness:** Both algorithms are correct. They successfully found the Minimum Spanning Tree for all datasets, confirmed by the identical **Total Cost** in every test case.
2.  **Performance and Preferability:**
    *   **Kruskal's Algorithm** is generally preferred for **sparse graphs** (where the number of edges, E, is only slightly larger than the number of vertices, V). Its implementation is straightforward, and the O(E log E) complexity is very effective when E is small.
    *   **Prim's Algorithm** is typically more efficient for **dense graphs** (where the number of edges, E, approaches V²). In such cases, O(E log V) is superior to O(E log E). My results on the large graph seem to align with this, showing Prim's to be slightly more performant.
3.  **Implementation Complexity:**
    *   Kruskal's algorithm required implementing a separate **Disjoint Set Union (DSU)** data structure for efficient cycle detection.
    *   Prim's algorithm was implemented more concisely using Java's built-in `PriorityQueue`, which abstracted away the complexity of finding the next minimum-weight edge.

## 4. Bonus Section: Graph Design in Java

This project includes a custom graph data structure implemented in `Graph.java` and `Edge.java`.

*   The graph is represented using an **adjacency list** (`Map<String, List<Edge>>`), which is an efficient choice for storing sparse to moderately dense graphs and works well with both Prim's and Kruskal's algorithms.
*   The `Edge` class implements the `Comparable` interface, which was essential for sorting edges in Kruskal's algorithm and for ordering them in the `PriorityQueue` for Prim's algorithm.
*   This design promotes a **clean architecture** by separating the data representation (the `Graph` class) from the algorithmic logic, making the code more modular, readable, and easier to test.
