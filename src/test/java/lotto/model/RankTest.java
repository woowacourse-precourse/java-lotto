package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {
    private static final String FIRST_STATE = "6개 일치 (2,000,000,000원)";
    private static final String SECOND_STATE = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private static final String THIRD_STATE = "5개 일치 (1,500,000원)";
    private static final String FOURTH_STATE = "4개 일치 (50,000원)";
    private static final String FIFTH_STATE = "3개 일치 (5,000원)";

    @DisplayName("맞춘 개수에 따른 등수를 반환한다. ")
    @ParameterizedTest
    @CsvSource({"6,false,FIRST", "5,true,SECOND", "5,false,THIRD",
            "3,false,FIFTH", "2,false,NOTHING", "0,false,NOTHING"})
    void createRankWithMatchingNumber(int matchingNumber, boolean hasBonusNumber, Rank rank) {
        Rank firstRank = Rank.of(matchingNumber, hasBonusNumber);

        Assertions.assertThat(firstRank).isEqualTo(rank);
        Assertions.assertThat(firstRank.toString()).isEqualTo(rank.toString());
    }

    @DisplayName("맞춘 개수에 따른 상금의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource({"FIRST, 1, 2000000000", "FIRST,2,4000000000",
            "SECOND, 1, 30000000", "SECOND, 2, 60000000",
            "THIRD, 1, 1500000", "THIRD, 2, 3000000"})
    public void computePrice(Rank rank, int numberOfRank, long result) {
        Assertions.assertThat(rank.computePrice(numberOfRank)).isEqualTo(result);
    }
}