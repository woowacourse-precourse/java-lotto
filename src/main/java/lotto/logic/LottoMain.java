package lotto.logic;

import lotto.object.Lotto;
import lotto.object.WinningHistory;
import lotto.object.WinningNumbers;
import lotto.object.Yield;
import lotto.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMain {

    public static void lotto() {
        CalcLotto.resetWinningHistory();

        Long deposit = deposit();
        Long amount = getAmount(deposit);
        List<Lotto> lottos = getLottos(amount);
        WinningNumbers winningNumbers = getWinningNumbers();

        CalcLotto.setWinningNumbers(winningNumbers);
        CalcLotto.calcWinningTimes(lottos);

        WinningHistory history = getHistory();
        Long revenue = history.getRevenue();
        Yield yield = new Yield(deposit, revenue);

        View.printYield(yield);
    }

    private static Long deposit() {
        View.printDepositView();
        String input = View.getInput();

        return getLongNumber(input);
    }

    private static Long getAmount(Long deposit) {
        Long amount = LottoAmount.getLottoAmount(deposit);
        View.printLottoAmount(amount);

        return amount;
    }

    private static List<Lotto> getLottos(Long amount) {
        List<Lotto> lottos = CalcLottoNumber.getLottos(amount);
        View.printLottoNumbers(lottos);

        return lottos;
    }

    private static WinningNumbers getWinningNumbers() {
        List<Integer> winningNumbers = inputWinningNumber();
        Integer bonusNumber = getBonusNumber();

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private static List<Integer> inputWinningNumber() {
        View.printWinningNumbers();
        String input = View.getInput();

        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(LottoMain::getIntegerNumber)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    private static Integer getBonusNumber() {
        View.printBonusNumbers();
        String input = View.getInput();

        return getIntegerNumber(input);
    }

    private static WinningHistory getHistory() {
        WinningHistory history = CalcLotto.getHistory();
        View.printWinningHistory(history);

        return history;
    }

    private static Long getLongNumber(String number) {
        try {
            return Long.valueOf(number);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Invalid Argument");
        }
    }

    private static Integer getIntegerNumber(String number) {
        try {
            return Integer.valueOf(number);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Invalid Argument");
        }
    }
}
