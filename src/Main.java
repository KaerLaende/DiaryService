import Task.DailyTask;
import Task.Task;
import Task.YearlyTask;
import TypeOfTask.PERSONAL;
import TypeOfTask.WORK;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("");
        Task dailyTask1 = new YearlyTask("МОЙ Д.Р", PERSONAL.class, (LocalDateTime.of(2022, 03, 24, 06, 30)), "Мой День Рождения!");
        System.out.println(dailyTask1);
    }
}