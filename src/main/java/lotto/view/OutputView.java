package lotto.view;

import static lotto.constant.Message.DIVISION;
import static lotto.constant.Message.INPUT_BONUS_NUMBER;
import static lotto.constant.Message.INPUT_PURCHASE_MONEY;
import static lotto.constant.Message.INPUT_WINNING_NUMBER;
import static lotto.constant.Message.LOTTO_GENERATED;
import static lotto.constant.Message.RESULT_STATICS;
import static lotto.constant.Message.YIELD_RESULT;
import static lotto.rank.Rank.NONE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.lotto.Lotto;
import lotto.money.Yield;
import lotto.rank.Rank;

public class OutputView {

    public static void printInputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);
    }

    public static void printGeneratedLotto(List<Lotto> lottos) {
        System.out.println(String.format(LOTTO_GENERATED, lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printResult(Map<Rank, Integer> rankMap, Yield yield) {
        System.out.println(RESULT_STATICS);
        System.out.println(DIVISION);
        List<Rank> ranks = getRanksExceptNONE();
        for (Rank rank : ranks) {
            printIndividualRank(rankMap, rank);
        }
        printYield(yield);
    }

    private static List<Rank> getRanksExceptNONE() {
        List<Rank> ranks = new ArrayList<>(Arrays.asList(Rank.values()));
        ranks.remove(NONE);
        Collections.reverse(ranks);
        return ranks;
    }

    private static void printIndividualRank(Map<Rank, Integer> rankMap, Rank rank) {
        int count = rankMap.getOrDefault(rank, 0);
        String message = rank.getMessage(count);
        System.out.println(message);
    }

    private static void printYield(Yield yield) {
        String message = String.format(YIELD_RESULT, yield.toString());
        System.out.println(message);
    }

    public static void printBlank() {
        System.out.println();
    }
}
