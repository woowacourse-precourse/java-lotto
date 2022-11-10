package controller;

import domain.Lotto;
import domain.LottoPrice;
import domain.LottoTicket;
import view.InputView;
import view.OutputView;

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
        StringBuilder result = new StringBuilder("[");
        for (int lottoNumber : lotto.get()) {
            result.append(lottoNumber).append(", ");
        }
        result.delete(result.length() - 2, result.length()).append("]");
        System.out.println(result);
    }

    private void inputLottoNumbers(){
        inputView.inputLottoNumbers();
        inputView.inputBonusNumber();
    }

    private void printStatistics(){
        outputView.printStatistics(1,0,0,0,0);
    }

    private void printEarning(){
        outputView.printEarning(62.5F);
    }

}
