package shubham.edu.dsalgo.model;

import java.util.function.Function;


interface Parser {
    void show(String s);
}

class ParserImpl {
    public static String print(String in) {
        System.out.println("Calling print");
        return in.length() > 3 ? in.toLowerCase() : in.toUpperCase();
    }
}


class MethodReference {
    public void loggAppender(String toAppend, Parser p) {
        System.out.println("calling show");
        p.show(toAppend);
        System.out.println(toAppend);
    }

    public B objectCreator(A obj, Function<A,B> fun){
        return fun.apply(obj);
    }

}


class A {
    public int x;
    public int y;

    A(int a, int b){
        this.x = a;
        this.y = b;
    }


}



class B {
    public int x;
    public int y;

    B(A obj){
        this.x = obj.x;
        this.y = obj.y;
    }


}

class Main {
    public static void main(String[] args) {
        String name = "Shu";
        MethodReference mr = new MethodReference();
        mr.loggAppender(name, ParserImpl::print);
        System.out.println(mr.objectCreator(new A(5,6), B::new));

    }
}