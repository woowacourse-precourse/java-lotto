package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Judgement;
import lotto.domain.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberGenerator numberGenerator = new NumberGenerator();
        Judgement judgement = new Judgement();
//        List<Integer> numbers = new ArrayList<>();
//        numbers = numberGenerator.createRandomNumbers();
//        System.out.println(numbers);
        int count = judgement.countCorrectNumbers(List.of(1,2,3,4,5,6),List.of(1,2,3,4,5,6));
        System.out.println(count);
    }
}
