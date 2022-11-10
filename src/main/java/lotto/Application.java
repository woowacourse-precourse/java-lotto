package lotto;

import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> test = new ArrayList<>(lotto.createRandomNumbers());
        for (Integer number : numbers) {
            System.out.println("number = " + number);
        }

        for (Integer integer : test) {
            System.out.println("integer = " + integer);
        }
    }
}
