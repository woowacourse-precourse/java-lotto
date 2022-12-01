package lotto.utils.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameStatusTest {

    @Nested
    @DisplayName("playable 메소드는")
    class DescribePlayableMethodTest {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "PURCHASE_AMOUNT:true",
                        "WINNING_LOTTO:true",
                        "BONUS_NUMBER:true",
                        "APPLICATION_EXIT:false",
                        "APPLICATION_EXCEPTION:false"
                    },
                    delimiter = ':'
            )
            @DisplayName("게임 진행 여부를 반환한다")
            void it_returns_playable(GameStatus gameStatus, boolean expected) {
                boolean actual = gameStatus.playable();

                assertThat(actual).isSameAs(expected);
            }
        }
    }
}