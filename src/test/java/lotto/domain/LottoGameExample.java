package lotto.domain;

import java.util.List;
import lotto.constants.RankingInformation;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumber;

public class LottoGameExample {
    private static final WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
    private static final Lotto notWinNumber = new Lotto(List.of(1, 2, 7, 8, 9, 10));

    public enum ExampleLottosAndRanks {
        FIFTH_RANK(new Lotto(List.of(1, 3, 5, 7, 9, 10)), RankingInformation.FIFTH_PLACE),
        FOURTH_RANK(new Lotto(List.of(3, 4, 5, 6, 7, 8)), RankingInformation.FOURTH_PLACE),
        THIRD_RANK(new Lotto(List.of(1, 3, 4, 5, 6, 8)), RankingInformation.THIRD_PLACE),
        SECOND_RANK(new Lotto(List.of(1, 2, 4, 5, 6, 7)), RankingInformation.SECOND_PLACE),
        FIRST_RANK(new Lotto(List.of(1, 2, 3, 4, 5, 6)), RankingInformation.FIRST_PLACE);

        private final Lotto lotto;
        private final RankingInformation rank;

        ExampleLottosAndRanks(Lotto lotto, RankingInformation rank) {
            this.lotto = lotto;
            this.rank = rank;
        }

        public Lotto getLotto() {
            return this.lotto;
        }

        public RankingInformation getRank() {
            return this.rank;
        }
    }

    public static WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public static Lotto getNotWinNumber() {
        return notWinNumber;
    }
}
