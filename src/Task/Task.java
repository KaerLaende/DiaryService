package Task;

import TypeOfTask.Type;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task <T extends Type>{
    private static int idGanerator =1;
    private String title;
    Class<? extends Type> type;
    private int id;
    LocalDateTime dateTime;
    private String description;


    public Task(String title, Class<? extends Type> type,  LocalDateTime dateTime, String description) {
        this.title = title;
        this.type = type;
        this.id = idGanerator++;
        this.dateTime = dateTime;
        this.description = description;
    }

    @Override
    public String toString() {
        return type+" | Задача: " + title + " | "+ dateTime+"|"+"\n"+
                ">>>"+description+"<<<";  }

    //==========================Методы Getter & Setter=====================================


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getIdGanerator() {
        return idGanerator;
    }

    public void setIdGanerator(int idGanerator) {
        this.idGanerator = idGanerator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Class<? extends Type> getType() {
        return type;
    }

    public void setType(Class<? extends Type> type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//======================Equals & HashCode==========================


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idGanerator == task.idGanerator && id == task.id && title.equals(task.title) && type.equals(task.type) && dateTime.equals(task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGanerator, title, type, id, dateTime, description);
    }
}
