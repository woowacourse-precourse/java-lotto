package lotto.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;
import lotto.input.Input;

public class LottoValidator {
    private static final Input input = new Input();

    public String[] splitNumbers(String input) { // 입력한 값을 String 배열로 넘긴다.
        return input.split(",");
    }

    public List<Integer> convertNumbers(String[] numbers) { // String 배열을 List로 반환
        List<Integer> prizeNumbers = new ArrayList<>();
        for (String number : numbers) {
            prizeNumbers.add(input.convertInput(number));
        }
        return prizeNumbers;
    }

    public void duplicationNumbers(List<Integer> numbers) { // 배열의 값이 6인지와 중복 값이 있는지 확인
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        Lotto lotto = new Lotto(new ArrayList<>(checkNumbers));
    }

    public boolean duplicationBonusNumber(List<Integer> numbers, int number) { // 보너스 번호가 이미 배열에 있는지
        if (numbers.contains(number)) {
            throw new LottoException(this.getClass());
        }
        return true;
    }

    public void validationNumbersInRange(List<Integer> numbers) { // 입력한 로또배열의 유효값 확인
        for (int number : numbers) {
            validationNumberInRange(number);
        }
    }

    public void validationNumberInRange(int number) { // 입력한 로또 부분이 1 ~ 45의 값인지
        if (!(1 <= number && number <= 45)) {
            throw new LottoException(this.getClass());
        }
    }
}
