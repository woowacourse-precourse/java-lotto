package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoGame {
    private List<List<Integer>> lottos;

    public int GetUserInput() {
        String userInput = Console.readLine();
        return UserInputCheck.purchaseAmountCheck(userInput);
    }

    public List<List<Integer>> getLottos(int count) {
        List<List<Integer>> lottos = LottosGenerator.lottoGenerate(count);
        this.lottos = lottos;
        return lottos;
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
