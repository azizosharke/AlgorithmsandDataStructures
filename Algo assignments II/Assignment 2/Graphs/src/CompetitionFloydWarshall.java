
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
 * This class implements the competition using Floyd-Warshall algorithm
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class CompetitionFloydWarshall {

    private double[][] distanceA;
    private int speedA;
    private int speedB;
    private int speedC;
    private int verticsNumber;
    private boolean invalid;

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     */
    public CompetitionFloydWarshall(String filename, int sA, int sB, int sC) {
        try {
            initialiseDistanceArray(filename);
        } catch (IOException e) {
            this.invalid = true;
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
        generateDistanceArray();
        double nodesDistance = getMaxDistance();
        if (nodesDistance <= 0) return -1;
        return (int) Math.ceil((nodesDistance * 1000) / speedMin);
    }

    /**
     * @return the distance of the two vertices which are the furthest from each other
     */
    private double getMaxDistance() {
        if (this.invalid || distanceA == null) return -1;
        double maxDistance = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < this.verticsNumber; i++) {
            for (int j = 0; j < this.verticsNumber; j++) {
                if (i == j) continue;
                double distanceTo = distanceA[i][j];
                if (distanceTo == Double.POSITIVE_INFINITY) return -1;
                maxDistance = Math.max(maxDistance, distanceTo);
            }
        }
        return maxDistance;
    }

    /**
     Runs floyd warshall's algorithm on the graph
     */
    private void generateDistanceArray() {
        if (this.invalid) return;
        for (int k = 0; k < this.verticsNumber; k++)
            for (int i = 0; i < this.verticsNumber; i++)
                for (int j = 0; j < this.verticsNumber; j++)
                    if (distanceA[i][k] + distanceA[k][j] < distanceA[i][j])
                        distanceA[i][j] = distanceA[i][k] + distanceA[k][j];
    }

    private void initialiseDistanceArray(String filename) throws IOException {
        if (filename == null || "".equals(filename)) return;
        BufferedReader br = new BufferedReader(new FileReader(filename));
        this.verticsNumber = Integer.parseInt(br.readLine());
        this.distanceA = new double[this.verticsNumber][this.verticsNumber];
        for (double[] distance : distanceA) {
            Arrays.fill(distance, Double.POSITIVE_INFINITY);
        }
        int edgeNumber = Integer.parseInt(br.readLine());
        int i = 0;
        String line = br.readLine();
        while (line != null) {
            Scanner scanner = new Scanner(line);
            int vertexA = scanner.nextInt();
            int vertexB = scanner.nextInt();
            double cost = scanner.nextDouble();
            distanceA[vertexA][vertexA] = 0;
            distanceA[vertexA][vertexB] = cost;
            scanner.close();
            line = br.readLine();
            i++;
        }
        if (i != edgeNumber) this.invalid = true;
    }
}