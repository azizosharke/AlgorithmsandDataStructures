
/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class CompetitionDijkstra {


    private Graph graph;
    private int speedA;
    private int speedB;
    private int speedC;

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     */
    public CompetitionDijkstra(String filename, int sA, int sB, int sC) {
        try {
            this.graph = new Graph(filename);
        } catch (IOException e) {
            this.graph = null;
        }
        this.speedA = sA;
        this.speedB = sB;
        this.speedC = sC;
    }

    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition() {
        int speedMin = Math.min(Math.min(speedA, speedB), speedC);
        int speedMax = Math.max(Math.max(speedA, speedB), speedC);
        if (speedMin < 50 || speedMax > 100) return -1;
        double nodesDistance = getMaxDistance();
        if (nodesDistance <= 0) return -1;
        return (int) Math.ceil((nodesDistance * 1000) / speedMin);
    }

    /**
     * @return the distance of the two vertices which are the furthest from each other
     */
    private double getMaxDistance() {
        if (graph == null || graph.invalid) return -1;
        int verticsA = graph.verticsA;
        double maxDistance = Double.NEGATIVE_INFINITY;
        for (int n = 0; n < verticsA; n++) {
            double[] distances = generateShortestPaths(n);
            for (int m = 0; m < verticsA; m++) {
                if (n == m) continue;
                double distanceB = distances[m];
                if (distanceB == Double.POSITIVE_INFINITY) return -1;
                maxDistance = Math.max(maxDistance, distanceB);
            }
        }
        return maxDistance;
    }

    /**
     * @return the shortest path table generated using dijkstra's algorithm
     */
    private double[] generateShortestPaths(int startVertex) {
        Map<Integer, List<Edge>> adj = graph.adj;
        boolean[] seen = new boolean[graph.verticsA];
        double[] distanceTo = new double[graph.verticsA];
        Arrays.fill(distanceTo, Double.POSITIVE_INFINITY);
        distanceTo[startVertex] = 0;
        Queue<Integer> priorityQueue =
                new PriorityQueue<>(Comparator.comparing(vertex -> distanceTo[vertex]));
        priorityQueue.add(startVertex);
        while (!priorityQueue.isEmpty()) {
            int curr = priorityQueue.poll();
            seen[curr] = true;
            for (Edge adjacent : adj.getOrDefault(curr, new ArrayList<>())) {
                int vertex = adjacent.edgeB;
                if (!seen[vertex]) {
                    double newDistance = distanceTo[curr] + adjacent.cost;
                    if (newDistance < distanceTo[vertex]) distanceTo[vertex] = newDistance;
                    priorityQueue.remove(vertex);
                    priorityQueue.add(vertex);
                }
            }
        }
        return distanceTo;
    }

    private static class Graph {
        private Map<Integer, List<Edge>> adj;
        private int verticsA;
        private boolean invalid;

        private Graph(String filename) throws IOException {
            if (filename == null || "".equals(filename)) return;
            adj = new HashMap<>();
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            this.verticsA = Integer.parseInt(bf.readLine());
            int edge = Integer.parseInt(bf.readLine());
            int i = 0;
            String line = bf.readLine();
            while (line != null) {
                Scanner scanner = new Scanner(line);
                int vertexFrom = scanner.nextInt();
                int vertexTo = scanner.nextInt();
                double cost = scanner.nextDouble();
                List<Edge> adjList = adj.getOrDefault(vertexFrom, new ArrayList<>());
                adjList.add(new Edge(vertexFrom, vertexTo, cost));
                adj.put(vertexFrom, adjList);
                scanner.close();
                line = bf.readLine();
                i++;
            }
            if (i != edge) this.invalid = true;
        }
    }

    private static class Edge {
        private int edgeA;
        private int edgeB;
        double cost;

        private Edge(int edgeA, int edgeB, double cost) {
            this.edgeA = edgeA;
            this.edgeB = edgeB;
            this.cost = cost;
        }
    }
}