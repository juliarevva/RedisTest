import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    StationIndex stationIndex = new StationIndex();

    Line line1 = new Line(1, "Первая");
    Line line2 = new Line(2, "Вторая");
    Line line3 = new Line(3, "Третья");

    Station station0 = new Station("Станция0", line1);
    Station station1 = new Station("Станция1", line1);
    Station station2 = new Station("Станция2", line2);
    Station station3 = new Station("Станция3", line2);
    Station station4 = new Station("Станция4", line3);
    Station station5 = new Station("Станция5", line3);

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();

        line1.addStation(station0);
        line1.addStation(station1);
        line2.addStation(station2);
        line2.addStation(station3);
        line3.addStation(station4);
        line3.addStation(station5);

        List<Station> connection1 = new ArrayList<>();
        List<Station> connection2 = new ArrayList<>();
        connection1.add(station1);
        connection1.add(station2);
        connection2.add(station3);
        connection2.add(station4);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addStation(station0);
        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);

        stationIndex.addConnection(connection1);
        stationIndex.addConnection(connection2);

        route.add(station0);
        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);
    }

    public void testCalculateDuration() {

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);

    }

    public void testGetRouteWithTwoConnections() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

        Station from = stationIndex.getStation("Станция0", 1);
        Station to = stationIndex.getStation("Станция4", 3);

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        List<Station> expected = Arrays.asList(route.get(0), route.get(1),
                route.get(2), route.get(3), route.get(4));

        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

        Station from = stationIndex.getStation("Станция0", 1);
        Station to = stationIndex.getStation("Станция2", 2);

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        List<Station> expected = Arrays.asList(route.get(0), route.get(1), route.get(2));

        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

        Station from = stationIndex.getStation("Станция0", 1);
        Station to = stationIndex.getStation("Станция1", 1);

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        List<Station> expected = Arrays.asList(route.get(0),route.get(1));

        assertEquals(expected, actual);
    }

    public void testGetShortestRoute() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

        Station from = stationIndex.getStation("Станция0", 1);
        Station to = stationIndex.getStation("Станция5", 3);

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        List<Station> expected = Arrays.asList(route.get(0),route.get(1),
                route.get(2),route.get(3),route.get(4),route.get(5));

        assertEquals(expected, actual);

    }
}