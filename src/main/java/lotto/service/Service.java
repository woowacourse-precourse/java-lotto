package lotto.service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import lotto.domain.BonusNumber;
import lotto.domain.Lotteries;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;
import lotto.utils.Converter;

public class Service {
    Lotteries lotteries;
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    Result result;

    public void generateLottoList(String lottoPrice) {
        try {
            int lottoPriceNumber = Converter.toIntFromString(lottoPrice);
            generateLotteries(lottoPriceNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw new NoSuchElementException();
        }
    }

    public List<List<Integer>> getPurchaseResult() {
        return lotteries.getLotteries();
    }

    public void setWinningNumber(String winningNumberInput) {
        try {
            List<Integer> winningNumberInputs = Converter.toIntList(winningNumberInput);
            winningNumbers = new WinningNumbers(winningNumberInputs);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void setBonusNumber(String bonusInput) {
        int bonusNumberInput = Converter.toIntFromString(bonusInput);
        bonusNumber = new BonusNumber(bonusNumberInput);
    }

    public List<String> getWinningResult() {
        initResult();
        result.countWinningCase();
        Map<String,Integer> resultMap = result.getResultMap();
        return Converter.toWinningResults(resultMap);
    }

    public String getProfitRate() {
        return result.getProfitRate();
    }

    private void initResult() {
        this.result = new Result(getPurchaseResult(), winningNumbers, bonusNumber);
    }

    private void generateLotteries(int lottoPrice) {
        lotteries = Lotteries.generateLotteriesByPrice(lottoPrice);
    }

}
