package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinNumber {

    private final List<Integer> numbers;

    public void requestWinLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public WinNumber(String numbers) {
        List<Integer> tmpNumbers = validateNumberType(numbers);
        validateNumberLength(tmpNumbers);
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
}
