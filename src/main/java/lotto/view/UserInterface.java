package lotto.view;

import lotto.domain.LottoRankingType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserInterface {
    private static final int LOTTO_PRICE = 1000;
    private static final UserInput userInput = new UserInput();
    private static final UserOutput userOutput = new UserOutput();

    public UserInterface() {
    }

    public int getBuyLottoCount() {
        userOutput.buyLotto();

        String inputAmount = userInput.getInputAmount();
        int buyAmount = userInput.getBuyAmount(inputAmount);

        userOutput.lineBreak();
        return buyAmount / LOTTO_PRICE;
    }

    public void printLotto(int lottoCount, ArrayList<ArrayList<Integer>> displayLottoNumbers) {
        userOutput.lottoCount(lottoCount);
        userOutput.lottoNumbers(displayLottoNumbers);
        userOutput.lineBreak();
    }

    public List<Integer> getWinningNumbers() {
        userOutput.winningNumbers();

        String inputWinningNumbers = userInput.getInputWinningNumbers();
        List<Integer> winningNumbers = userInput.makeWinningNumbers(inputWinningNumbers);

        userOutput.lineBreak();
        return winningNumbers;
    }

    public int getBonusNumber() {
        userOutput.bonusNumber();

        String inputBonusNumber = userInput.getInputBonusNumber();
        int bonusNumber = userInput.getBonusNumber(inputBonusNumber);

        userOutput.lineBreak();
        return bonusNumber;
    }

    public void printResult(Map<LottoRankingType, Integer> lottoRankingTypes, double rateOfReturn) {
        userOutput.winningStatistics();
        userOutput.borderLine();
        userOutput.winningHistory(lottoRankingTypes);
        userOutput.rateOfReturn(rateOfReturn);
        userOutput.lineBreak();
    }
}
