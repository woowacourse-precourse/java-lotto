package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.Judgement;
import lotto.utils.Constant;
import lotto.utils.Grade;
import lotto.view.OutputView;

public class Statistics {
    public static void print(List<List<Integer>> tickets, List<Integer> lottoNumbers, int bonusNumber){

        printReward(tickets, lottoNumbers, bonusNumber);
        printProfitRate(tickets, lottoNumbers, bonusNumber);
    }
    public static void printProfitRate(List<List<Integer>> tickets, List<Integer> lottoNumbers, int bonusNumber){
        int cost = Constant.PURCHASE_UNIT * tickets.size();
        int profit = 0;
        for (List<Integer> ticket : tickets){
            Grade grade = Judgement.findGradeByCorrectNumber(lottoNumbers, bonusNumber, ticket);
            profit += grade.getReward();
        }
        OutputView.guideStatistics();
        OutputView.printProfitRate(profit, cost);
    }

    public static void printReward(List<List<Integer>> tickets, List<Integer> lottoNumbers, int bonusNumber){
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            counts.add(0);
        }
        for (List<Integer> ticket : tickets){
            Grade grade = Judgement.findGradeByCorrectNumber(lottoNumbers, bonusNumber, ticket);
            int temp = counts.get(grade.getRank() - 1);
            temp++;
            counts.set(grade.getRank() - 1, temp);
        }
        for (int i = 4; i > -1; i--){
            Grade grade = Judgement.findGradeByRank(i + 1);
            System.out.println(grade.getCorrectLotto() + "개 일치" + BonusMessage(i, grade) +
                    " (" + grade.getRewardFormat()+"원) - "+ counts.get(i) + "개");
        }
    }

    public static String BonusMessage(int i, Grade grade){
        if (i == 1){
            return ", 보너스 볼 일치";
        }
        return "";
    }
}
