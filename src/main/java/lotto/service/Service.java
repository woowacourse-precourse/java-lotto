package lotto.service;

import java.util.List;

import lotto.domain.BonusNumber;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.utils.Converter;
import lotto.utils.Validator;

public class Service {
    Lotteries lotteries;
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;

    public void generateLottoList(String lottoPrice) {
        try {
            int lottoPriceNumber = Converter.toIntFromString(lottoPrice);
            Validator.validateLottoPrice(lottoPriceNumber);
            generateLotteries(lottoPriceNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public List<List<Integer>> getPurchaseResult() {
        return lotteries.getLotteries();
    }

    public void setWinningNumber(String winningNumberInput) {
        List<Integer> winningNumberInputs = Converter.toIntList(winningNumberInput);
        winningNumbers = new WinningNumbers(winningNumberInputs);
    }

    public void setBonusNumber(String bonusInput) {
        int bonusNumberInput = Converter.toIntFromString(bonusInput);
        bonusNumber = new BonusNumber(bonusNumberInput);
    }

    private void generateLotteries(int lottoPrice) {
        lotteries = Lotteries.generateLotteriesByPrice(lottoPrice);
    }

}
