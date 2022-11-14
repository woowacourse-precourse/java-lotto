package view;

import domain.ResultMessage;
import domain.Lotto;

import java.util.HashMap;
import java.util.List;

public class ResultView {

    public void resultLotto(HashMap<String, Integer> winningLotto, int inputMoney) {
        double totalYield = 0;
        System.out.println("당첨통계");
        System.out.println("---");
        for (ResultMessage rank : ResultMessage.values()) {
            System.out.println(rank.getCondition() + " (" + rank.getWinningCount() + "원)" + " - " + winningLotto.get(rank.getWinningNumber()) + "개");
            if (winningLotto.get(rank.getWinningNumber()) != 0) {
                totalYield += convertToMoney(rank.getWinningCount());
            }
        }
        resultYield(totalYield, inputMoney);
    }

    private double convertToMoney(String winningCount) {
        String convertWinningCount = winningCount.replaceAll(",", "");
        return Double.parseDouble(convertWinningCount);
    }

    private void resultYield(double totalYield, int inputMoney) {
        double yieldRate = (totalYield / inputMoney) * 100;
        System.out.println("총 수입률은 "+String.format("%.1f", yieldRate)+"%입니다");
    }

    public void resultTotalLotto(List<Lotto> totalLottoNumbers){
        for(int i = 0; i < totalLottoNumbers.size(); i++)
            System.out.println(totalLottoNumbers.get(i).getNumbers());
    }
    public void resultCountLotto(int countLotto){
        System.out.println(countLotto+"개를 구매했습니다.");
    }
}
