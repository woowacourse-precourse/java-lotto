package lotto.view;

import static lotto.view.ResponseMessage.BONUS_NUM_INPUT;
import static lotto.view.ResponseMessage.MONEY_INPUT;
import static lotto.view.ResponseMessage.QUANTITY;
import static lotto.view.ResponseMessage.RATE_OF_RETURN_PREFIX;
import static lotto.view.ResponseMessage.RATE_OF_RETURN_SUFFIX;
import static lotto.view.ResponseMessage.STATISTICS;
import static lotto.view.ResponseMessage.WINNING_NUM_INPUT;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Buyer;
import lotto.domain.Lotto;

public class GameView {

    public static void printMoneyInputMsg() {
        System.out.println(MONEY_INPUT.getMsg());
    }

    public static void printPurchaseLotto(Buyer buyer) {
        List<Lotto> lottos = buyer.getLottos();
        int quantity = lottos.size();
        System.out.println(quantity + QUANTITY.getMsg());

        lottos.stream().map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void printWinningNumInputMsg() {
        System.out.println(WINNING_NUM_INPUT.getMsg());
    }

    public static void printBonusNumInputMsg() {
        System.out.println(BONUS_NUM_INPUT.getMsg());
    }

    public static void printStatistics(Buyer buyer) {
        final String SEPARATOR = " - ";
        final String UNIT = "개";
        System.out.println(STATISTICS.getMsg());
        buyer.getWinningResult().entrySet().stream()
                .sorted(Collections.reverseOrder(Entry.comparingByKey()))
                .forEach(entry -> System.out.println(
                        entry.getKey().getMsg() + SEPARATOR + entry.getValue() + UNIT
                ));
        System.out.println(
                RATE_OF_RETURN_PREFIX.getMsg() + buyer.getRateOfReturn() + RATE_OF_RETURN_SUFFIX.getMsg()
        );
    }

}
