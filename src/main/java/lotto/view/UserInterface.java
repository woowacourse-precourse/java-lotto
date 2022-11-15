package lotto.view;

import lotto.model.LottoRankingType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserInterface {
    private static final int LOTTO_PRICE = 1000;
    private UserInput userInput;
    private UserOutput userOutput;

    public UserInterface() {
        this.userInput = new UserInput();
        this.userOutput = new UserOutput();
    }

    public int getBuyLottoCount() {
        this.userOutput.buyLotto();

        String inputAmount = this.userInput.getInputAmount();
        int buyAmount = this.userInput.getBuyAmount(inputAmount);

        this.userOutput.lineBreak();
        return buyAmount / LOTTO_PRICE;
    }

    public void printLotto(int lottoCount, ArrayList<ArrayList<Integer>> displayLottoNumbers) {
        this.userOutput.lottoCount(lottoCount);
        this.userOutput.lottoNumbers(displayLottoNumbers);
        this.userOutput.lineBreak();
    }

    public List<Integer> getWinningNumbers() {
        this.userOutput.winningNumbers();

        String inputWinningNumbers = this.userInput.getInputWinningNumbers();
        List<Integer> winningNumbers = this.userInput.makeWinningNumbers(inputWinningNumbers);

        this.userOutput.lineBreak();
        return winningNumbers;
    }

    public int getBonusNumber() {
        this.userOutput.bonusNumber();

        String inputBonusNumber = this.userInput.getInputBonusNumber();
        int bonusNumber = this.userInput.getBonusNumber(inputBonusNumber);

        this.userOutput.lineBreak();
        return bonusNumber;
    }

    public void printResult(Map<LottoRankingType, Integer> lottoRankingTypes, double rateOfReturn) {
        this.userOutput.winningStatistics();
        this.userOutput.borderLine();
        this.userOutput.winningHistory(lottoRankingTypes);
        this.userOutput.rateOfReturn(rateOfReturn);
        this.userOutput.lineBreak();
    }
}
