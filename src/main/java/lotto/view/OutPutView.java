package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.util.Score;

public class OutPutView {
    public void printSpace() {
        System.out.println("");
    }
    public void printUserLottos(List<List<Integer>> userLottos) {
        printSpace();
        printLottosSize(userLottos.size());
        for (List<Integer> lottery : userLottos) {
            List<Integer> list = new ArrayList<>(lottery);
            Collections.sort(list);
            printSingleLottery(list);
        }
        printSpace();
    }
    public void printSingleLottery(List<Integer> lottery) {
        System.out.println(lottery);
    }
    public void printLottosSize(int size) {
        System.out.println(size+"개를 구매했습니다.");
    }
    public void printUserScoreResultIntro() {
        printSpace();
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public void printUserScoreResult(Map<Score, Integer> ScoreBoard) {
        for (int i = Score.THREE.ordinal(); i < Score.SIX.ordinal(); i++) {
            System.out.println(Score.values()[i].getMessage()+(ScoreBoard.get(Score.values()[i])));
        }
    }

    public void printUserIncomePercentage(float incomeRatio) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.",incomeRatio));
    }
}
