import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompetitionTests {


    @Test
    public void testFWConstructor() {
        CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall(null, 55, 60, 75);
        assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());

        competitionFloydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 55, 60, 75);
        assertEquals(34, competitionFloydWarshall.timeRequiredforCompetition());



        competitionFloydWarshall = new CompetitionFloydWarshall("input-N.txt", 55, 60, 75);
        assertEquals(146, competitionFloydWarshall.timeRequiredforCompetition());


        competitionFloydWarshall = new CompetitionFloydWarshall("input-M.txt", 55, 60, 75);
        assertEquals(273, competitionFloydWarshall.timeRequiredforCompetition());

        competitionFloydWarshall = new CompetitionFloydWarshall("input-L.txt", 55, 60, 75);
        assertEquals(146, competitionFloydWarshall.timeRequiredforCompetition());


        competitionFloydWarshall = new CompetitionFloydWarshall("input-K.txt", 55, 60, 75);
        assertEquals(291, competitionFloydWarshall.timeRequiredforCompetition());

        competitionFloydWarshall = new CompetitionFloydWarshall("input-J.txt", 55, 60, 75);
        assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());

        competitionFloydWarshall = new CompetitionFloydWarshall("input-I.txt", 55, 60, 75);
        assertEquals(219, competitionFloydWarshall.timeRequiredforCompetition());

        competitionFloydWarshall = new CompetitionFloydWarshall("input-G.txt", 55, 60, 75);
        assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());

        competitionFloydWarshall = new CompetitionFloydWarshall("input-F.txt", 55, 60, 75);
        assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());

        competitionFloydWarshall = new CompetitionFloydWarshall("input-D.txt", 55, 60, 75);
        assertEquals(34, competitionFloydWarshall.timeRequiredforCompetition());

        competitionFloydWarshall = new CompetitionFloydWarshall("input-C.txt", 55, 60, 75);
        assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());


        competitionFloydWarshall = new CompetitionFloydWarshall("input-B.txt", 55, 60, 75);
        assertEquals(9091, competitionFloydWarshall.timeRequiredforCompetition());


        competitionFloydWarshall = new CompetitionFloydWarshall("input-A.txt", 55, 60, 75);
        assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());


        competitionFloydWarshall = new CompetitionFloydWarshall("doesn't exist", 55, 60, 75);
        assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());
    }

    @Test
    public void testDijkstraConstructor() {
        CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra(null, 55, 60, 75);
        assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());
        competitionDijkstra = new CompetitionDijkstra("doesn't exist", 55, 60, 75);
        assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());

        //competitionDijkstra = new CompetitionDijkstra("tinyEWD.txt", 55, 60, 75);
        //assertEquals(34, competitionDijkstra.timeRequiredforCompetition());

        competitionDijkstra = new CompetitionDijkstra("input-I.txt", 55, 60, 75);
        assertEquals(219, competitionDijkstra.timeRequiredforCompetition());

        competitionDijkstra = new CompetitionDijkstra("input-J.txt", 55, 60, 75);
        assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());


        competitionDijkstra = new CompetitionDijkstra("input-C.txt", 55, 60, 75);
        assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());
        competitionDijkstra = new CompetitionDijkstra("input-D.txt", 55, 60, 75);
        assertEquals(34, competitionDijkstra.timeRequiredforCompetition());
        competitionDijkstra = new CompetitionDijkstra("input-K.txt", 55, 60, 75);
        assertEquals(291, competitionDijkstra.timeRequiredforCompetition());

        competitionDijkstra = new CompetitionDijkstra("input-L.txt", 55, 60, 75);
        assertEquals(146, competitionDijkstra.timeRequiredforCompetition());

        competitionDijkstra = new CompetitionDijkstra("input-F.txt", 55, 60, 75);
        assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());
        competitionDijkstra = new CompetitionDijkstra("input-G.txt", 55, 60, 75);
        assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());

        competitionDijkstra = new CompetitionDijkstra("input-A.txt", 55, 60, 75);
        assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());
        competitionDijkstra = new CompetitionDijkstra("input-B.txt", 55, 60, 75);
        assertEquals(9091, competitionDijkstra.timeRequiredforCompetition());

        competitionDijkstra = new CompetitionDijkstra("input-M.txt", 55, 60, 75);
        assertEquals(273, competitionDijkstra.timeRequiredforCompetition());

        competitionDijkstra = new CompetitionDijkstra("input-N.txt", 55, 60, 75);
        assertEquals(146, competitionDijkstra.timeRequiredforCompetition());




    }


}
