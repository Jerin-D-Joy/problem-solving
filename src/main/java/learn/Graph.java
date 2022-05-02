package learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    static class GraphNode {
        int value;
        List<GraphNode> children;
        boolean visited;

        public GraphNode(int value) {
            this.value = value;
            this.children = null;
        }

        public void addChild(GraphNode node) {
            if(this.children == null || this.children.size() == 0) {
                this.children = new ArrayList<>();
            }
            this.children.add(node);
        }
    }

    GraphNode root;

    public void breadthFirstTraversal() {
        if(root == null) return;
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(root);
        GraphNode popped;
        while ((popped = queue.poll()) != null) {
            if(popped.visited) continue;
            System.out.print(" -> " + popped.value);
            popped.visited = true;
            if(popped.children != null) {
                queue.addAll(popped.children);
            }
        }
    }

    public void depthFirstTraversal(GraphNode node) {
        if(node == null) return;
        System.out.print(node.value + " -> ");
        node.visited = true;
        if(node.children == null) return;
        for(GraphNode child : node.children) {
            if(!child.visited) {
                depthFirstTraversal(child);
            }
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph();
        GraphNode root = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);
        GraphNode five = new GraphNode(5);
        GraphNode six = new GraphNode(6);
        root.addChild(two);
        root.addChild(three);
        two.addChild(four);
        three.addChild(four);
        three.addChild(six);
        four.addChild(five);
        graph.root = root;
        //graph.breadthFirstTraversal();
        graph.depthFirstTraversal(graph.root);
    }

}
