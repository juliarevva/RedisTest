package org.example;

public class Station {

    private Line line;
    private String stationName;
    private String connected;
    private String depth;
    private String date;

    public Station(Line line, String stationName) {
        this.line = line;
        this.stationName = stationName;
    }

    public String getLineNumber()
    {
        return line.getNumber();
    }
    public String getStationName()
    {
        return stationName;
    }
    public String getConnected() { return connected; }
    public String getDepth() {
        return depth;
    }
    public String getDate() {
        return date;
    }

    public void setConnected(String connected) {
        this.connected = connected;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setDepth(String depth) {
        this.depth = depth;
    }

    @Override
    public String toString()
    {
        return stationName + " - " +
                line.getNumber() + " - " +
                depth + " - " +
                date + " - " +
                connected;
    }
}
