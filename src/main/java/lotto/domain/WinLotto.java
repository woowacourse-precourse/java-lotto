package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinLotto {
    private static final char COMMA = ',';
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinLotto() {
    }

    public void setWinningNumbers() {
        String input = Console.readLine();
        validateComma(input);

        this.winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        new Lotto(winningNumbers);
    }

    public void setBounsNumber() {
        bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumberRange(bonusNumber);
        validateDuplicateBonusNumber(bonusNumber,winningNumbers);
    }

    public void validateComma(String input) {
        if (countComma(input, COMMA) != 5) {
            throw new IllegalArgumentException("[ERROR] 잘못된 (,)기준 입니다.");
        }
    }

    public int countComma(String input, char comma) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == comma) {
                count++;
            }
        }
        return count;
    }

    private void validateBonusNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 범위를 초과하였습니다.");
        }
    }

    private void validateDuplicateBonusNumber(int number,List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 보너스 번호와 중복되는 번호가 존재합니다.");
        }
    }
}
