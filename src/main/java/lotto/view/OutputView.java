package lotto.view;

import lotto.domain.SystemMessage;
import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public String printLottoPurchaseCount(){
        return SystemMessage.OUTPUT_PURCHASE_LOTTO.print();
    }
    public void printLottoNumbersAll(List<Lotto> lottos){
        for(Lotto lotto:lottos){
            System.out.println(lotto.getLotto());
        }
    }
}