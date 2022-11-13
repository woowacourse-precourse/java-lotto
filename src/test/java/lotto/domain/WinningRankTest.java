package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRankTest {


    @ParameterizedTest(name = "isWin 테스트 {index}: {0} return {3}")
    @CsvSource(value = {"FIRST_RANK,6,false,true",
            "FIRST_RANK,5,true,false",
            "SECOND_RANK,5,true,true",
            "SECOND_RANK,5,false,false",
            "SECOND_RANK,6,false,false",
            "THIRD_RANK,5,false,true",
            "THIRD_RANK,4,true,false",
            "FOURTH_RANK,4,true,true",
            "FOURTH_RANK,6,false,false",
            "FIFTH_RANK,3,false,true",
            "FIFTH_RANK,1,true,false",
            "NONE_RANKED,2,true,true",
            "NONE_RANKED,3,false,false"})
    void isWinTest(WinningRank rank, int duplicatedCount, boolean isContainBonusNumber, boolean expected) {
        assertThat(rank.isWin(duplicatedCount, isContainBonusNumber)).isEqualTo(expected);
    }

}