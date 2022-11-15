package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validLengthWinningNumber(numbers);
        duplicateWinningNumber(numbers);
        outOfRangeWinningNumber(numbers);
        this.numbers = numbers;
    }

    private void validLengthWinningNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 총 6자리 입니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void duplicateWinningNumber(List<Integer> winningLottoNumber) {
        if (winningLottoNumber.size() != winningLottoNumber.stream().distinct().count())
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복이 있으면 안됩니다.");
    }

    private void outOfRangeWinningNumber(List<Integer> winningLottoNumber) {
        for (Integer number : winningLottoNumber) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
