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
        List<Integer> winningNumbers = new WinningNumbers(Console.readLine()).getNumbers();

        print.askBonusNumber();
        int bonusNumber = new BonusNumber(Console.readLine(), winningNumbers).getNumber();

        LinkedHashMap<String, Integer> winningStats = new WinningStats(winningNumbers, bonusNumber, publishedLottos).getStats();
        print.winningStats(winningStats);
        print.returnRate(new CalculateReturn(count, winningStats).getReturnRate());
    }
}