package com.fishercoder.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 685. Redundant Connection II
 * <p>
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are
 * descendants of this node, plus every node has exactly one parents, except for the root node which has no parents.
 * The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N),
 * with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that
 * represents a directed edge connecting nodes u and v, where u is a parents of child v.
 * Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes.
 * If there are multiple answers, return the answer that occurs last in the given 2D-array.
 * <p>
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given directed graph will be like this:
 * 1
 * / \
 * v   v
 * 2-->3
 * <p>
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * Output: [4,1]
 * Explanation: The given directed graph will be like this:
 * 5 <- 1 -> 2
 * ^    |
 * |    v
 * 4 <- 3
 * <p>
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class _685 {
    public static class Solution1 {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            UnionFind unionFind = new UnionFind(edges);
            /**two cases:
             * 1. the entire edges are just one directed loop, in this case, just return the last edge, see test2 in _685Test.java
             * 2. there's one directed loop, but one node of the loop has two parents, in this case, what we'll need to do
             * is just to return the edge in this loop that points to the child that has two parents, see test1 in _685Test.java
             * also, in case 2, use the id of the node that has two parents as the id for all nodes in this loop, this way, I could know which of its
             * two parents is in the loop and should be the redundant one to return.
             * */
            for (int[] edge : edges) {
                unionFind.union(edge);
            }
            return unionFind.findRedundantDirectedConnection();
        }

        /**
         * My original solution, failed by _685Test.test3
         */
        class UnionFind {
            int[] ids;
            Set<Integer> nodes;
            int[][] edges;
            List<LinkedNode> visitedLinkedNodes;
            Set<Integer> visitedValues;
            int[] redundantConn;
            int m;
            int n;

            public UnionFind(int[][] edges) {
                this.edges = edges;
                m = edges.length;
                n = edges[0].length;
                nodes = new HashSet<>();
                visitedLinkedNodes = new ArrayList<>();
                visitedValues = new HashSet<>();
                redundantConn = new int[]{};
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        nodes.add(edges[i][j]);
                    }
                }
                ids = new int[nodes.size()];
                for (int i = 0; i < ids.length; i++) {
                    ids[i] = i + 1;
                }
            }

            public void union(int[] edge) {
                if (!visitedValues.contains(edge[1])) {
                    LinkedNode parent = new LinkedNode(edge[0]);
                    LinkedNode node = new LinkedNode(edge[1], parent);
                    visitedLinkedNodes.add(node);
                    visitedValues.add(edge[1]);
                } else {
                    for (int i = 0; i < visitedLinkedNodes.size(); i++) {
                        LinkedNode node = visitedLinkedNodes.get(i);
                        if (node.val == edge[1]) {
                            node.addParent(new LinkedNode(edge[0]));
                        }
                    }
                }
            }

            public int[] findRedundantDirectedConnection() {
                int index = hasTwoParents();
                if (index != -1) {
                    List<LinkedNode> parents = visitedLinkedNodes.get(index).parents;//parents size is fixed, only 2
                    int[] result = new int[2];
                    for (int i = 0; i < parents.size(); i++) {
                        if (hasCycle(visitedLinkedNodes.get(index), parents.get(i))) {
                            result = new int[]{parents.get(i).val, visitedLinkedNodes.get(index).val};
                            break;
                        }
                    }
                    return result;
                } else {
                    return edges[m - 1];
                }
            }

            private boolean hasCycle(LinkedNode linkedNode, LinkedNode parent) {
                Set<Integer> visited = new HashSet<>();
                visited.add(linkedNode.val);
                while (parent != null) {
                    if (visited.contains(parent.val)) {
                        return true;
                    }
                    visited.add(parent.val);
                    parent = findParent(parent.val);
                }
                return false;
            }

            private LinkedNode findParent(int val) {
                for (int i = 0; i < visitedLinkedNodes.size(); i++) {
                    if (visitedLinkedNodes.get(i).val == val) {
                        return visitedLinkedNodes.get(i).parents.get(0);
                    }
                }
                return null;
            }

            private int hasTwoParents() {
                for (int i = 0; i < visitedLinkedNodes.size(); i++) {
                    if (visitedLinkedNodes.get(i).parents.size() > 1) {
                        return i;
                    }
                }
                return -1;
            }

            class LinkedNode {
                List<LinkedNode> parents;//at most, there's one node that has two parents
                int val;

                public LinkedNode(int val) {
                    this.val = val;
                }

                public LinkedNode(int val, LinkedNode parent) {
                    if (parents == null) {
                        parents = new ArrayList<>();
                    }
                    this.parents.add(parent);
                    this.val = val;
                }

                public void addParent(LinkedNode parent) {
                    if (parents == null) {
                        parents = new ArrayList<>();
                    }
                    this.parents.add(parent);
                }
            }
        }
    }

    public static class Solution2 {
        /**
         * credit: https://discuss.leetcode.com/topic/105108/c-java-union-find-with-explanation-o-n
         */
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int[] can1 = {-1, -1};
            int[] can2 = {-1, -1};
            int[] parent = new int[edges.length + 1];
            for (int i = 0; i < edges.length; i++) {
                if (parent[edges[i][1]] == 0) {
                    parent[edges[i][1]] = edges[i][0];
                } else {
                    can2 = new int[]{edges[i][0], edges[i][1]};
                    can1 = new int[]{parent[edges[i][1]], edges[i][1]};
                    edges[i][1] = 0;
                }
            }
            for (int i = 0; i < edges.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < edges.length; i++) {
                if (edges[i][1] == 0) {
                    continue;
                }
                int child = edges[i][1];
                int father = edges[i][0];
                if (root(parent, father) == child) {
                    if (can1[0] == -1) {
                        return edges[i];
                    }
                    return can1;
                }
                parent[child] = father;
            }
            return can2;
        }

        int root(int[] parent, int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
    }
}
