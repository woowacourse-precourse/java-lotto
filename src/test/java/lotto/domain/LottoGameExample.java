package lotto.domain;

import java.util.List;
import lotto.constants.RankingInformation;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;

public class LottoGameExample {

    private static final WinningLotto WIN_LOTTO = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    private static final Lotto NOT_WIN_NUMBER = new Lotto(List.of(1, 2, 7, 8, 9, 10));

    public enum ExampleLottosAndRanks {
        FIFTH_PLACE(new Lotto(List.of(1, 3, 5, 7, 9, 10)), RankingInformation.FIFTH_PLACE),
        FOURTH_PLACE(new Lotto(List.of(3, 4, 5, 6, 7, 8)), RankingInformation.FOURTH_PLACE),
        THIRD_PLACE(new Lotto(List.of(1, 3, 4, 5, 6, 8)), RankingInformation.THIRD_PLACE),
        SECOND_PLACE(new Lotto(List.of(1, 2, 4, 5, 6, 7)), RankingInformation.SECOND_PLACE),
        FIRST_PLACE(new Lotto(List.of(1, 2, 3, 4, 5, 6)), RankingInformation.FIRST_PLACE);

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

    public static WinningLotto getWinningNumber() {
        return WIN_LOTTO;
    }

    public static Lotto getNotWinNumber() {
        return NOT_WIN_NUMBER;
    }
}
