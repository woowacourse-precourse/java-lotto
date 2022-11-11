package lotto;

import static lotto.LotteriesExceptionCase.validateAmount;
import static lotto.LotteriesExceptionCase.validateInputEmpty;
import static lotto.LotteriesExceptionCase.validateInputType;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AutomaticLottery {
    public int getLottoPieces(String amount) {
        validateInputEmpty(amount);
        validateInputType(amount);
        validateAmount(amount);
        int money = Integer.parseInt(amount);
        return money / 1000;
    }

    public List<List<Integer>> buyLotteries(String amount) {
        int lottoPieces = getLottoPieces(amount);
        List<List<Integer>> lotteries = new ArrayList<>();

        System.out.println(lottoPieces + "개를 구매했습니다.");

        for (int seq = 0; seq < lottoPieces; seq++) {
            lotteries.add(sortLotteriesNumber(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lotteries;
    }

    public void printLotteries(List<List<Integer>> lotteries) {
        for (List<Integer> lottery : lotteries) {
            System.out.println(lottery);
        }
    }

    private List<Integer> sortLotteriesNumber(List<Integer> lottery) {
        return lottery.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

}