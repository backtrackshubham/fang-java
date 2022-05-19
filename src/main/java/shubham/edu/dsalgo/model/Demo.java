package shubham.edu.dsalgo.model;

import java.util.Optional;

public class Demo {
    public int x;
    private String y;
    public Optional<String> opt = Optional.ofNullable(null);

    public Demo(int value, String strValue){
        this.x = value;
        this.y = strValue;
    }

    public Demo(Demo demo){
        this.x = demo.x;
        this.y = demo.y;
    }

     public Demo getValue(){
        return this;
     }
}
