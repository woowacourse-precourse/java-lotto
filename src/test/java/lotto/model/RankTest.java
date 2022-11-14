package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.MoneyConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RankTest {

    @DisplayName("순위 생성 시 정의된 값 이외의 값으로 생성하려는 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-100,-1,0,6,7,8,9,10,11,100,1000})
    void createRankWithInvalidValue(int rankValue) {
        //given
        String INVALID_RANK_VALUE_MSG = "유효하지 않은 순위값입니다";
        //when
        //then
        assertThatThrownBy(() -> Rank.from(rankValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANK_VALUE_MSG);
    }

    @DisplayName("순위 생성 시 정의된 값으로 생성하는 경우 정상 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void createMoneyWithValidValue(int rankValue) {
        //given
        String RANK_NAME_PREFIX = "NO_";
        //when
        Rank createdRank = Rank.from(rankValue);
        //then
        Assertions.assertThat(createdRank).isInstanceOf(Rank.class);
        Assertions.assertThat(createdRank.name()).isEqualTo(RANK_NAME_PREFIX + rankValue);

    }
}
