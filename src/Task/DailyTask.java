package Task;

import TaskService.TaskService;
import TypeOfTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DailyTask<T extends Type> extends Task {


    public DailyTask(String title, Class type, LocalDate date, LocalTime time, String description) {
        super(title, type, date, time, description);
    }
    public LocalDate getNextDay(Task t) {
       return t.getDate().plusDays(1);
    }
    @Override
    public String toString() {
        return super.toString() + "Ежедневная|" +
                "Следующее повторение: " + getNextDay(this) + "|"+"\n";
    }
}

