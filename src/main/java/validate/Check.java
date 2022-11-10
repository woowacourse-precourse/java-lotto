package validate;

import java.util.List;

public class Check {
    public static void numberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
