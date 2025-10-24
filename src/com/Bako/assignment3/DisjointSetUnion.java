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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DisjointSetUnion {
    private final Map<String, String> parent = new HashMap<>();
    private long operationCount = 0;

    public DisjointSetUnion(Set<String> vertices) {
        for (String vertex : vertices) {
            parent.put(vertex, vertex);
        }
    }

    public String find(String vertex) {
        operationCount++;
        if (parent.get(vertex).equals(vertex)) {
            return vertex;
        }
        String root = find(parent.get(vertex));
        parent.put(vertex, root);
        return root;
    }

    public void union(String vertex1, String vertex2) {
        operationCount++;
        String root1 = find(vertex1);
        String root2 = find(vertex2);
        if (!root1.equals(root2)) {
            parent.put(root1, root2);
        }
    }

    public long getOperationCount() {
        return operationCount;
    }
}