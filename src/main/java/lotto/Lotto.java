package lotto;

import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoExceptionCaseImpl exceptionCase = new LottoExceptionCaseImpl();
        validate(numbers);
        exceptionCase.validateNumberRange(numbers);
        exceptionCase.validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 6자리여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static List<Integer> sliceWinningNumber(String winningNumber) {
        LottoExceptionCaseImpl exceptionCase = new LottoExceptionCaseImpl();
        exceptionCase.validateFirstIndexIsComma(winningNumber);
        exceptionCase.validateInputValue(winningNumber);
        exceptionCase.validateCommaCount(winningNumber);
        exceptionCase.validateLastIndexIsComma(winningNumber);
        return new ArrayList<>(List.of(winningNumber.split(",")))
                .stream()
                .map(Integer::parseInt)
                .collect(toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer inputBonusNumber(String number) {
        LottoExceptionCaseImpl exceptionCase = new LottoExceptionCaseImpl();

        for (int seq = 0; seq < number.length(); seq++) {
            exceptionCase.validateCharacter(number.charAt(seq));
        }

        exceptionCase.validateInputEmpty(number);

        int bonusNumber = Integer.parseInt(number);
        List<Integer> lottoNumbers = getNumbers();
        exceptionCase.validateContainsBonusNumber(bonusNumber, lottoNumbers);
        exceptionCase.validateRangeBonusNumber(bonusNumber);

        return bonusNumber;
    }
}