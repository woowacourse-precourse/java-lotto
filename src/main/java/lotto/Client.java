package lotto;

import lotto.messages.ErrorMessage;
import lotto.messages.PrintMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Client {

    private ClientInput clientInput;
    private PrintMessage printMessage;

    Client(ClientInput clientInput) {
        this.clientInput = clientInput;
        this.printMessage = new PrintMessage();
    }

    public int buy() {
        print(PrintMessage.buy);
        String moneyAmountString = clientInput.get();
        int moneyAmount = parseStringToIntOrElseThrow(moneyAmountString);

        ThousandMultipleOrElseThrow(moneyAmount);
        moneyAmount /= 1000;

        print(moneyAmount + PrintMessage.amount);

        return moneyAmount;
    }

    public List<Integer> mark() {
        print(PrintMessage.numbers);
        String markedNumberString = clientInput.get();

        List<Integer> numbers = parseStringToIntegerListOrElseThrow(markedNumberString);

        return numbers;
    }

    public Integer bonusMark() {
        print(PrintMessage.bonus);
        String markedBonusNumberString = clientInput.get();

        int bonus;

        try {
             bonus = Integer.parseInt(markedBonusNumberString);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NOT_INTEGER);
        }

        if (bonus < 1 || bonus > 45 ) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NOT_IN_RANGE);
        }

        return bonus;
    }

    public void printLottoInfo(List<List<Integer>> tickets) {
        print(printMessage.ticketInfo(tickets));
    }

    public void printLottoResult(List<Prize> prizeResults, double benefit) {
        print(PrintMessage.statistic);
        Prize[] prizes = Prize.values();

        for (int i = 0; i < prizes.length; i++) {
            int amount = Collections.frequency(prizeResults, prizes[i]);
            print(printMessage.coincidence(prizes[i], amount));
        }

        print(printMessage.benefit(benefit));
    }
    private void print(String message) {
        System.out.println(message);
    }


    private List<Integer> parseStringToIntegerListOrElseThrow(String markedNumberString) {
        try {
            return List.of(
                    Arrays.stream(markedNumberString.split(","))
                            .map(number -> Integer.parseInt(number))
                            .toArray(Integer[]::new));
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_NOT_INTEGERS);
        }
    }


    private int parseStringToIntOrElseThrow(String moneyAmountString) {
        try {
            return Integer.parseInt(moneyAmountString);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_INTEGER);
        }
    }

    private void ThousandMultipleOrElseThrow(int moneyAmount) {
        if (moneyAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_THOUSANDS_MULTIPLE);
        }
    }
}
