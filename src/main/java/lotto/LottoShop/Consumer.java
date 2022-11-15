package lotto.LottoShop;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoManagement.Lotto;
import lotto.LottoManagement.LottoDrawingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Enum.Constant.*;

public class Consumer {
    private final Clerk clerk;
    private List<Lotto> lotto_group;
    private int cost;
    private int profit;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        this.lotto_group = clerk.sellLotto(purchaseAmount);

        this.cost = Integer.parseInt(purchaseAmount);
    }

    public void checkPrize() {
        List<Integer> prizes =
                lotto_group.stream()
                        .map(LottoDrawingMachine::calculatePrize)
                        .collect(Collectors.toList());

        printPrizes(prizes);
    }

    private void printPrizes(List<Integer> prizes) {
        HashMap<Integer, Integer> prize_count = new HashMap<>();
        List<Integer> prize_money = List.of(
                ZERO_PRIZE.getIntValue(),
                ZERO_PRIZE.getIntValue(),
                ZERO_PRIZE.getIntValue(),
                FIFTH_GRADE_PRIZE.getIntValue(),
                FOURTH_GRADE_PRIZE.getIntValue(),
                THIRD_GRADE_PRIZE.getIntValue(),
                FIRST_GRADE_PRIZE.getIntValue(),
                SECOND_GRADE_PRIZE.getIntValue());

        prizes.forEach(prize -> {
                    prize_count.merge(prize, ONE_INDEX.getIntValue(), Integer::sum);
                    profit += prize_money.get(prize);
                }
        );
    }

}
