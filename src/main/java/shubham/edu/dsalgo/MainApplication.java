package shubham.edu.dsalgo;

import shubham.edu.dsalgo.model.Demo;
import shubham.edu.dsalgo.model.HigherOrderFunctions;

import java.util.function.Predicate;

public class MainApplication {
    public static void main(String[] args) {
        Predicate hg2 = (Predicate<String>) s -> s.contains("shubham");
        HigherOrderFunctions hg = new HigherOrderFunctions() ;
        System.out.println(hg.getStringI());
        System.out.println(hg2.test("Name"));
        Demo d = new Demo(12, "shubahm");
        System.out.println(d.opt);
        d.x = 45;
    }
}
