package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    private static final String FIRST_STATE = "6개 일치 (2,000,000,000원)";
    private static final String SECOND_STATE = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private static final String THIRD_STATE = "5개 일치 (1,500,000원)";
    private static final String FOURTH_STATE = "4개 일치 (50,000원)";
    private static final String FIFTH_STATE = "3개 일치 (5,000원)";

    @DisplayName("맞춘 개수가 6개일 경우 1등을 반환하는지 확인한다.")
    @Test
    void createFirstRankWithMatchingNumber() {
        Rank firstRank = Rank.of(6, false);

        Assertions.assertThat(firstRank).isEqualTo(Rank.FIRST);
        Assertions.assertThat(firstRank.toString()).isEqualTo(FIRST_STATE);
    }

    @DisplayName("맞춘 개수가 5개 + 보너스 1개일 경우 1등을 반환하는지 확인한다.")
    @Test
    void createSecondRankWithMatchingNumber() {
        Rank firstRank = Rank.of(5, true);

        Assertions.assertThat(firstRank).isEqualTo(Rank.SECOND);
        Assertions.assertThat(firstRank.toString()).isEqualTo(SECOND_STATE);
    }

    @DisplayName("맞춘 개수가 5개일 경우 3등을 반환하는지 확인한다.")
    @Test
    void createThirdRankWithMatchingNumber() {
        Rank firstRank = Rank.of(5, false);

        Assertions.assertThat(firstRank).isEqualTo(Rank.THIRD);
        Assertions.assertThat(firstRank.toString()).isEqualTo(THIRD_STATE);
    }

    @DisplayName("맞춘 개수가 4개일 경우 4등을 반환하는지 확인한다.")
    @Test
    void createFourthRankWithMatchingNumber() {
        Rank firstRank = Rank.of(4, false);

        Assertions.assertThat(firstRank).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(firstRank.toString()).isEqualTo(FOURTH_STATE);
    }

    @DisplayName("맞춘 개수가 3개일 경우 5등을 반환하는지 확인한다.")
    @Test
    void createFifthRankWithMatchingNumber() {
        Rank firstRank = Rank.of(3, false);

        Assertions.assertThat(firstRank).isEqualTo(Rank.FIFTH);
        Assertions.assertThat(firstRank.toString()).isEqualTo(FIFTH_STATE);
    }

    @DisplayName("맞춘 개수가 2개일 경우 꼴등임을 반환하는지 확인한다.")
    @Test
    void createNothingRankWithTwoMatchingNumber() {
        Rank firstRank = Rank.of(2, false);

        Assertions.assertThat(firstRank).isEqualTo(Rank.NOTHING);
    }

    @DisplayName("맞춘 개수가 1개일 경우 꼴등임을 반환하는지 확인한다.")
    @Test
    void createNothingRankWithOneMatchingNumber() {
        Rank firstRank = Rank.of(1, false);

        Assertions.assertThat(firstRank).isEqualTo(Rank.NOTHING);
    }

    @DisplayName("맞춘 개수가 0개일 경우 꼴등임을 반환하는지 확인한다.")
    @Test
    void createNothingRankWithZeroMatchingNumber() {
        Rank firstRank = Rank.of(0, false);

        Assertions.assertThat(firstRank).isEqualTo(Rank.NOTHING);
    }
}