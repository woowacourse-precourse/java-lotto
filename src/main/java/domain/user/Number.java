package domain.user;

import domain.validation.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Number {

    private List<Integer> winningNumber;
    private int bonusNumber;

    public Number(String input) {
        this.winningNumber = stringToList(input);   // 생성자 단계에서 입력받은 문자열을 List로 변환

        try {
            Validation.validateNumbers(this.winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        try {
            Validation.validateBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.bonusNumber = bonusNumber;
    }
    public List<Integer> stringToList(String input) {
        return Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }
}
