package view;

import domain.ResultMessage;
import domain.Lotto;

import java.util.HashMap;
import java.util.List;

public class ResultView {

    public void resultLotto(HashMap<String, Integer> winningLotto, int inputMoney) {
        int totalYield = 0;
        for (ResultMessage rank : ResultMessage.values()) {
            System.out.println(rank.getCondition() + " (" + rank.getWinningCount() + ")" + " - " + winningLotto.get(rank.getWinningNumber()) + "개");
            if (winningLotto.get(rank.getWinningNumber()) != 0) {
                totalYield += convertToMoney(rank.getWinningCount());
            }
        }
        resultYield(totalYield, inputMoney);
    }

    private int convertToMoney(String winningCount) {
        String convertWinningCount = winningCount.replaceAll(",", "");
        return Integer.parseInt(convertWinningCount);
    }

    private void resultYield(int totalYield, int inputMoney) {
        double yieldRate = ((double) totalYield / inputMoney) * 100;
        System.out.println("총 수익률은 " + yieldRate + "%" + "입니다");
    }

    public void resultTotalLotto(List<Lotto> totalLottoNumbers){
        for(int i = 0; i < totalLottoNumbers.size(); i++)
            System.out.println(totalLottoNumbers.get(i).getNumbers());
    }
    public void resultCountLotto(int countLotto){
        System.out.println(countLotto+"개를 구매했습니다.");
    }
}
