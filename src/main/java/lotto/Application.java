package lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int numberOfLotto = Lotto.getPurchaseAmount();
        List<Integer>[] myNums = Lotto.createNumbers(numberOfLotto);
        Lotto.printNumbers(myNums);
        List<Integer> luckyNumber = Lotto.getLuckyNumber();
        Lotto lotto = new Lotto(luckyNumber);
        int bonusNumber = lotto.getBonusNumber();

        lotto.getResult(myNums, bonusNumber);
        lotto.printResult(bonusNumber);

    }
}
