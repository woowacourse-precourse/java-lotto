package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;
    ExceptionHandling exceptionHandling = new ExceptionHandling();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int lottoCount(int number) {
        exceptionHandling.notDivideException(number); // 예외 검사
        return number / 1000;
    }

    public List<Integer> createLottoNumber(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    // TODO: 추가 기능 구현
}
