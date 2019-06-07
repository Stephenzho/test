package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Apply {


    public static <T> List<T> filter(List<T> list, Predicate<T> p){

        List<T> result = new ArrayList<>();

        for(T e: list)
            if(p.test(e))
                result.add(e);


        return result;
    }

    public Callable<String> fetch() {
        return () -> "Tricky example ;-)";
    }


    public static void main(String[] args) {


        List<String> result = new ArrayList<>();
        result.add("fd");
        result.add("123");
        result.add("asdf");
        result.add("gfda");
        List<String> list = filter(result, r  ->  r.contains("a"));


        IntPredicate intp = (int i) -> i % 2 == 0;



        System.out.println(list);


        Comparator<Integer> byWeight = (Integer i, Integer j) -> i > j ? 1 : 0;

        System.out.println(byWeight.compare(1, 2));

    }

}
