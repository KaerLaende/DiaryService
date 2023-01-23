package Task;

import TypeOfTask.Type;

import java.time.LocalDateTime;

public class OneTimeTask<T extends Type> extends Task{
    public OneTimeTask(String title, Class<? extends Type> type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }
}
