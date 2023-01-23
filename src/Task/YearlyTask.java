package Task;

import TypeOfTask.Type;

import java.time.LocalDateTime;

public class YearlyTask<T extends Type> extends Task {
    public YearlyTask(String title, Class<? extends Type> type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }
}
