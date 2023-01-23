package Task;

import TypeOfTask.Type;

import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, Class<? extends Type> type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }
}
