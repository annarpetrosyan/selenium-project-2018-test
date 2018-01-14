package LearningExtraInformation;

/**
 * Created by anna.r.petrosyan on 1/14/2018.
 */
public class BoxPrinter<T> {
        private T val;

    public BoxPrinter(T arg) {
        val = arg;
    }

    public String toString() {
        return "{" + val + "}";
    }

    public T getValue() {
        return val;
    }
}

class Test {
    public static void main(String[] args) {
        BoxPrinter<Integer> value1 = new BoxPrinter<Integer>(10);
        System.out.println(value1);
        Integer intValue1 = value1.getValue();
        System.out.println(intValue1);

        BoxPrinter<String> value2 = new BoxPrinter<String>("Hello world");
        System.out.println(value2);
        String intValue2 = value2.getValue();
        System.out.println(intValue2);

    }
}


