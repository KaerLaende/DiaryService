package TypeOfTask;

public class Type implements Cloneable {


    public void values(){}
    public void valuesOf(String s){
        System.out.println(s);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

