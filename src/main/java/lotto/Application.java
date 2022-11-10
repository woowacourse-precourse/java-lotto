package lotto;

import lotto.domain.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberGenerator numbers = new NumberGenerator();
        System.out.println(numbers.createDuplicateNumbers());
    }
}
