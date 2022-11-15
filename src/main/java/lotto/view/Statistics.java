package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Judgement;
import lotto.view.Grade;

public class Statistics {
    public Statistics() {
    }

    public static void printProfitRate(List<List<Integer>> tickets, List<Integer> lottoNumbers, int bonusNumber){
        int total = 0;
        for (List<Integer> ticket : tickets){
            Judgement judgement = new Judgement();
            Grade grade = judgement.findGrade(lottoNumbers, bonusNumber, ticket);
            total += grade.getReward();
        }
        float profitRate = ((float)total*100)/(float)(1000*tickets.size());
        System.out.println("총 수익률은 "+Math.round(profitRate*10)/10.0+"%입니다.");
    }

    public static void printReward(List<List<Integer>> tickets, List<Integer> lottoNumbers, int bonusNumber){
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            counts.add(0);
        }
        for (List<Integer> ticket : tickets){
            Judgement judgement = new Judgement();
            Grade grade = judgement.findGrade(lottoNumbers, bonusNumber, ticket);
            int temp = counts.get(grade.getRank() - 1);
            temp++;
            counts.set(grade.getRank() - 1, temp);
        }
        for (int i = 4; i > -1; i--){
            Judgement judgement = new Judgement();
            Grade grade = judgement.findGradeByRank(i + 1);
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
