package kodilla.com.good.patterns.challenges.flights;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Flight {

    private final String from;
    private final String to;
    private final String via;
    private final LocalDateTime date;

    public Flight(String from, String to, String via, LocalDateTime date) {
        this.from = from;
        this.to = to;
        this.via = via;
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getVia() {
        return via;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!Objects.equals(from, flight.from)) return false;
        if (!Objects.equals(to, flight.to)) return false;
        if (!Objects.equals(via, flight.via)) return false;
        return Objects.equals(date, flight.date);
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (via != null ? via.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        final StringBuilder sb = new StringBuilder("Flight{");
        sb.append("from: '").append(from).append('\'');
        sb.append(", to: '").append(to).append('\'');
        sb.append(", via: '").append(via).append('\'');
        sb.append(", date: ").append(date.format(format));
        sb.append('}');
        return sb.toString();
    }
}
