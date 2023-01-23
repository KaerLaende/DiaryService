package Task;

import TypeOfTask.Type;

import java.time.LocalDateTime;

public class DailyTask<T extends Type> extends Task {

    public DailyTask(String title, Class<? extends Type> type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }


}
