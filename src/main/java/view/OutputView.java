package view;

import domain.LottoRank;
import domain.Lotto;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public void printAmount(Integer amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList){
            Collections.sort(lotto.numbers);
            System.out.println((lotto.numbers));
        }

    }

    public void printTotalResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank lottoRank : LottoRank.values()){
            System.out.printf(lottoRank.getMatch()+ " (%s원) - "
                    + lottoRank.count +"개\n", NumberFormat.getInstance().format(lottoRank.getReward()));
        }

    }

    public void printReturnRate(double totalReward,int amount){
        System.out.println("총 수익률은 " + String.format("%.1f",totalReward/amount/10)+"%입니다.");
    }

}
