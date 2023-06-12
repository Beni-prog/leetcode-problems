package stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Create a hashmap to store the visited nodes and their copies
        Map<Node, Node> visited = new HashMap<>();

        // Start the DFS traversal from the given node
        return cloneNode(node, visited);
    }

    private static Node cloneNode(Node node, Map<Node, Node> visited) {
        //check if this node was already visited
        //if so, return its clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        //clone the current node and mark it as visited
        Node clone = new Node(node.val);
        visited.put(node, clone);

        //clone all of the current node neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneNode(neighbor, visited));
        }

        return clone;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clone = cloneGraph(node1);

        // Print the cloned graph
        System.out.println(clone.val); // Output: 1
        System.out.println(clone.neighbors.size()); // Output: 2
        System.out.println(clone.neighbors.get(0).val); // Output: 2
        System.out.println(clone.neighbors.get(1).val); // Output: 4
    }
}
