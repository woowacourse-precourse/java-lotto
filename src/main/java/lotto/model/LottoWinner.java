package lotto.model;

import java.util.*;

public class LottoWinner {
    private static final int WINNING_NUMBER_SIZE = 6;
    private static final int MIN_WINNING_NUMBER = 1;
    private static final int MAX_WINNING_NUMBER = 45;
    private Set<Integer> winningNumbers;
    private int bonusNumber;

    public LottoWinner(String winningNumber){
        validateWinningNumber(winningNumber);
        this.winningNumbers = splitter(winningNumber);
        checkWinningNumberDuplication();
    }

    public Set<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    public void setBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    private void validateWinningNumber(String winningNumber){
        validateWinningNumberPattern(winningNumber);
        validateWinningNumberRange(winningNumber);
    }

    private void validateWinningNumberPattern(String winningNumber){
        String pattern = "(\\d*,){5}\\d*";

        if (!winningNumber.matches(pattern)){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개의 숫자를 쉼표로 구분지어 입력해야 합니다.");
        }
    }

    private void validateWinningNumberRange(String winningNumber){
        String[] numbers = winningNumber.split(",");

        for (String s : numbers) {
            int number = Integer.parseInt(s);

            if (number < MIN_WINNING_NUMBER || number > MAX_WINNING_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void checkWinningNumberDuplication(){
        if (winningNumbers.size() != WINNING_NUMBER_SIZE){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private void validateBonusNumber(String bonusNumber){
        validateBonusNumberPattern(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber);
    }

    private void validateBonusNumberPattern(String bonusNumber){
        String pattern = "\\d*";

        if (!bonusNumber.matches(pattern)){
            throw new IllegalArgumentException("[ERROR] 보너스번호는 숫자여야 합니다.");
        }
    }

    private void validateBonusNumberRange(String bonusNumber){
        int number = Integer.parseInt(bonusNumber);

        if (number < MIN_WINNING_NUMBER || number > MAX_WINNING_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumberDuplication(String bonusNumber){
        int number = Integer.parseInt(bonusNumber);

        if (winningNumbers.contains(number)){
            throw new IllegalArgumentException("[ERROR] 보너스번호는 당첨번호와 중복되지 않아야 합니다.");
        }
    }

    private Set<Integer> splitter(String winningNumber){
        String[] numberInputs = winningNumber.split(",");
        Set<Integer> numbers = new HashSet<>();

        for (String numberInput: numberInputs){
            numbers.add(Integer.parseInt(numberInput));
        }

        return numbers;
    }
}
