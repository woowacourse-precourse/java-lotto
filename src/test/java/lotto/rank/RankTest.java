package lotto.rank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RankTest {
    enum Amount {
        ;
        private static final long FIRST = 2_000_000_000L;
        private static final long SECOND = 30_000_000L;
        private static final long THIRD = 1_500_000L;
        private static final long FOURTH = 50_000L;
        private static final long FIFTH = 5_000L;
    }
    enum Place {
        ;
        private static final String FIRST = "FIRST";
        private static final String SECOND = "SECOND";
        private static final String THIRD = "THIRD";
        private static final String FOURTH = "FOURTH";
        private static final String FIFTH = "FIFTH";
    }

    @Nested
    class CheckRank {
        @DisplayName("1등 당첨")
        @Test
        void prizeRank1() {
            // given
            int number = 6;
            boolean bonus = false;
            Rank result = Rank.valueOf(Place.FIRST);

            // when
            Rank rank = Rank.getRank(number, bonus);

            // then
            assertThat(rank)
                    .isEqualTo(result);
        }

        @DisplayName("2등 당첨")
        @Test
        void prizeRank2() {
            // given
            int number = 6;
            boolean bonus = true;
            Rank result = Rank.valueOf(Place.SECOND);

            // when
            Rank rank = Rank.getRank(number, bonus);

            // then
            assertThat(rank)
                    .isEqualTo(result);
        }

        @DisplayName("3등 당첨")
        @Test
        void prizeRank3() {
            // given
            int number = 5;
            boolean bonus = true;
            Rank result = Rank.valueOf(Place.THIRD);

            // when
            Rank rank = Rank.getRank(number, bonus);

            // then
            assertThat(rank)
                    .isEqualTo(result);
        }

        @DisplayName("4등 당첨")
        @Test
        void prizeRank4() {
            // given
            int number = 4;
            boolean bonus = true;
            Rank result = Rank.valueOf(Place.FOURTH);

            // when
            Rank rank = Rank.getRank(number, bonus);

            // then
            assertThat(rank)
                    .isEqualTo(result);
        }

        @DisplayName("5등 당첨")
        @Test
        void prizeRank5() {
            // given
            int number = 3;
            boolean bonus = true;
            Rank result = Rank.valueOf(Place.FIFTH);

            // when
            Rank rank = Rank.getRank(number, bonus);

            // then
            assertThat(rank)
                    .isEqualTo(result);
        }

        @DisplayName("당첨되지 않은 경우")
        @Test
        void noPrizeRank() {
            // given
            int number = 2;
            boolean bonus = true;

            // when
            Rank rank = Rank.getRank(number, bonus);

            // then
            assertThat(rank)
                    .isNull();
        }

        @DisplayName("4개의 수를 맞추고 보너스가 틀린경우")
        @Test
        void prize_Number4_bonusFalse() {
            // given
            int number = 4;
            boolean bonus = false;
            Rank result = Rank.valueOf(Place.FOURTH); // 4등이 나와야 한다.

            // when
            Rank rank = Rank.getRank(number, bonus);

            // then
            assertThat(rank)
                    .isEqualTo(result);
        }

    }

    @Nested
    class CheckAmount {

        @DisplayName("1등 당첨 금액")
        @Test
        void first_amount() {
            // given
            Rank rank = Rank.valueOf(Place.FIRST);
            long result = Amount.FIRST;

            // when
            long winAmount = rank.getWinAmount();

            // then
            assertThat(winAmount)
                    .isEqualTo(result);

        }

        @DisplayName("2등 당첨 금액")
        @Test
        void second_amount() {
            // given
            Rank rank = Rank.valueOf(Place.SECOND);
            long result = Amount.SECOND;

            // when
            long winAmount = rank.getWinAmount();

            // then
            assertThat(winAmount)
                    .isEqualTo(result);
        }

        @DisplayName("3등 당첨 금액")
        @Test
        void third_amount() {
            // given
            Rank rank = Rank.valueOf(Place.THIRD);
            long result = Amount.THIRD;

            // when
            long winAmount = rank.getWinAmount();

            // then
            assertThat(winAmount)
                    .isEqualTo(result);
        }

        @DisplayName("4등 당첨 금액")
        @Test
        void fourth_amount() {
            // given
            Rank rank = Rank.valueOf(Place.FOURTH);
            long result = Amount.FOURTH;

            // when
            long winAmount = rank.getWinAmount();

            // then
            assertThat(winAmount)
                    .isEqualTo(result);
        }

        @DisplayName("5등 당첨 금액")
        @Test
        void fifth_amount() {
            // given
            Rank rank = Rank.valueOf(Place.FIFTH);
            long result = Amount.FIFTH;

            // when
            long winAmount = rank.getWinAmount();

            // then
            assertThat(winAmount)
                    .isEqualTo(result);
        }

        @DisplayName("1등이 3번 당첨될 경우 총 금액")
        @Test
        void first_3_totalAmount() {
            // given
            Rank rank = Rank.valueOf(Place.FIRST);
            long result = Amount.FIRST * 3;

            // when
            long totalAmount = rank.getTotalAmount(3);

            // then
            assertThat(totalAmount)
                    .isEqualTo(result);
        }
    }
}