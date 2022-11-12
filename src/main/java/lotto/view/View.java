package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class View {

    public void printLottoPayed(List<Lotto> lottoPayed) {
        System.out.println(lottoPayed.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottoPayed) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStats() {

    }

    public void printEarningRate() {

    }

}
