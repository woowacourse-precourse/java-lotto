package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.Judgement;
import lotto.utils.Constant;
import lotto.utils.Grade;
import lotto.view.OutputView;

public class Statistics {
    private static final int LOTTO_COUNT = 6;
    private static final String BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String NON_BONUS_MESSAGE = "";

    public static void print(List<List<Integer>> tickets, List<Integer> lottoNumbers, int bonusNumber) {

        printReward(tickets, lottoNumbers, bonusNumber);
        printProfitRate(tickets, lottoNumbers, bonusNumber);
    }

    public static void printProfitRate(List<List<Integer>> tickets, List<Integer> lottoNumbers, int bonusNumber) {
        long cost = (long) Constant.PURCHASE_UNIT * tickets.size();
        long profit = 0;
        for (List<Integer> ticket : tickets) {
            Grade grade = Judgement.findGradeByCorrectNumber(lottoNumbers, bonusNumber, ticket);
            profit += (long) grade.getReward();
        }
        OutputView.guideStatistics();
        OutputView.printProfitRate(profit, cost);
    }

    public static void printReward(List<List<Integer>> tickets, List<Integer> lottoNumbers, int bonusNumber) {
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < LOTTO_COUNT; i++) {
            counts.add(0);
        }
        for (List<Integer> ticket : tickets) {
            Grade grade = Judgement.findGradeByCorrectNumber(lottoNumbers, bonusNumber, ticket);
            int temp = counts.get(grade.getRank() - 1);
            temp++;
            counts.set(grade.getRank() - 1, temp);
        }
        for (int i = 4; i > -1; i--) {
            Grade grade = Judgement.findGradeByRank(i + 1);
            OutputView.printReward(grade, BonusMessage(i, grade), counts.get(i));
        }
    }

    public static String BonusMessage(int i, Grade grade) {
        if (i == 1) {
            return BONUS_MESSAGE;
        }
        return NON_BONUS_MESSAGE;
    }
}
