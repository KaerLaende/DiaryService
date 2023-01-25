package Task;

import TaskService.*;
import TypeOfTask.PERSONAL;
import TypeOfTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Task <T extends Type>{
    private static int idGanerator =0;
    private String title;
    private Class<? extends Type> type;
    private int id;

    private LocalDate date;

    private LocalDateTime dateTime;

    private LocalTime time;
    private String description;
    public void setId(int id) {
        this.id = id;
    }
    public Task(String title, Class<? extends Type> type, LocalDate date, LocalTime time, String description) {
        setTitle(title);
        this.type = type;
        this.id = idGanerator++;
        setDate(date);
        setTime(time);
        this.description = description;
        TaskService.add(this);
    }

    @Override
    public String toString() {
        return (type.equals(PERSONAL.class)?"ЛИЧНОЕ":"РАБОЧЕЕ")+" | Событие: " + title + " | "+ date+" "+time+"|"+"\n"+
                ">>>"+description+"<<<";  }





    //==========================Методы Getter & Setter=====================================

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null){
            this.date= LocalDate.now();
        }else {
        this.date = date;}
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        if (time == null){
            this.time= LocalTime.now();
        }else {
        this.time = time;}
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title != null && !title.isEmpty()&&!title.isBlank()) {
            this.title = title;
        } else {
            throw new IncorrectArgumentException();
        }
    }

    public Class<? extends Type> getType() {
        return type;
    }

    public void setType(Class<? extends Type> type) {
     this.type=type;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description == null || description.isEmpty() || description.isBlank()){
            throw new IncorrectArgumentException("Введите описание задачи");
        } else {
            this.description = description;
        }
    }
//======================Equals & HashCode==========================


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return  id == task.id && title.equals(task.title) && type.equals(task.type) && date.equals(task.date) && Objects.equals(description, task.description)&&time.equals(task.time) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, date,time, description);
    }


}
