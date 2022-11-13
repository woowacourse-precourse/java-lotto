package lotto.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Judgement {
    private List<Integer> compare(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getWinningLottoNumbers();
        return numbers.stream()
                .filter(number -> !winningNumbers.contains(number))
                .collect(toList());
    }
}
