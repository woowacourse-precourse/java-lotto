package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Message;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RaffleNumber {

    public String inputWinningNumber() {
        System.out.println(Message.INPUT_WINNING);
        String userInput = Console.readLine();
        return userInput;
    }

    public List<Integer> setWinningNumber(String userInput) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : userInput.split(",")) {
            validateRange(number);
            winningNumber.add(Integer.valueOf(number));
        }
        hasSameNumber(winningNumber);
        validateSize(winningNumber);
        return winningNumber;
    }

    private void validateRange(String number) {
        int parseNumber = Integer.parseInt(number);
        if (1 > parseNumber || parseNumber > 45) {
            throw new IllegalArgumentException(Message.WINNING_RANGE_ERROR);
        }
    }

    private void hasSameNumber(List<Integer> numbers) {
        Set<Integer> sameNumber = new HashSet<>(numbers);
        if (sameNumber.size() < 6) {
            throw new IllegalArgumentException(Message.WINNING_OVERLAP_ERROR);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.WINNING_SIZE_ERROR);
        }
    }

    public int inputBonusNumber() {
        System.out.println(Message.INPUT_BONUS);
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
