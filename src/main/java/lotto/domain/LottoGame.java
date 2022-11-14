package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoGame {
    public int GetUserInput() {
        String userInput = Console.readLine();
        return UserInputCheck.purchaseAmountCheck(userInput);
    }

    public List<List<Integer>> getLottos(int count) {
        return LottosGenerator.lottoGenerate(count);
    }

    public String getWinningNumber(){
        String userInput = Console.readLine();
        return UserInputCheck.winningNumberCheck(userInput);
    }

    public String getBonusNumber() {
        String userInput = Console.readLine();
        return UserInputCheck.bonusNumberCheck(userInput);
    }
}
