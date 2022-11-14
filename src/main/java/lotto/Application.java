package lotto;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.view.Input;

import java.util.List;

import static lotto.utils.Generator.generateLotto;
import static lotto.view.Input.enterBonusNumber;
import static lotto.view.Input.enterWinNumbers;
import static lotto.view.Output.printLottoList;
import static lotto.view.Output.printStats;

public class Application {
    public static void main(String[] args) {
        try {
            int price = Input.purchaseAmount();
            int count = price / 1000;

            List<Lotto> lottoList = generateLotto(count);
            printLottoList(count, lottoList);

            Result result = new Result(enterWinNumbers());
            result.setBonus(enterBonusNumber());

            printStats(price, lottoList, result);

        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
