package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {

    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void setWinningNumbers() {
        String winningNumberUserInput = readLine();
        List<Integer> winningNumbers = Stream.of(winningNumberUserInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        this.winningNumbers = winningNumbers;
    }

    private void setBonusNumber() {
        String bonusNumberUserInput = readLine();
        int bonusNumber = Integer.parseInt(bonusNumberUserInput);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
