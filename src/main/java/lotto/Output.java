package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Output {
    public static void showLottos(List<Lotto> lottos) {
        System.out.println("\n"+lottos.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println("");
    }

    public static void showResult(Lottos lottos, List<Integer> winNumbers, int bonusNumber) {
        Map<Score, Integer> scoreBoard = lottos.getScore(winNumbers, bonusNumber);
        System.out.println("\n당첨 통계");
        System.out.println("---");
        int totalBenefit = 0;
        ArrayList<Score> scores = new ArrayList<>(scoreBoard.keySet());
        scores.sort(((o1, o2) -> o2.getRank() - o1.getRank()));
        StringBuilder sb = new StringBuilder();
        for (Score score : scores) {
            int amount = scoreBoard.get(score);
            totalBenefit += score.getReward() * amount;
            sb.append(score.getPrint()).append(amount).append("개").append(System.getProperty("line.separator"));
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));
        System.out.println("총 수익률은 "+ getYeild(totalBenefit, lottos.getPaid()) + "%입니다.");
    }

    public static void showError(Error error) {
        System.out.println(error.getDesc());
        throw new IllegalArgumentException();
    }

    private static String getYeild(int benefit, int paid) {
        double yeild =  (benefit / (double)paid) * 100;
        return String.format("%.1f", yeild);
    }
}
