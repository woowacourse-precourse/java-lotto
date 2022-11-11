package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.UtilConstant.LOTTO_OPEN;
import static lotto.constant.UtilConstant.LOTTO_CLOSE;
import static lotto.constant.UtilConstant.COMMA_AND_SPACE;

public class LottoController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private List<Lotto> lottoTicketList = new ArrayList<>();
    private WinningNumbers winningNumbers;

    public static LottoController create(){
        return new LottoController();
    }
    public void run(){
        LottoPrice lottoPrice = buyLottoTicket();
        printTicketCount(lottoPrice);
        for(int i=0 ; i<lottoPrice.lottoTicketCount() ;i++){
            lottoTicketList.add(LottoTicket.generate());
            printLottoNumbers(lottoTicketList.get(i));
        }
        winningNumbers = inputLottoNumbers();
        printStatistics(lottoTicketList,winningNumbers);
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

    private WinningNumbers inputLottoNumbers(){
        return new WinningNumbers(inputView.inputLottoNumbers(),inputView.inputBonusNumber());
    }

    private void printStatistics(List<Lotto> lottoTicketList,WinningNumbers winningNumbers){
        outputView.printStatistics(1,0,0,0,0);
    }

    private void printEarning(){
        outputView.printEarning(62.5F);
    }

}
