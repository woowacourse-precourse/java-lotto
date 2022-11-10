package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = new ArrayList<>();
        numbers = numberGenerator.createRandomNumbers();
        System.out.println(numbers);
    }
}
