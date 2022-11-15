package lotto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningPrizeTest {


    @Nested
    class FindRankingTest{
        List<Integer> lottoNumbers;
        Lotto lottoPapers;
        int bonusNumber;

        // 2등 테스팅을 위하여, 로또한장의 번호는 (1,2,3,4,5,6) 으로 고정한다.
        @BeforeEach
        void beforeSettingOfFindRanking(){
            lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            lottoPapers = new Lotto(lottoNumbers);
        }

        @DisplayName("6개 당첨, bonus 번호 포함.(1등)")
        @Test
        void findRanking_case1_1(){
            int amountOfCorrectNumbers = 6;
            bonusNumber = 6;
            int output = 1;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("6개 당첨, bonus 번호 미포함.(1등)")
        @Test
        void findRanking_case1_2(){
            int amountOfCorrectNumbers = 6;
            bonusNumber = 7;
            int output = 1;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("5개 당첨, bonus 번호 포함.(2등)")
        @Test
        void findRanking_case2(){
            int amountOfCorrectNumbers = 5;
            bonusNumber = 6;
            int output = 2;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("5개 당첨, bonus 번호 미포함.(3등)")
        @Test
        void findRanking_case3(){
            int amountOfCorrectNumbers = 5;
            bonusNumber = 7;
            int output = 3;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("4개 당첨, bonus 번호 포함.(4등)")
        @Test
        void findRanking_case4_1(){
            int amountOfCorrectNumbers = 4;
            bonusNumber = 6;
            int output = 4;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("4개 당첨, bonus 번호 미포함.(4등)")
        @Test
        void findRanking_case4_2(){
            int amountOfCorrectNumbers = 4;
            bonusNumber = 7;
            int output = 4;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("3개 당첨, bonus 번호 포함.(5등)")
        @Test
        void findRanking_case5_1(){
            int amountOfCorrectNumbers = 3;
            bonusNumber = 6;
            int output = 5;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("3개 당첨, bonus 번호 미포함.(5등)")
        @Test
        void findRanking_case5_2(){
            int amountOfCorrectNumbers = 3;
            bonusNumber = 7;
            int output = 5;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("2개 당첨, bonus 번호 포함.(탈락)")
        @Test
        void findRanking_case6_1(){
            int amountOfCorrectNumbers = 2;
            bonusNumber = 6;
            int output = -1;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("2개 당첨, bonus 번호 미포함.(탈락)")
        @Test
        void findRanking_case6_2(){
            int amountOfCorrectNumbers = 2;
            bonusNumber = 7;
            int output = -1;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("1개 당첨, bonus 번호 포함.(탈락)")
        @Test
        void findRanking_case6_3(){
            int amountOfCorrectNumbers = 1;
            bonusNumber = 6;
            int output = -1;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("1개 당첨, bonus 번호 미포함.(탈락)")
        @Test
        void findRanking_case6_4(){
            int amountOfCorrectNumbers = 1;
            bonusNumber = 7;
            int output = -1;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("0개 당첨, bonus 번호 포함.(탈락)")
        @Test
        void findRanking_case6_5(){
            int amountOfCorrectNumbers = 0;
            bonusNumber = 6;
            int output = -1;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }

        @DisplayName("0개 당첨, bonus 번호 미포함.(탈락)")
        @Test
        void findRanking_case6_6(){
            int amountOfCorrectNumbers = 0;
            bonusNumber = 7;
            int output = -1;
            assertThat(WinningPrize.findRanking(amountOfCorrectNumbers,lottoPapers,bonusNumber)).isEqualTo(output);
        }
    }

    @Nested
    class FindEnumByRankTest {

        @DisplayName("1등 랭킹 넣었을 때, FIRST WinningPrize Enum 나오기.")
        @Test
        void findEnumByRank_case1(){
            int input = 1;
            WinningPrize output = WinningPrize.FIRST;
            assertThat(WinningPrize.findEnumByRank(input)).isEqualTo(output);
        }

        @DisplayName("2등 랭킹 넣었을 때, SECOND WinningPrize Enum 나오기.")
        @Test
        void findEnumByRank_case2(){
            int input = 2;
            WinningPrize output = WinningPrize.SECOND;
            assertThat(WinningPrize.findEnumByRank(input)).isEqualTo(output);
        }

        @DisplayName("3등 랭킹 넣었을 때, THIRD WinningPrize Enum 나오기.")
        @Test
        void findEnumByRank_case3(){
            int input = 3;
            WinningPrize output = WinningPrize.THIRD;
            assertThat(WinningPrize.findEnumByRank(input)).isEqualTo(output);
        }

        @DisplayName("4등 랭킹 넣었을 때, FOURTH WinningPrize Enum 나오기.")
        @Test
        void findEnumByRank_case4(){
            int input = 4;
            WinningPrize output = WinningPrize.FOURTH;
            assertThat(WinningPrize.findEnumByRank(input)).isEqualTo(output);
        }

        @DisplayName("5등 랭킹 넣었을 때, FIFTH WinningPrize Enum 나오기.")
        @Test
        void findEnumByRank_case5(){
            int input = 5;
            WinningPrize output = WinningPrize.FIFTH;
            assertThat(WinningPrize.findEnumByRank(input)).isEqualTo(output);
        }
    }
}