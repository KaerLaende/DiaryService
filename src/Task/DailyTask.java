package Task;

import TaskService.TaskService;
import TypeOfTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DailyTask extends Task {


    public DailyTask(String title, Type type, LocalDate date, LocalTime time, String description) {
        super(title, type, date, time, description);
        for (int i = 1; i <=30; i++) {
            TaskService.add(cloneTask(this,i));
        }
    }
    public static DailyTask cloneTask(Task task, int i) {
        DailyTask newTask= null;
        try {
            newTask = (DailyTask) task.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        newTask.setDate(task.getDate().plusWeeks(i));
        newTask.setId(4000+i);
        return newTask;


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

