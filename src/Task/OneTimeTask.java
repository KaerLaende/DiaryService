package Task;

import TypeOfTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OneTimeTask extends Task{

    public OneTimeTask(String title, Type type,  LocalDate date, LocalTime time, String description) {
        super(title, type, date, time, description);
    }

    @Override
    public String toString() {
        return super.toString() + " | Сделай! ..и возвращатся к этому не придется! |"+"\n";
    }
}
