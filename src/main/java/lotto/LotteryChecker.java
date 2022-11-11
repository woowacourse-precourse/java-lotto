package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryChecker {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LotteryChecker() {
        winningNumbers = inputWinningNumbers();
        bonusNumber = inputBonusNumber();
    }

    public LottoRanking check(Lotto lotto) {
        int match_count = (int) winningNumbers.stream()
                .filter(lotto::hasNumber)
                .count();
        boolean bonus_match = lotto.hasNumber(bonusNumber);

        if (match_count == 6) return LottoRanking.RANK_1;
        if (match_count == 5 && bonus_match) return LottoRanking.RANK_2;
        if (match_count == 5) return LottoRanking.RANK_3;
        if (match_count == 4) return LottoRanking.RANK_4;
        if (match_count == 3) return LottoRanking.RANK_5;

        return LottoRanking.RANK_LOSE;
    }

    private List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers;
        try {
            String input = Console.readLine();
            winningNumbers = Stream.of(input.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            new Lotto(winningNumbers); // validate
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return winningNumbers;
    }

    private int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int number;
        try {
            number = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException();
        }

        return number;
    }
}
