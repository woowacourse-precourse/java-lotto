package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lotto.domain.NumberGenerator numberGenerator=new lotto.domain.NumberGenerator();
        List<Integer> result = numberGenerator.createRandomNumbers();
        System.out.println(result);
    }
}
