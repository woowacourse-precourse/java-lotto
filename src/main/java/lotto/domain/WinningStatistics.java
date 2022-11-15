package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    List<List<Integer>> lottocard = new ArrayList<>();
    List<Integer> winLotto = new ArrayList<>();
    int bonusNum;
    Map<String, Integer> winResult = new HashMap<>() {
        {
            put("3", 0);
            put("4", 0);
            put("5", 0);
            put("5+", 0);
            put("6", 0);
        }
    };


    public WinningStatistics(LottoCard lottoCard, WinningLottoNumber winningLotto, int bonusNum) {
        lottocard = lottoCard.getlottocard();
        winLotto = winningLotto.getLotto().getNumbers();
        this.bonusNum = bonusNum;
        printResult();
    }

    private void printResult() {
        System.out.println("\n당첨 통계\n---");
        checkCountOfLottoCard();
        System.out.println("3개 일치 (5,000원) - " + winResult.get("3"));
        System.out.println("4개 일치 (50,000원) - " + winResult.get("4"));
        System.out.println("5개 일치 (1,500,000원) - " + winResult.get("5"));
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winResult.get("5+"));
        System.out.println("6개 일치 (2,000,000,000원) - " + winResult.get("6"));
    }

    private void checkCountOfLottoCard() {
        for (List<Integer> lotto : lottocard) {
            compareComputerNumAndInputNum(lotto);
        }
    }

    private void compareComputerNumAndInputNum(List<Integer> lotto) {
        int cnt = 0;
        int bonusCnt = 0;
        for (Integer computerNum : lotto) {
            for (Integer inputNum : winLotto) {
                if (computerNum == inputNum) {
                    cnt += 1;
                }
            }
            if (computerNum == bonusNum) {
                bonusCnt += 1;
            }
        }
        if (cnt == 5 && bonusCnt == 1) {
            int winCnt = winResult.get("5+");
            winResult.put("5+", winCnt + 1);
            return;
        }
        if (cnt >= 3) {
            String count = Integer.toString(cnt);
            int winCnt = winResult.get(count);
            winResult.put(count, winCnt);
        }


    }

}
