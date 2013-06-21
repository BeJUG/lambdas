package E6_targetTyping;


import java.io.Flushable;
import java.util.function.ToIntFunction;

public class Experiment {

    public static void main(String[] argsv) {

        try {

            // Runnable has method void run()
            Runnable theRunner = () -> System.out.println("Hello");
            theRunner.run();

            // Flushable has as method void flush () throws IOException
            Flushable theFlusher = () -> System.out.println("Hello");
            theFlusher.flush();

            System.out.println();

        } catch (Exception e) {
        }


        try {

            // Comparable<T> offers the method int compare(T o)
            Comparable<String> theComparator = (str) -> str.length();
            System.out.println(theComparator.compareTo("abcde"));

            // ToIntFunction offers the method int applyAsInt(T t)
            ToIntFunction<String> theToIntFunction = (str) -> str.length();
            System.out.println(theToIntFunction.applyAsInt("abcde"));

        } catch (Exception e) {
        }

    }

}
