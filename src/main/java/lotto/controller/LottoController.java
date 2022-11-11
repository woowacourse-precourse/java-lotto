package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.constant.UtilConstant.LOTTO_OPEN;
import static lotto.constant.UtilConstant.LOTTO_CLOSE;
import static lotto.constant.UtilConstant.COMMA_AND_SPACE;

public class LottoController {
    private static final InputView inputView = InputView.INSTANCE;
    private static final OutputView outputView = OutputView.INSTANCE;

    public static LottoController create(){
        return new LottoController();
    }
    public void run(){
        LottoPrice lottoPrice = buyLottoTicket();
        printTicketCount(lottoPrice);
        for(int i=0 ; i<lottoPrice.lottoTicketCount() ;i++)
            printLottoNumbers(LottoTicket.generate());
        inputLottoNumbers();
        inputBonusNumber();
        printStatistics();
        printEarning();
    }
    private LottoPrice buyLottoTicket(){
        return new LottoPrice(inputView.inputPrice());
    }

    private void printTicketCount(LottoPrice price){
        outputView.printPurchaseCount(price.lottoTicketCount());
    }

    private void printLottoNumbers(Lotto lotto) {
        StringBuilder result = new StringBuilder(LOTTO_OPEN);
        for (int lottoNumber : lotto.get()) {
            result.append(lottoNumber).append(COMMA_AND_SPACE);
        }
        result.delete(result.length() - 2, result.length()).append(LOTTO_CLOSE);
        System.out.println(result);
    }

    private List<Integer> inputLottoNumbers(){
        return inputView.inputLottoNumbers();
    }

    private int inputBonusNumber(){
        return inputView.inputBonusNumber();
    }

    private void printStatistics(){
        outputView.printStatistics(1,0,0,0,0);
    }

    private void printEarning(){
        outputView.printEarning(62.5F);
    }

}
