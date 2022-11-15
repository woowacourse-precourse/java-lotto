package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.UI.*;
import lotto.domain.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Print print = new Print();

        print.askAmount();
        int count = new Purchase(Console.readLine()).getCount();
        print.purchaseCount(count);

        List<List<Integer>> publishedLottos = new Publish(count).getLottos();
        print.purchasedLottos(publishedLottos);

        print.askWinningNumber();
        String numbersInput = Console.readLine();

        print.askBonusNumber();
        String bonusNumberInput = Console.readLine();

        WinningLotto winningLotto = new WinningLotto(numbersInput, bonusNumberInput);
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        LinkedHashMap<String, Integer> winningStats = new WinningStats(winningNumbers, bonusNumber, publishedLottos).getStats();
        print.winningStats(winningStats);
        print.returnRate(new CalculateReturn(count, winningStats).getReturnRate());
    }
}