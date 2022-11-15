package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validLengthWinningNumber(numbers);
        duplicateWinningNumber(numbers);
        outOfRangeWinningNumber(numbers);
        this.numbers = numbers;
    }

    public Lotto(String winnerLottoNumber){
        validInputWinNumber(winnerLottoNumber);
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

    public List<Integer> convertWinnerNumber(String winnerLottoNumber) {
        return Arrays.stream(winnerLottoNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validInputWinNumber(String winnerLottoNumber) {
        try {
            String replaceNumber = winnerLottoNumber.replace(",", "");
            Integer.parseInt(replaceNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 콤마만 입력 가능합니다.");
        }
    }
}
