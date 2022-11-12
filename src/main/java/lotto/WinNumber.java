package lotto;

import org.mockito.internal.configuration.IndependentAnnotationEngine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinNumber {

    private final Lotto numbers;

    public void requestWinLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public WinNumber(String numbers) {
        List<Integer> tmpNumbers = validateNumberType(numbers);
        this.numbers = new Lotto(tmpNumbers);
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
}
