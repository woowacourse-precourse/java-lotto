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
    private ValidationInController validator = new ValidationInController();
    private WinningInformation winningInformation = new WinningInformation();
    private LottoPurchaseInformation lottoPurchaseInformation;

    public void execute() {
        String purchaseAmountInput = inputView.getPurchaseAmount();
        validator.checkNumericValue(purchaseAmountInput);
        lottoPurchaseInformation = new LottoPurchaseInformation(Integer.parseInt(purchaseAmountInput));
        lottoPurchaseInformation.generateLottoTickets();
        outputView.printPurchaseDetails(lottoPurchaseInformation.getLottoTickets());
        List<String> winningNumbersInput = inputView.getWinningNumbers();
        validator.checkNumericValueList(winningNumbersInput);
        List<Integer> winningNumbers = new ArrayList<>();
        for(int i = 0; i < winningNumbersInput.size(); i++){
            winningNumbers.add(Integer.parseInt(winningNumbersInput.get(i)));
        }
        winningInformation.setWinningNumbers(winningNumbers);
        String bonusNumberInput = inputView.getBonusNumber();
        validator.checkNumericValue(bonusNumberInput);
        winningInformation.setBonusNumber(Integer.parseInt(bonusNumberInput));
        lottoPurchaseInformation.compareLottoTicketsWith(winningNumbers, Integer.parseInt(bonusNumberInput));
        outputView.printWinningStatistics(lottoPurchaseInformation.getWinningStatistics());
        lottoPurchaseInformation.calculateTotalWinningAmount();
        lottoPurchaseInformation.calculateRateOfReturn();
        outputView.printRateOfReturn(lottoPurchaseInformation.getRateOfReturn());
    }

}
