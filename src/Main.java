import Task.DailyTask;
import Task.*;
import Task.YearlyTask;
import TaskService.*;
import TypeOfTask.Type;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {

      // Вводные данные через переменные (по умолчанию)
        Task yearlyTask = new YearlyTask("МОЙ Д.Р", Type.PERSONAL, (LocalDate.of(2023, 3, 24)),(LocalTime.of(6, 30)),"Мой День Рождения!");
        Task weeklyTask = new WeeklyTask("Субботник", Type.PERSONAL,(LocalDate.of(2023,1,28)),(LocalTime.now()),"Делаем генеральную уборку");
        Task monthlyTask = new MonthlyTask("Выезд на природу", Type.PERSONAL,(LocalDate.of(2023,1,28)),(LocalTime.now()),"провести время на природе");
        Task dailyTask = new DailyTask("Учи Java", Type.PERSONAL,(LocalDate.of(2023,1,28)),(LocalTime.of(9, 0)),"садись учится программировать!");
        Task dailyTask1 = new DailyTask("Читай книги по Java", Type.PERSONAL,(LocalDate.of(2023,1,28)),(LocalTime.of(9, 0)),"садись читать!");
        System.out.println("Текущие события:");
        System.out.println(TaskService.getTaskMap());
      // Проверка сравнения дат:  System.out.println((Objects.equals(yearlyTask.getDate(), LocalDate.of(2023, 2, 24))?"найдено":"не найдено"));
  TaskService.getAllByDate(LocalDate.of(2023,3,24));
        System.out.println("Что бы вы хотели сделать?");
        // Вводные данные через консоль
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            deleteTask(scanner);
                            break;
                        case 3:
                            printAllTasksForDay(scanner);
                            break;
                        case 4:
                            printAllDeletedTasks();
                            break;
                        case 5:
                            updateTask(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        try {
            // Запрашиваем данные о событии:
            String title = getTitle(scanner);
            String description = getDescription(scanner);
            int taskType = getTaskType(scanner);
            Type type = taskType == 1 ? Type.WORK : Type.PERSONAL;
            int repeatType = getRepeatType(scanner);
            LocalDate date = getDate(scanner);
            LocalTime time = getLocalTime(scanner);

            // Создаём событие
            Task task = TaskService.createTask(title,type,date, time,description,repeatType);
            TaskService.add(task);
            System.out.print("Событие добавлено:");
            System.out.println(task);
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteTask(Scanner scanner) {
        int id = getId(scanner);
        try {
            TaskService.removeTask(id);
            System.out.println("Задача успешно удалена.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printAllTasksForDay(Scanner scanner) {
        System.out.print("Введите дату для получения событий и задач в формате гггг-мм-дд: ");
        String date = scanner.next();
        if (!chekDate(date)) {
            printAllTasksForDay(scanner);
            return;
        }
        LocalDate localDate = LocalDate.parse(date, DATE_FORMATTER);
        TaskService.getAllByDate(localDate);

    }


    private static void printAllDeletedTasks(){
        System.out.println("Завершенные события:");
        TaskService.printRemovedTasks();
    }

    private static void updateTask(Scanner scanner){
        int id = getId(scanner);
        try {
            Task task = TaskService.getTask(id);
            String title = getTitle(scanner);
            String description = getDescription(scanner);
            task.setTitle(title);
            task.setDescription(description);
            System.out.printf("Задача под номером %d успешно обновлена.\n", id);
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getTitle(Scanner scanner) {
        String title;
        System.out.print("Введите название задачи: ");
        do {
            title = scanner.nextLine();
        } while (title == null || title.isEmpty() || title.isBlank());
        return title;
    }
    private static int getId(Scanner scanner) {
        int id;
        do {
            System.out.print("Введите уникальный номер задачи: ");
            id = scanner.nextInt();
        } while (id < 0);
        return id;
    }

    private static String getDescription(Scanner scanner) {
        String description;
        System.out.print("Введите описание задачи: ");
        do {
            description = scanner.nextLine();
        } while (description == null || description.isEmpty() || description.isBlank());
        return description;
    }

    private static int getTaskType(Scanner scanner) {
        int taskType;
        System.out.print("Выберите тип задачи 1 - Рабочая, 2 - Личная : ");
        do {
            taskType = scanner.nextInt();
        } while (taskType > 2 || taskType < 1);
        return taskType;
    }

    private static int getRepeatType(Scanner scanner) {
        int repeatType;
        System.out.print("Выберите повторяемость задачи 1 - Одноразовая, 2 - Ежедневная, 3 - Еженедельная, 4 - Ежемесячная, 5 - Ежегодная: ");
        do {
            repeatType = scanner.nextInt();
        } while (repeatType > 5 || repeatType < 1);
        return repeatType;
    }

    private static LocalDate getDate(Scanner scanner) {
        return getDay(scanner);
    }
    private static LocalTime getLocalTime(Scanner scanner) {
        return getLTime(scanner);
    }

    private static LocalDate getDay(Scanner scanner) {
        String localDate;
        System.out.print("Введите дату выполнения в формате гггг-мм-дд: ");
        localDate = scanner.next();
        return LocalDate.parse(localDate);
    }

    private static LocalTime getLTime(Scanner scanner) {
        String localTime;
        System.out.print("Введите время выполнения в формате чч:мм ");
        localTime = scanner.next();
        return LocalTime.parse(localTime);
    }


    private static void printMenu() {
        System.out.println("1. Создать новое событие | 2. Удалить событие | 3. Получить событие на указанный день | 4. Получить все удалённые задачи/события | 5. Изменить название и описание существующей задачи | 6. Получить все события на выбранную дату. | 0. Выход");
    }

    private static boolean chekDate(String date) {
        boolean chek = false;
        try {
            LocalDate.parse(date, DATE_FORMATTER);
            chek = true;
        } catch (Exception e) {
            System.out.println("Не правильный формат даты!");
        }
        return chek;
    }


}
