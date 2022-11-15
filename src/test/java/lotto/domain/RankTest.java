package lotto.domain;

import lotto.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    AppConfig appConfig = new AppConfig();
    WinningNumbers winningNumbers = appConfig.createWinningNumbers();

    @DisplayName("1등")
    @Test
    void return_first() {

        assertThat(Rank.calculateRank(Lotto.generateFromRawValues(List.of(1, 2, 3, 4, 5, 6)),
                winningNumbers.generateFromRawValues(List.of(1, 2, 3, 4, 5, 6),7)))
                .isEqualTo(Rank.FIRST);
    }


    @DisplayName("2등")
    @Test
    void return_second() {

        assertThat(Rank.calculateRank(Lotto.generateFromRawValues(List.of(1, 2, 3, 4, 5, 7)),
                winningNumbers.generateFromRawValues(List.of(1, 2, 3, 4, 5, 6),7)))
                .isEqualTo(Rank.SECOND);
    }


    @DisplayName("3등")
    @Test
    void return_third() {

        assertThat(Rank.calculateRank(Lotto.generateFromRawValues(List.of(1, 2, 3, 4, 5, 6)),
                winningNumbers.generateFromRawValues(List.of(1, 2, 3, 4, 5, 7),8)))
                .isEqualTo(Rank.THIRD);
    }

    @DisplayName("4등")
    @Test
    void return_fourth() {

        assertThat(Rank.calculateRank(Lotto.generateFromRawValues(List.of(1, 2, 3, 4, 5, 6)),
                winningNumbers.generateFromRawValues(List.of(1, 2, 3, 4, 9, 8),7)))
                .isEqualTo(Rank.FOURTH);
    }

    @DisplayName("5등")
    @Test
    void return_fifth() {

        assertThat(Rank.calculateRank(Lotto.generateFromRawValues(List.of(1, 2, 3, 4, 5, 6)),
                winningNumbers.generateFromRawValues(List.of(1, 2, 3, 23, 29, 10),7)))
                .isEqualTo(Rank.FIFTH);
    }

    @DisplayName("꽝")
    @Test
    void return_zero_match() {

        assertThat(Rank.calculateRank(Lotto.generateFromRawValues(List.of(1, 2, 3, 4, 5, 6)),
                winningNumbers.generateFromRawValues(List.of(45, 44, 43, 41, 42, 40),7)))
                .isEqualTo(Rank.ZERO_MATCH);
    }


}