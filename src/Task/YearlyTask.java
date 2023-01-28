package Task;

import TaskService.TaskService;
import TypeOfTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class YearlyTask extends Task {

    public YearlyTask(String title, Type type, LocalDate date, LocalTime time, String description) {
        super(title, type,  date, time, description);

        for (int i = 1; i < 100; i++) {// простите рука не поднялась изменить количество повторов на меньшее...
            TaskService.add(cloneTask(this,i));
        }
    }
    public static YearlyTask cloneTask(Task task, int i) {
        YearlyTask newTask= null;
        try {
             newTask = (YearlyTask) task.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        newTask.setDate(task.getDate().plusYears(i));
        newTask.setId(1000+i);
        return newTask;
    }

    public LocalDate getNextDay(Task t) {
        return t.getDate().plusYears(1);
    }
    @Override
    public String toString() {
        return super.toString() + "Ежегодная|" +
                "Следующее повторение: " + getNextDay(this) + "|"+"\n";
    }


}
