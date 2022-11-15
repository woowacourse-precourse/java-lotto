package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinLotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int COUNT_COMMA = 5;
    private static final int INIT = 0;
    private static final char COMMA = ',';
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public WinLotto() {
    }

    public void setWinningNumbers(String input) {
        validateComma(input);
        winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        new Lotto(winningNumbers);
    }

    public void setBonusNumber(String input) {
        bonusNumber = Integer.parseInt(input);
        validateBonusNumberRange(bonusNumber);
        validateDuplicateBonusNumber(bonusNumber,winningNumbers);
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    public int countComma(String input, char comma) {
        int count = INIT;
        for (int i = INIT; i < input.length(); i++) {
            if (input.charAt(i) == comma) {
                count++;
            }
        }
        return count;
    }

    public void validateComma(String input) {
        if (countComma(input, COMMA) != COUNT_COMMA) {
            throw new IllegalArgumentException("[ERROR] 잘못된 (,)기준 입니다.");
        }
    }

    public void validateBonusNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 범위를 초과하였습니다.");
        }
    }

    public void validateDuplicateBonusNumber(int number,List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 보너스 번호와 중복되는 번호가 존재합니다.");
        }
    }

}
