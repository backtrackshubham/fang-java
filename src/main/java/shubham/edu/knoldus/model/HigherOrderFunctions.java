package shubham.edu.knoldus.model;

public class HigherOrderFunctions implements Test{

    public SomeFunctional getStringI() {
        return x -> "toStr called" + x;
    }
}

interface Test{
    default String getString(){
        return "";
    }
}

@FunctionalInterface
interface SomeFunctional {
    String toStr(int x);
}