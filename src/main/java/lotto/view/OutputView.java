package lotto.view;

import lotto.domain.Lotto;
import lotto.utils.OutputNonEnumMessage;
import lotto.utils.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottoCount(int count){

        System.out.println(count + OutputNonEnumMessage.BUY_LOTTE_MESSAGE);
    }

    public void printAutoCreateLotto(List<Lotto> autoLotto){
        for(Lotto lotto : autoLotto){
            System.out.println(lotto.getAutoNumbers());
        }
    }

    public void printLottoResult(Map<Rank, Integer> lottoList){
        System.out.println(OutputNonEnumMessage.WIN_A_LOTTERY_STATUS);
        System.out.println(OutputNonEnumMessage.SEPARATION);
        for(Rank rank : lottoList.keySet()){
            System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getMatchMoney() + ")" + lottoList.get(rank) + "개");
        }
    }

    public void printProfitResult(long totalHitMoney, long money) {
        System.out.print("총 수익률은");
        System.out.format("%.1f", (totalHitMoney / (double) money));
        System.out.println("입니다.");
    }
}
