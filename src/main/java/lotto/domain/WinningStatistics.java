package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistics {

    List<List<Integer>> lottocard = new ArrayList<>();
    List<Integer> winLotto = new ArrayList<>();

    public WinningStatistics(LottoCard lottoCard, WinningLottoNumber winningLotto, int bonusNum) {
        lottocard = lottoCard.getlottocard();
        winLotto = winningLotto.getLotto().getNumbers();
    }

    private void printResult(){
        System.out.println("당첨 통계\n---");


    }

}
