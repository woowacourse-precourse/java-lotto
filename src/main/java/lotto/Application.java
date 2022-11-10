package lotto;

import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        Lotto computer = new Lotto(NumberGenerator.createDifferentRandomNumbers());
    }
}
