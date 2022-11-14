package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinNumber {

    private final Lotto numbers;

    public WinNumber(String numbers) {
        List<Integer> tmpNumbers = validateNumberType(numbers);
        this.numbers = new Lotto(tmpNumbers);
        System.out.println();
    }

    public Lotto getWinNumber() {
        return this.numbers;
    }

    public List<Integer> validateNumberType(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("[ERROR] 로또 당첨 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
