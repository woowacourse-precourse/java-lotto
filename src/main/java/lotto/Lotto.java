package lotto;

import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public static List<Integer> sliceWinningNumber(String winningNumber) {
        validateFirstIndexIsComma(winningNumber);
        validateInputValue(winningNumber);
        validateCommaCount(winningNumber);
        validateLastIndexIsComma(winningNumber);
        return new ArrayList<>(List.of(winningNumber.split(",")))
                .stream()
                .map(Integer::parseInt)
                .collect(toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer inputBonusNumber(String number) {
        for (int seq = 0; seq < number.length(); seq++) {
            validateCharacter(number.charAt(seq));
        }
        validateInputEmpty(number);
        int bonusNumber = Integer.parseInt(number);
        validateContainsBonusNumber(bonusNumber);
        validateRangeBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void validateInputEmpty(String number) {
        if (number.equals("")) {
            System.out.println("[ERROR] 보너스 번호는 공백을 입력하실 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateRangeBonusNumber(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateContainsBonusNumber(int bonusNumber) {
        List<Integer> winningNumber = getNumbers();
        if (winningNumber.contains(bonusNumber)) {
            System.out.println("[ERROR] 당첨 번호에 있는 번호는 보너스 번호로 입력할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateCharacter(char inputSequence) {
        if (47 >= inputSequence || 58 <= inputSequence) {
            System.out.println("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 6자리여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (6 != numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 중복된 값이 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        long outRangeCount = numbers.stream()
                .filter(n -> n > 45 || n < 1)
                .count();
        if (outRangeCount != 0) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validateInputValue(String winningNumber) {
        for (int seq = 0; seq < winningNumber.length(); seq++) {
            if (winningNumber.charAt(seq) != 44 && (47 >= winningNumber.charAt(seq) || 58 <= winningNumber.charAt(seq))) {
                System.out.println("[ERROR] 당첨 번호 입력은 숫자와 쉼표(,)만 입력 가능합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateCommaCount(String winningNumber) {
        for (int seq = 0; seq < winningNumber.length(); seq++) {
            if (seq == winningNumber.length() - 1) {
                break;
            }
            validateDuplicateComma(winningNumber.charAt(seq), winningNumber.charAt(seq+1));
        }
    }

    private static void validateDuplicateComma(char sequence1, char sequence2) {
        if (sequence1 == ',' && sequence2 == ',') {
            System.out.println("[ERROR] 쉼표(,)는 5개 여야만 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validateLastIndexIsComma(String winningNumber) {
        if (winningNumber.charAt(winningNumber.length() - 1) == ',') {
            System.out.println("[ERROR] 쉼표(,)는 5개 여야만 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validateFirstIndexIsComma(String winningNumber) {
        if (winningNumber.charAt(0) == ',') {
            System.out.println("[ERROR] 첫 번째 입력 값에 쉼표가 올 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}