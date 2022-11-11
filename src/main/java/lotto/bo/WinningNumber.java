package lotto.bo;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {
    static final int BONUS_NUMBER_SIZE = 1;
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(String winningLottoNumbers, String BonusNumber) {
        validateInteger(winningLottoNumbers);
        validateInteger(BonusNumber);

        List<Integer> tmpNumbers = convertStrToNumberList(winningLottoNumbers);
        List<Integer> tmpBonusNumber = convertStrToNumberList(BonusNumber);

        validateRange(tmpNumbers);
        validateRange(tmpBonusNumber);
        validateNumberSize(tmpNumbers, Lotto.LOTTO_NUMBER_SIZE);
        validateNumberSize(tmpBonusNumber, BONUS_NUMBER_SIZE);

        this.numbers = tmpNumbers;
        this.bonusNumber = tmpBonusNumber.get(0);
    }

    private List<Integer> convertStrToNumberList(String numbers) {
        List<Integer> result;
        result = Stream.of(numbers.split(","))
                .map(number -> Integer.parseInt(number.strip())).collect(Collectors.toList());
        return result;
    }

    private void validateInteger(String numbers) {
        for (String number : numbers.split(",")) {
            String tmpNumber = number.strip();
            String range = String.format("^[0-9]+$");
            if (!Pattern.matches(range, tmpNumber)) {
                System.out.println("[ERROR] 당첨번호와 보너스 번호가 숫자가 아닙니다");
                throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스 번호가 숫자가 아닙니다");
            }
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Lotto.LOTTO_MIN_NUMBER || number > Lotto.LOTTO_MAX_NUMBER) {
                System.out.println("[ERROR] 당첨 번호와 보너스 번호가 1~ 45 사이의 숫자가 아닙니다.");
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 1~ 45 사이의 숫자가 아닙니다.");
            }
        }
    }

    private void validateNumberSize(List<Integer> numbers, int size) {
        if (numbers.size() != size) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개, 보너스 번호는 1개의 숫자가 아닙니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
