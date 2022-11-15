package lotto;

import lotto.domain.*;
import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final List<Lotto> lotteries = new ArrayList<>();
    private WinningResult winningResult;
    private LottoMoney lottoMoney;

    public void purchase(LottoMoney lottoMoney) {
        this.lottoMoney = lottoMoney;
        int buyQuantity = lottoMoney.getMoney() / 1000;

        for (int i = 0; i < buyQuantity; i++) {
            lotteries.add(new Lotto(randomGenerator.createRandomNumbers()));
        }
    }

    public List<Lotto> getPurchaseLotteries() {
        return lotteries;
    }

    public void setWinningNumber(String inputWinningNumber, String inputBonusNumber) {
        Lotto winningNumber = new Lotto(convertToNumbers(inputWinningNumber));
        Number bonusNumber = convertToNumber(inputBonusNumber);

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

    private List<Number> convertToNumbers(String input) {
        return splitByComma(input)
                .map(LottoService::convertToNumber)
                .collect(Collectors.toList());
    }

    private Stream<String> splitByComma(String input) {
        String[] splitNumbers = input.split(",");
        if (splitNumbers.length != 6) {
            throw new IllegalArgumentException("콤마를 올바르게 입력해 주세요.");
        }
        return Arrays.stream(splitNumbers);
    }

    private static Number convertToNumber(String inputBonusNumber) {
        try {
            return new Number(Integer.parseInt(inputBonusNumber));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("올바른 숫자 형식으로 입력해 주세요.");
        }
    }
}
