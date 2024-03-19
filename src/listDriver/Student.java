package listDriver;

public class Student {
    private final String name;
    private int ID;
    public Student(String name, int ID){
        this.name = name;
        this.ID = ID;
    }
    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public boolean equals(Object obj){

        if(obj instanceof Student){
            obj = obj;
            ID = getID();
            return ID == ((Student) obj).getID();
        }

        return false;
    }

    public String toString(){

        return  getID() +  " " + getName();
    }


}
