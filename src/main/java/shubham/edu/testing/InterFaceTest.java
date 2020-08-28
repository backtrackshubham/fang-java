package shubham.edu.testing;


import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Test {
    String MONGO_DB_NAME = "ABC_Mongo_Datastore";
    String NEO4J_DB_NAME = "ABC_Neo4J_Datastore";
    String CASSANDRA_DB_NAME = "ABC_Cassandra_Datastore";

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");
        return str == null || ("".equals(str));
    }

    default String getName() {
        return "Shubham";
    }

}

public class InterFaceTest {
    static CompletableFuture<String> getF() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getId());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In " + Thread.currentThread().getName());
            return "SHubham";
        });
    }


    static CompletableFuture<String> getF(String name) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getId());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In " + Thread.currentThread().getName());
            return name + "is brother of Nidhi";
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> cf = getF();
//        System.out.println("In "+Thread.currentThread().getName());
//
//        System.out.println(cf.thenApply((name) -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName());
//            return "Its wonderful here, "+ name;
//        }).get());
        System.out.println("=============================");
//        Executor ex = Executors.f
//        getF().thenCompose(InterFaceTest::getF).get();

//        System.out.println(getF().thenCombine(getF("shubham"), (r1, r2) -> r1 + r2).get());

        IntSupplier integer = new IntSupplier() {
            @Override
            public int getAsInt() {
                return new Random().nextInt(2000);
            }
        };

        List<CompletableFuture<String>> collect = Stream.iterate(1, i -> i + 1).limit(10).map(value -> {
            if (value % 2 == 0) {
                return getF();
            } else return getF(" " + integer.getAsInt());
        }).collect(Collectors.toList());

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(collect.toArray(new CompletableFuture[collect.size()]));


        CompletableFuture<List<String>> listCompletableFuture = voidCompletableFuture
                .thenApplyAsync(v -> collect.stream().map(CompletableFuture::join).collect(Collectors.toList()));


        System.out.println(listCompletableFuture.get());


    }
}
