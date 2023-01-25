package Task;

import TypeOfTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class WeeklyTask extends Task {

    public WeeklyTask(String title, Class type,  LocalDate date, LocalTime time, String description) {
        super(title, type, date, time, description);
    }
    public LocalDate getNextDay(Task t) {
        return t.getDate().plusWeeks(1);
    }
    @Override
    public String toString() {
        return super.toString() + "Еженедельная|" +
                "Следующее повторение: " + getNextDay(this) + "|"+"\n";
    }

}
