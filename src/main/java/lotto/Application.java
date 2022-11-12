package lotto;

import java.util.Arrays;
import lotto.generator.NumberGenerator;
import lotto.generator.RandomsNumberGenerator;
import lotto.manager.LottoManager;
import lotto.ui.Input.ConsoleParameterInput;

public class Application {
    public static void main(String[] args) {
        try {
            LottoManager manager = new LottoManager(new RandomsNumberGenerator(), new ConsoleParameterInput());
            manager.tryLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
        }
    }
}
