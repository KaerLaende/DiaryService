package Task;

import TypeOfTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class YearlyTask<T extends Type> extends Task {

    public YearlyTask(String title, Class type, LocalDate date, LocalTime time, String description) {
        super(title, type,  date, time, description);
    }
    public LocalDate getNextDay(Task t) {
        return t.getDate().plusYears(1);
    }
    @Override
    public String toString() {
        return super.toString() + "Ежегодная|" +
                "Следующее повторение: " + getNextDay(this) + "|"+"\n";
    }
}
