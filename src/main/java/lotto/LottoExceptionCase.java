package lotto;

import java.util.List;

public class LottoExceptionCase {
    public void validateInputEmpty(String number) {
        if (number.equals("")) {
            System.out.println("[ERROR] 보너스 번호는 공백을 입력하실 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateRangeBonusNumber(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateContainsBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            System.out.println("[ERROR] 당첨 번호에 있는 번호는 보너스 번호로 입력할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateCharacter(char inputSequence) {
        if (47 >= inputSequence || 58 <= inputSequence) {
            System.out.println("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        if (6 != numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 중복된 값이 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        long outRangeCount = numbers.stream()
                .filter(n -> n > 45 || n < 1)
                .count();
        if (outRangeCount != 0) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateInputValue(String winningNumber) {
        for (int seq = 0; seq < winningNumber.length(); seq++) {
            if (winningNumber.charAt(seq) != 44 && (47 >= winningNumber.charAt(seq) || 58 <= winningNumber.charAt(seq))) {
                System.out.println("[ERROR] 당첨 번호 입력은 숫자와 쉼표(,)만 입력 가능합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateCommaCount(String winningNumber) {
        for (int seq = 0; seq < winningNumber.length(); seq++) {
            if (seq == winningNumber.length() - 1) {
                break;
            }
            validateDuplicateComma(winningNumber.charAt(seq), winningNumber.charAt(seq+1));
        }
    }
    public void validateDuplicateComma(char sequence1, char sequence2) {
        if (sequence1 == ',' && sequence2 == ',') {
            System.out.println("[ERROR] 쉼표(,)는 5개 여야만 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateLastIndexIsComma(String winningNumber) {
        if (winningNumber.charAt(winningNumber.length() - 1) == ',') {
            System.out.println("[ERROR] 쉼표(,)는 5개 여야만 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateFirstIndexIsComma(String winningNumber) {
        if (winningNumber.charAt(0) == ',') {
            System.out.println("[ERROR] 첫 번째 입력 값에 쉼표가 올 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}
