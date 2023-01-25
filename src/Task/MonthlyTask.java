package Task;

import TaskService.TaskService;
import TypeOfTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MonthlyTask extends Task{

    public MonthlyTask(String title, Class type,  LocalDate date, LocalTime time, String description) {
        super(title, type, date, time, description);
        for (int i = 1; i < 2; i++) {
            TaskService.add(cloneTask(this,i));
        }
    }
    public static MonthlyTask cloneTask(Task task, int i) {
        MonthlyTask newTask= null;
        try {
            newTask = (MonthlyTask) task.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        newTask.setDate(task.getDate().plusMonths(i));
        newTask.setId(2000+i);
        return newTask;
    }

    public LocalDate getNextDay(Task t) {
        return t.getDate().plusMonths(1);
    }
    @Override
    public String toString() {
        return super.toString() + "Ежемесячная|" +
                "Следующее повторение: " + getNextDay(this) + "|"+"\n";
    }
}
