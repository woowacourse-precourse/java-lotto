package lotto.service;

import lotto.utils.RandomGenerator;
import lotto.domain.*;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {
    private final List<Lotto> lotteries = new ArrayList<>();
    private WinningResult winningResult;
    private LottoMoney lottoMoney;

    public void purchase(String inputLottoMoney) {
        validateInt(inputLottoMoney);
        this.lottoMoney = new LottoMoney(Integer.parseInt(inputLottoMoney));
        int buyQuantity = lottoMoney.getMoney() / 1000;

        for (int i = 0; i < buyQuantity; i++) {
            lotteries.add(new Lotto(RandomGenerator.createRandomNumbers()));
        }
    }

    public List<Lotto> getPurchaseLotteries() {
        return lotteries;
    }

    public void setWinningNumber(String inputWinningNumber, String inputBonusNumber) {
        Lotto winningNumber = new Lotto(convertToNumbers(inputWinningNumber));
        LottoNumber bonusNumber = convertToNumber(inputBonusNumber);

        winningResult = new WinningResult(winningNumber, bonusNumber);
    }

    public WinningResult calculateResult() {
        for (Lotto lotto : lotteries) {
            winningResult.compareLotto(lotto);
        }

        return winningResult;
    }

    public double calculateProfitPercentage() {
        double totalWinningAmount = winningResult.calculateTotalWinningAmount();
        double dividedProfit = divideByPurchaseMoney(totalWinningAmount);

        return applyPercentage(dividedProfit);
    }

    private double applyPercentage(double dividedProfit) {
        return dividedProfit * 100.0;
    }

    private double divideByPurchaseMoney(double totalWinningAmount) {
        return totalWinningAmount / lottoMoney.getMoney();
    }

    private List<LottoNumber> convertToNumbers(String input) {
        return splitByComma(input)
                .map(this::convertToNumber)
                .collect(Collectors.toList());
    }

    private Stream<String> splitByComma(String input) {
        String[] splitNumbers = input.split(",");
        if (splitNumbers.length != 6) {
            throw new IllegalArgumentException("콤마를 올바르게 입력해 주세요.");
        }

        return Arrays.stream(splitNumbers);
    }

    private LottoNumber convertToNumber(String inputBonusNumber) {
        validateInt(inputBonusNumber);

        return new LottoNumber(Integer.parseInt(inputBonusNumber));
    }

    private void validateInt(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
