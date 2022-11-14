package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputChecker;

import java.util.List;

public class PrizeLotto {

    private final String PRIZE_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final Lotto lotto;
    private final Integer bonus;

    public PrizeLotto() {
        this.lotto = initLotto();
        this.bonus = initBonus();
    }

    Lotto initLotto() {
        printPrizeMessage();
        List<Integer> numbers = InputChecker.checkPrizeLottoInput(Console.readLine());
        return new Lotto(numbers);
    }

    Integer initBonus() {
        printBonusMessage();
        return InputChecker.checkBonusNumber(Console.readLine(), lotto.getNumbers());
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonus() {
        return bonus;
    }

    void printPrizeMessage() {
        System.out.println(PRIZE_NUMBER_MESSAGE);
    }

    void printBonusMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
