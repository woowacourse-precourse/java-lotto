package view;

import domain.Lotto;

import java.util.HashMap;
import java.util.List;

public class ResultView {

    public void resultLotto(HashMap<String, Integer> winningLotto, int inputMoney) {
        double totalYield = 0;
        prefixResult();
        for (ResultMessage rank : ResultMessage.values()) {
            System.out.println(rank.getCondition() + " (" + rank.getWinningYield() + "원)" + " - " + winningLotto.get(rank.getWinningNumber()) + "개");
            if (winningLotto.get(rank.getWinningNumber()) != 0) {
                totalYield += convertToMoney(rank.getWinningYield());
            }
        }
        resultYield(totalYield, inputMoney);
    }

    private void prefixResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private double convertToMoney(String winningYield) {
        String convertWinningYield = winningYield.replaceAll(",", "");
        return Double.parseDouble(convertWinningYield);
    }

    private void resultYield(double totalYield, int inputMoney) {
        double yieldRate = (totalYield / inputMoney) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yieldRate) + "%입니다.");
    }

    public void resultTotalCount(List<Lotto> totalNumbers) {
        for (int i = 0; i < totalNumbers.size(); i++)
            System.out.println(totalNumbers.get(i).getNumbers());
    }

    public void resultCountLotto(int countLotto) {
        System.out.println(countLotto + "개를 구매했습니다.");
    }
}
