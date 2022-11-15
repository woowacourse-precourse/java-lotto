package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoPrice;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private List<Lotto> lottoTicketList = new ArrayList<>();
    private LottoStatistics lottoStatistics = new LottoStatistics();
    private LottoPrize lottoPrize = new LottoPrize();

    public static LottoController create(){
        return new LottoController();
    }
    public void run(){
        LottoPrice lottoPrice = buyLottoTicket();
        printTicketCount(lottoPrice);
        issueLotto(lottoPrice.lottoTicketCount());
        lottoStatistics.calculation(lottoTicketList,inputLottoNumbers());
        printStatistics(lottoStatistics.getLottoStatisticsList());
        printEarning(lottoPrize.calculateEarning(lottoPrice.getLottoPrice()));
    }
    private LottoPrice buyLottoTicket(){
        return new LottoPrice(inputView.inputPrice());
    }

    private void printTicketCount(LottoPrice price){
        outputView.printPurchaseCount(price.lottoTicketCount());
    }

    private void issueLotto(int lottoTicketCount){
        for(int i=0 ; i<lottoTicketCount ;i++){
            lottoTicketList.add(LottoTicket.generate());
            printLottoNumbers(lottoTicketList.get(i));
        }
    }
    private void printLottoNumbers(Lotto lotto) {
        outputView.printLottoNumbers(lotto);
    }

    private WinningNumbers inputLottoNumbers(){
        return new WinningNumbers(inputView.inputLottoNumbers(),inputView.inputBonusNumber());
    }

    private void printStatistics(List<Integer> lottoStatistics){
        outputView.printStatistics(lottoStatistics);
    }

    private void printEarning(double earning){
        outputView.printEarning(earning);
    }

}
