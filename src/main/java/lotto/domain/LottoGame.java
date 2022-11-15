package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoGame {

    public int getUserAmount() {
        String userInput = Console.readLine();
        return UserInputCheck.purchaseAmountCheck(userInput);
    }

    public List<List<Integer>> getLottos(int count) {
        return LottoGenerator.lottoGenerate(count);
    }

    public List<Integer> getWinningNumber() {
        String userInput = Console.readLine();
        return UserInputCheck.winningNumberCheck(userInput);
    }

    public int getBonusNumber() {
        String userInput = Console.readLine();
        return UserInputCheck.bonusNumberCheck(userInput);
    }

}
