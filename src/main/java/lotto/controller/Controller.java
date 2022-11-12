package lotto.controller;

import lotto.domain.LottoPurchaseInformation;
import lotto.domain.WinningInformation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private WinningInformation winningInformation;
    private LottoPurchaseInformation lottoPurchaseInformation;

    public void execute() {
        createLottoPurchaseInformation();
        showLottoPurchaseInformation();
        createWinningInformation();
        compareLottoPurchaseInformationAndWinningInformation();
        showResult();
    }

    private void createLottoPurchaseInformation(){
        int purchaseAmount = Integer.parseInt(inputView.getPurchaseAmount());
        lottoPurchaseInformation = new LottoPurchaseInformation(purchaseAmount);
        lottoPurchaseInformation.generateLottoTickets();
    }

    private void showLottoPurchaseInformation(){
        outputView.printPurchaseDetails(lottoPurchaseInformation.getLottoTickets());
    }

    private void createWinningInformation(){
        List<String> winningNumbersInput = inputView.getWinningNumbers();
        List<Integer> winningNumbers = new ArrayList<>();
        for(String winningNumber : winningNumbersInput){
            winningNumbers.add(Integer.parseInt(winningNumber));
        }
        int bonusNumber = Integer.parseInt(inputView.getBonusNumber());
        winningInformation = new WinningInformation(winningNumbers, bonusNumber);
    }

    private void compareLottoPurchaseInformationAndWinningInformation(){
        lottoPurchaseInformation.compareLottoTicketsWith(winningInformation.getWinningNumbers(), winningInformation.getBonusNumber());
        lottoPurchaseInformation.calculateTotalWinningAmount();
        lottoPurchaseInformation.calculateRateOfReturn();
    }

    private void showResult(){
        outputView.printWinningStatistics(lottoPurchaseInformation.getWinningStatistics());
        outputView.printRateOfReturn(lottoPurchaseInformation.getRateOfReturn());
    }
}
