package lotto.LottoShop;

import camp.nextstep.edu.missionutils.Console;
import lotto.Enum.Statistics;
import lotto.LottoManagement.Lotto;
import lotto.LottoManagement.LottoDrawingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Enum.Constant.*;
import static lotto.Enum.ConstantMessage.*;

public class Consumer {
    private final Clerk clerk;
    private List<Lotto> lotto_group;

    HashMap<Integer, Integer> prize_count = new HashMap<>();
    List<Integer> money_of_prize = List.of(
            ZERO_PRIZE.getIntValue(),
            ZERO_PRIZE.getIntValue(),
            ZERO_PRIZE.getIntValue(),
            FIFTH_GRADE_PRIZE.getIntValue(),
            FOURTH_GRADE_PRIZE.getIntValue(),
            THIRD_GRADE_PRIZE.getIntValue(),
            FIRST_GRADE_PRIZE.getIntValue(),
            SECOND_GRADE_PRIZE.getIntValue());

    private int cost;
    private int profit;
    private double profit_rate;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void purchaseLotto() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getValue());
        String purchaseAmount = Console.readLine();

        this.lotto_group = clerk.sellLotto(purchaseAmount);

        this.cost = Integer.parseInt(purchaseAmount);
    }

    public void checkPrizesOfLottoGroup() {
        List<Integer> prizes_of_lottos =
                lotto_group.stream()
                        .map(LottoDrawingMachine::calculatePrize)
                        .collect(Collectors.toList());

        getPrizesStatistics(prizes_of_lottos);
    }

    private void getPrizesStatistics(List<Integer> prizes) {
        prizes.forEach(prize -> {
                    prize_count.merge(prize, ONE_INDEX.getIntValue(), Integer::sum);
                    this.profit += money_of_prize.get(prize);
                }
        );

        this.profit_rate = profit / (double) cost * HUNDRED.getIntValue();

        String prize_statistcs = Statistics.getStatistics(prize_count,profit_rate);

        System.out.println(prize_statistcs);
    }

}
