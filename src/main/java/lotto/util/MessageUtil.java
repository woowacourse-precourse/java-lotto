package lotto.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.constant.message.InputMessage.*;
import static lotto.constant.LottoPrice.FIVE_COUNT_WITH_BONUS;
import static lotto.constant.message.OutputMessage.*;


public class MessageUtil {

    public void printPurchaseInput() {
        System.out.println(PURCHASE.getMessage());
    }

    public void printWinningInput() {
        System.out.println(WINNING.getMessage());
    }

    public void printBonusInput() {
        System.out.println(BONUS.getMessage());
    }

    public void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COUNT.getMessage());
    }

    public void printPurchaseInfo(List<Integer> lottoNums) {
        // 테스트 시 받은 리스트는 불변 객체이기 때문에 정렬을 위해 따로 받아서 처리
        List<Integer> sortLottoNums = new ArrayList<>(lottoNums);
        sortLottoNums.sort(Comparator.naturalOrder());

        StringBuilder lottoNum = new StringBuilder("");

        lottoNum.append("[");
        for (Integer number : sortLottoNums) {
            lottoNum.append(number).append(", ");
        }
        lottoNum.delete(lottoNum.length()-2, lottoNum.length()).append("]");

        System.out.println(lottoNum);
    }

    public void printWinningStats() {
        System.out.println(WINNING_STATS.getMessage());
    }

    public void printWinningStatsResult(int number, int price, int matchCount) {
        String priceWithComma = String.format("%,d", price);
        if (number == FIVE_COUNT_WITH_BONUS.getNumber()) {
            System.out.printf(WINNING_STATS_BONUS_RESULT.getMessage(), priceWithComma, matchCount);
            return;
        }
        System.out.printf(WINNING_STATS_RESULT.getMessage(), number, priceWithComma, matchCount);
    }

    public void printEarningRate(Double rate) {
        System.out.printf(EARNING_RATE.getMessage(), rate);
    }
}
