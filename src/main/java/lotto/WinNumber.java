package lotto;

import org.mockito.internal.configuration.IndependentAnnotationEngine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinNumber {

    private final List<Integer> numbers;

    public void requestWinLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public WinNumber(String numbers) {
        List<Integer> tmpNumbers = validateNumberType(numbers);
        validateNumberLength(tmpNumbers);
        validateNumberReplicate(tmpNumbers);
        validateNumberRange(tmpNumbers);
        this.numbers = tmpNumbers;
    }

    public List<Integer> validateNumberType(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());}
        catch (Exception e) {
            System.out.println("[ERROR] 로또 당첨 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 당첨 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberReplicate(List<Integer> numbers) {
        Set<Integer> independentNumbers = new HashSet<>(numbers);

        if (independentNumbers.size() != numbers.size()) {
            System.out.println("[ERROR] 로또 번호는 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                System.out.println("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }
}
