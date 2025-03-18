package MainFunction;

public class Appointment {
    private static int runningId = 100;
    private final String id;
    private final String nric;
    private final String date;
    private final String time;
    private final String description;

    public Appointment(String nric, String date, String time, String description) {
        this.id = "A" + runningId++;
        this.nric = nric;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getNric() {
        return nric;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[" + id + "] - " + nric + " - " + date + " " + time + " - " + description;
    }
}
