package lotto;

import static java.util.stream.Collectors.toList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
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

    private static void validateConsecutiveCommas(String winningNumber) {
        for (int seq = 0; seq < winningNumber.charAt(seq); seq++) {
            if (seq == winningNumber.length() - 1) {
                break;
            }
            validateConsecutive(winningNumber.charAt(seq), winningNumber.charAt(seq+1));
        }
    }

    private static void validateConsecutive(char sequence, char sequence2) {
        if (sequence == ',' && sequence2 == ',') {
            System.out.println("[ERROR] 당첨 번호는 쉼표(,) 하나로만 나눠야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static List<Integer> sliceWinningNumber(String winningNumber) {
        validateInputValue(winningNumber);
        validateConsecutiveCommas(winningNumber);
        return new ArrayList<>(List.of(winningNumber.split(",")))
                .stream()
                .map(Integer::parseInt)
                .collect(toList());
    }
}