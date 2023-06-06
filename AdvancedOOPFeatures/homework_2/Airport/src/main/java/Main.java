import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport dixon = Airport.getInstance();
        System.out.println(findPlanesLeavingInTheNextTwoHours(dixon));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        Date a = new Date(System.currentTimeMillis() + 7200000);

        List<Terminal> terminal =  airport.getTerminals();
        return terminal.stream().flatMap(flight -> flight.getFlights().stream()).
                collect(Collectors.toList()).stream().filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE)).
                filter(flight -> flight.getDate().before(a) && flight.getDate().after(new Date(System.currentTimeMillis()))).
                collect(Collectors.toList());
    }

}