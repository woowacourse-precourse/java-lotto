package lotto.Model;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constant;
import lotto.Error;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WinningLotto {
    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningLotto() {
    }

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void askWinningNumber() {
        List<Integer> winningLotto = new ArrayList<>();
        String number = Console.readLine();
        System.out.println();
        String[] winningNumbers = parsingWinningNumber(number);
        validateWinningNumber(winningNumbers);

        for (String winningNumber : winningNumbers) {
            winningLotto.add(Integer.parseInt(winningNumber));
        }
    }

    private String[] parsingWinningNumber(String number) {
        number = number.replaceAll(" ", "");
        String[] winningNumbers = number.split(",");
        return winningNumbers;
    }

    public void askBonusNumber() {
        System.out.println(Constant.ASK_BONUS_NUMBER);
        String stringBonusNumber = Console.readLine();
        validateBonusNumber(stringBonusNumber);
        bonusNumber = Integer.parseInt(stringBonusNumber);
    }

    private void validateWinningNumber(String[] winningNumber){
        validateWinningNumberIsNumber(winningNumber);
        validateWinningNumberLength(winningNumber);
        validateWinningNumberDup(winningNumber);
    }

    private void validateWinningNumberIsNumber(String[] winningNumbers) throws IllegalArgumentException {
        for (String winningNumber : winningNumbers) {
            if (Integer.parseInt(winningNumber) >= 1 && Integer.parseInt(winningNumber) <= 45) {
                continue;
            }
            throw new IllegalArgumentException(Error.WRONG_LOTTO_NUMBER.getMessage());
        }
    }
    private void validateWinningNumberLength(String[] winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException(Error.OVER_NUMBER_COUNT.getMessage());
        }
    }
    private void validateWinningNumberDup(String[] winningNumbers) throws IllegalArgumentException{
        if (winningNumbers.length != Stream.of(winningNumbers).distinct().count()) {
            throw new IllegalArgumentException(Error.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateBonusNumber(String number) throws IllegalArgumentException {
        int bonusNumber = Integer.parseInt(number);
        if(bonusNumber >= 1 && bonusNumber <= 45){
            return;
        }
        throw new IllegalArgumentException(Error.WRONG_LOTTO_NUMBER.getMessage());
    }
}
