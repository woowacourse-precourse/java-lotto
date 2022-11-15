package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningRankTest {


    @ParameterizedTest(name = "당첨조건 확인 테스트 [{index}] : {0} return {3}")
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

    @ParameterizedTest(name = "당첨 조건으로 Rank 얻기 테스트 [{index}] : {2}")
    @CsvSource(value = {"6,false,FIRST_RANK",
            "5,true,SECOND_RANK",
            "5,false,THIRD_RANK",
            "4,true,FOURTH_RANK",
            "3,false,FIFTH_RANK",
            "1,false,NONE_RANKED"})
    void findByWinningConditionTest(int duplicatedNumberCount, boolean isContainBonusNumber, WinningRank expectedRank) {
        WinningRank actualRank = WinningRank.findByWinningCondition(duplicatedNumberCount, isContainBonusNumber);
        assertThat(actualRank).isEqualTo(expectedRank);
    }

    @ParameterizedTest(name = "잘못된 당첨 조건 입력시 예외 발생 테스트 [{index}] : {0}개 일치, 보너스번호 일치 여부 - {1} 입력")
    @CsvSource(value = {"7,false", "-1,true", "6,true"})
    void wrongWinningConditionTest(int duplicatedNumberCount, boolean isContainBonusNumber) {
        assertThatThrownBy(() -> WinningRank.findByWinningCondition(duplicatedNumberCount, isContainBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WinningRank.RANK_NOT_FOUND_ERROR_MESSAGE);
    }

}