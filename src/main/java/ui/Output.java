package ui;

import lotto.Prize;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.Constants.*;

public class Output {
    public static void enterPurchaseMoney() {
        System.out.println(ENTER_PURCHASE_MONEY);
    }

    public static void howManyLottoBought(int count) {
        System.out.println(count + HOW_MANY_LOTTO_BOUGHT);
    }

    public static void boughtMyLotto(List<List<Integer>> myLotto) {
        for (List<Integer> eachLotto : myLotto) {
            System.out.println(eachLotto);
        }
    }

    public static void enterWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
    }

    public static void enterBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
    }


    public static void stats(int seedMoney) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println(WINNING_STATS);
        System.out.println("---");
        for (Prize rank : Prize.values()) {
            String output = rank.getMatchedNumbers() + "개 일치";

            if (rank.getContainBonus()) {
                output += ", 보너스 볼 일치";
            }
            output += " (" + formatter.format(rank.getPrize()) + "원)" + " - " + rank.getNumsOfWinner() + "개";
            System.out.println(output);
        }
        System.out.println("총 수익률은 " + String.format("%.1f", Prize.getComputeIncomeRate(seedMoney)) + "%입니다.");
    }
}
