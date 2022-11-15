package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private static final String NOT_NUMBER_MESSAGE = String.format("[ERROR]: A non-number character was entered.");
    private static final String WRONG_NUMBER_RANGE_MESSAGE = String.format(
            "[ERROR]: Number entered is less than 1 and greater than 45.");
    private static final String BLANK = " ";
    private static final String EMPTY_STRING = "";
    private static final String COMMA = ",";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final double DECIMAL = 100;

    public void run() {
        Amount amount = new Amount(inputAmount());
        LottoTicket ticket = autoBuyTicket(amount);
        WinningNumber winningNumbers = inputWinningNumbers();
        Result result = getResult(ticket, winningNumbers);
        printResult(amount, result);
    }

    private int inputAmount() {
        InputView.printInputMoney();
        int n = 0;
        try {
            n = convertToInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            throw new NoSuchElementException();
        }
        return n;
    }

    private LottoTicket autoBuyTicket(Amount amount) {
        int autoCount = amount.getNumberOfLotto();
        LottoTicket autoTicket = LottoTicket.createLottoTicket(autoCount, MIN_NUMBER, MAX_NUMBER);
        printTicket(autoCount, autoTicket);
        return autoTicket;
    }

    private void printTicket(int count, LottoTicket ticket) {
        OutputView.printBuy(count);
        OutputView.printTicket(ticket);
    }

    private WinningNumber inputWinningNumbers() {
        InputView.printInputNumber();
        Lotto lotto = new Lotto(inputLottoNumbers());
        int bonusNumber = inputBonusNumber();
        return new WinningNumber(lotto, bonusNumber);
    }

    private List<Integer> inputLottoNumbers() {
        String[] splitInput = split(deleteBlank(Console.readLine()));
        try {
            return convertToIntList(splitInput);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> convertToIntList(String[] splitInput) {
        List<Integer> temp = new ArrayList<>();
        for (String s : splitInput) {
            int number = convertToInt(s);
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(WRONG_NUMBER_RANGE_MESSAGE);
            }
            temp.add(number);
        }
        return temp;
    }

    private String[] split(String input) {
        return input.split(COMMA);
    }

    private String deleteBlank(String input) {
        return input.replaceAll(BLANK, EMPTY_STRING);
    }

    private int convertToInt(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
        return number;
    }

    private int inputBonusNumber() {
        InputView.printInputBonus();
        try {
            return convertToInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            throw new IllegalArgumentException();
        }

    }

    private Result getResult(LottoTicket ticket, WinningNumber winningNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : ticket.getTicket()) {
            Rank rank = winningNumber.computeRank(lotto);
            ranks.add(rank);
        }
        return new Result(ranks);
    }

    private void printResult(Amount amount, Result result) {
        OutputView.printStatistics();
        OutputView.printWinningState(result);
        OutputView.printProfit(DECIMAL * result.winningAmount() / amount.getMoney());
    }
}