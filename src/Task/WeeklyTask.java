package Task;

import TaskService.TaskService;
import TypeOfTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class WeeklyTask extends Task {

    public WeeklyTask(String title, Type type,  LocalDate date, LocalTime time, String description) {
        super(title, type, date, time, description);
        for (int i = 1; i <= 4; i++) {
            TaskService.add(cloneTask(this,i));
        }
    }
    public static WeeklyTask cloneTask(Task task, int i) {
        WeeklyTask newTask= null;
        try {
            newTask = (WeeklyTask) task.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        newTask.setDate(task.getDate().plusWeeks(i));
        newTask.setId(3000+i);
        return newTask;

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
