package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validLengthWinningNumber(numbers);
        duplicateWinningNumber(numbers);
        this.numbers = numbers;
    }

    private void validLengthWinningNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 총 6자리 입니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void duplicateWinningNumber(List<Integer> winningLottoNumber) {
        if(winningLottoNumber.size()!=winningLottoNumber.stream().distinct().count())
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복이 있으면 안됩니다.");
    }
}
