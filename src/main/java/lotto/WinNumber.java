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
        List<Integer> tmpNumbers = convertStringToIntegerList(numbers);
        validateNumberLength(tmpNumbers);
        this.numbers = tmpNumbers;
    }

    public List<Integer> convertStringToIntegerList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void validateNumberLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("로또 당첨 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
