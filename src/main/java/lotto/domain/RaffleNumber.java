package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Message;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RaffleNumber {
    public List<Integer> winningNumber;
    public int bonusNumber;

    public void inputWinningNumber() {
        System.out.println(Message.INPUT_WINNING);
        String userInput = Console.readLine();
        setWinningNumber(userInput);
    }

    public void setWinningNumber(String userInput) {
        List<Integer> winningNumber = new ArrayList<>();
        try {
            for (String number : userInput.split(",")) {
                validateRange(number);
                winningNumber.add(Integer.valueOf(number));
            }
            validateSize(winningNumber);
            hasSameNumber(winningNumber);
            this.winningNumber = winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
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

    public void inputBonusNumber() {
        System.out.println(Message.INPUT_BONUS);
        String userInput = Console.readLine();
        setBonusNumber(userInput);
    }

    public void setBonusNumber(String userInput) {
        validateRange(userInput);
        int parseNumber = Integer.parseInt(userInput);
        try {
            validateNumber(winningNumber, parseNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.bonusNumber = parseNumber;
    }

    public void validateNumber(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.BONUS_NUMBER_ERROR);
        }
    }
}
