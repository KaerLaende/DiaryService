package Task;

import TypeOfTask.Type;

import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, Class<? extends Type> type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }
}
