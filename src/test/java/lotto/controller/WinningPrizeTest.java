package lotto.controller;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningPrizeTest {

    @Nested
    class FindEnumByRankTest {

        @Test
        void findEnumByRank_case1(){
            int input = 1;
            WinningPrize output = WinningPrize.FIRST;
            assertThat(WinningPrize.findEnumByRank(input)).isEqualTo(output);
        }

        @Test
        void findEnumByRank_case2(){
            int input = 2;
            WinningPrize output = WinningPrize.SECOND;
            assertThat(WinningPrize.findEnumByRank(input)).isEqualTo(output);
        }

        @Test
        void findEnumByRank_case3(){
            int input = 3;
            WinningPrize output = WinningPrize.THIRD;
            assertThat(WinningPrize.findEnumByRank(input)).isEqualTo(output);
        }

        @Test
        void findEnumByRank_case4(){
            int input = 4;
            WinningPrize output = WinningPrize.FOURTH;
            assertThat(WinningPrize.findEnumByRank(input)).isEqualTo(output);
        }

        @Test
        void findEnumByRank_case5(){
            int input = 5;
            WinningPrize output = WinningPrize.FIFTH;
            assertThat(WinningPrize.findEnumByRank(input)).isEqualTo(output);
        }
    }
}