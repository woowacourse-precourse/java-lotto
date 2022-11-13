package lotto;

import java.util.List;

import static lotto.domain.BuyLotto.howMuchBuy;
import static lotto.view.InputLottoView.printHowMuch;

public class Lotto {
    private final List<Integer> numbers;
    private static final int ZERO = 0;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void run() {
        buyLotto();
    }

    private static void buyLotto() {
        int runCycle = howMuchBuy(printHowMuch());
        int runCount = ZERO;
        while(runCycle != runCycle){

        }

    }

    // TODO: 추가 기능 구현
}
