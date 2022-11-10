package lotto.ui.output;

import lotto.Lotto;
import lotto.domain.IssuingMachine;

import java.util.Arrays;
import java.util.List;

public class LotteryListPrinter {
    public void printAllLottery(List<Lotto> allIssuedLottery) {
        System.out.printf("%d개를 구매했습니다.\n", allIssuedLottery.size());
        for (Lotto lotto : allIssuedLottery) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers.toString());
        }
    }
}
