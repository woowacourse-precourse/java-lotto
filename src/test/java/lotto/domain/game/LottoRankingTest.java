package lotto.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankingTest {

    @Nested
    @DisplayName("findRewardMessage 메소드는")
    class DescribeFindRewardMessageMethodTest {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "FIFTH:(5,000원)",
                        "FOURTH:(50,000원)",
                        "THIRD:(1,500,000원)",
                        "SECOND:(30,000,000원)",
                        "FIRST:(2,000,000,000원)"
                    },
                    delimiter = ':'
            )
            @DisplayName("형식에 맞는 당첨 금액을 반환한다")
            void it_returns_rewardMessage(LottoRanking lottoRanking, String expected) {
                String actual = lottoRanking.findRewardMessage();

                assertThat(actual).contains(expected);
            }
        }
    }

    @Nested
    @DisplayName("calculateTotalTargetLottoRankingReward 메소드는")
    class DescribeCalculateTotalTargetLottoRankingRewardMethodTest {

        @Nested
        @DisplayName("만약 당첨된 횟수가 주어지면")
        class ContextWithNumberOfWins {

            private static final int DEFAULT_NUMBER_OF_WINS = 1;

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "FIRST:2000000000",
                        "SECOND:30000000",
                        "THIRD:1500000",
                        "FOURTH:50000",
                        "FIFTH:5000"
                    },
                    delimiter = ':'
            )
            @DisplayName("총 상금을 계산해 반환한다")
            void it_returns_totalReward(LottoRanking lottoRanking, Long actual) {
                BigDecimal result = lottoRanking.calculateTotalTargetLottoRankingReward(DEFAULT_NUMBER_OF_WINS);

                assertThat(result).isEqualTo(new BigDecimal(actual));
            }
        }
    }

    @Nested
    @DisplayName("findLottoRanking 메소드는")
    class DescribeFindLottoRankingMethodTest {

        @Nested
        @DisplayName("만약 맞춘 로또 번호 개수와 보너스 번호를 맞췄는지 유무가 주어지면")
        class ContextWithoutParameterTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "0:true:NOTHING",
                        "0:false:NOTHING",
                        "1:true:NOTHING",
                        "1:false:NOTHING",
                        "2:true:NOTHING",
                        "2:false:NOTHING",
                        "3:true:FIFTH",
                        "3:false:FIFTH",
                        "4:true:FOURTH",
                        "4:false:FOURTH",
                        "5:false:THIRD",
                        "5:true:SECOND",
                        "6:true:FIRST",
                        "6:false:FIRST"
                    },
                    delimiter = ':'
            )
            @DisplayName("로또 등수를 반환한다")
            void it_returns_lottoRanking(long correctNumberCount, boolean isCorrectBonusNumber,
                    LottoRanking expected) {
                LottoRanking actual = LottoRanking.findLottoRanking(correctNumberCount, isCorrectBonusNumber);

                assertThat(actual).isSameAs(expected);
            }
        }
    }

    @Nested
    @DisplayName("hasReward 메소드는")
    class DescribeHasRewardMethodTest {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "NOTHING:false",
                        "FIFTH:true",
                        "FOURTH:true",
                        "THIRD:true",
                        "SECOND:true",
                        "FIRST:true"
                    },
                    delimiter = ':'
            )
            @DisplayName("상금이 있는 로또 등수인지 여부를 반환한다")
            void it_returns_hasReward(LottoRanking lottoRanking, boolean expected) {
                boolean actual = lottoRanking.hasReward();

                assertThat(actual).isSameAs(expected);
            }
        }
    }
}