package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryChecker {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LotteryChecker() {
        winningLotto = inputWinningLotto();
        bonusNumber = inputBonusNumber();
    }

    private Lotto inputWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers;
        try {
            winningNumbers = Stream.of(Console.readLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return new Lotto(winningNumbers);
    }

    private int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int number;
        try {
             number = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (winningLotto.hasNumber(number)) {
            throw new IllegalArgumentException();
        }

        return number;
    }
}
