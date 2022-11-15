package lotto.view;

import lotto.domain.*;

import java.util.Collections;
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
    public void printLottoResultAll(WinningResult winningResult){
        System.out.println(SystemMessage.OUTPUT_RESULT_START.print());
        for(Result result: Result.values()){
            if(result.getPrice()==0) continue;
            System.out.printf(SystemMessage.OUTPUT_RESULT_LOTTO.print(),
                    result.getPrint(), winningResult.getResults().get(result));
        }
    }
    public void printRateOfReturn(WinningResult winningResult, int money){
        System.out.printf(SystemMessage.OUTPUT_RATE_OF_RETURN.print(), String.format("%.1f",winningResult.calcRateOfReturn(money)));
    }
}