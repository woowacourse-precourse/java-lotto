package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCountingTest {

    LottoCounting lottoCounter = new LottoCounting();

    @DisplayName("테스트를 위해,당첨 숫자는 1,2,3,4,5,6 으로 고정한다.")
    Lotto getWinningLotto(){
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        return new Lotto(winningNumber);
    }

    // 위에서부터 6개 일치, 5개 일치 및 보너스번호 일치, 5개 일치, 4개 일치, 3개 일치, 2개 일치, 1개 일치, 0개 일치 2개 순으로 나열했다.
    // 1등,2등,3등,4등,5등, 당첨없음, 당첨없음 순이다.
    Lotto[] lottoPaperInput = new Lotto[]{
            new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 6
            new Lotto(List.of(1, 2, 4, 5, 6, 8)), // 5
            new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 5
            new Lotto(List.of(1, 2, 3, 4, 9, 19)), // 4
            new Lotto(List.of(4, 5, 6, 7, 8, 9)), // 3
            new Lotto(List.of(1, 5, 10, 20, 30, 40)), // 2
            new Lotto(List.of(1, 10, 20, 30, 40, 45)), // 1
            new Lotto(List.of(10, 20, 30, 40, 42, 44)), // 0
            new Lotto(List.of(20, 30, 40, 41, 42, 43)), // 0
    };

    int bonusNumber = 8;

    @Nested
    class CompareLottoAndCountTest{

        @DisplayName("테스트 방식이 다 똑같아서, 하나의 메서드로 합쳤다.")
        void getCaseTest(List<Integer> input, int output){
            Lotto oneLottoPaper = new Lotto(input);
            Lotto winningLotto = getWinningLotto();
            assertThat(lottoCounter.compareLottoAndCount(oneLottoPaper,winningLotto)).isEqualTo(output);
        }

        @Test
        void compareLottoAndCount_case1(){
            List<Integer> oneSetOfNumber = lottoPaperInput[0].getNumbers();
            int output = 6;
            getCaseTest(oneSetOfNumber,output);
        }

        @Test
        void compareLottoAndCount_case2(){
            List<Integer> oneSetOfNumber = lottoPaperInput[1].getNumbers();
            int output = 5;
            getCaseTest(oneSetOfNumber,output);
        }

        @Test
        void compareLottoAndCount_case3(){

            List<Integer> oneSetOfNumber = lottoPaperInput[3].getNumbers();
            int output = 4;
            getCaseTest(oneSetOfNumber,output);
        }

        @Test
        void compareLottoAndCount_case4(){
            List<Integer> oneSetOfNumber = lottoPaperInput[4].getNumbers();
            int output = 3;
            getCaseTest(oneSetOfNumber,output);
        }

        @Test
        void compareLottoAndCount_case5() {
            List<Integer> oneSetOfNumber = lottoPaperInput[5].getNumbers();
            int output = 2;
            getCaseTest(oneSetOfNumber,output);
        }
        @Test
        void compareLottoAndCount_case6(){
            List<Integer> oneSetOfNumber = lottoPaperInput[6].getNumbers();
            int output = 1;
            getCaseTest(oneSetOfNumber,output);
        }

        @Test
        void compareLottoAndCount_case7(){
            List<Integer> oneSetOfNumber = lottoPaperInput[7].getNumbers();
            int output = 0;
            getCaseTest(oneSetOfNumber,output);
        }
    }

    @Nested
    class CountedLottoTest{

        Lotto[] getLottoPaperInput(int size){
            Lotto[] lottoPapers = new Lotto[size];
            System.arraycopy(lottoPaperInput, 0, lottoPapers, 0, size);
            return lottoPapers;
        }
        boolean isDataAllCorrect(Lotto[] lottoPapers, Lotto winningLotto, Map<Lotto, Integer> countedLotto){

            for (Lotto lottoPaper : lottoPapers) {
                int expectedCorrectCount = lottoCounter.compareLottoAndCount(lottoPaper, winningLotto);
                int actualCorrectCount = countedLotto.get(lottoPaper);
                if (expectedCorrectCount != actualCorrectCount) {
                    return false;
                }
            }
            return true;
        }
        @DisplayName("맵에 넣은 데이터들이 모두 올바르게 들어가있는지 테스트하는 메서드.")
        void testDataIsAllCorrect(int size){
            Lotto[] lottoPapers = getLottoPaperInput(size);
            Map<Lotto, Integer> countedLotto = lottoCounter.countedLotto(lottoPapers,getWinningLotto());
            assertThat(isDataAllCorrect(lottoPapers,getWinningLotto(),countedLotto)).isTrue();
        }


        @Test
        void countedLotto_case1_1(){
            Lotto[] lottoPapers = new Lotto[0];
            int sizeOutput = 0;
            assertThat(lottoCounter.countedLotto(lottoPapers,getWinningLotto()).size()).isEqualTo(sizeOutput);
        }

        @Test
        void countedLotto_case1_2(){
            Lotto[] lottoPapers = new Lotto[0];
            Map<Lotto, Integer> countedLotto = lottoCounter.countedLotto(lottoPapers,getWinningLotto());
            assertThat(isDataAllCorrect(lottoPapers,getWinningLotto(),countedLotto)).isTrue();
        }

        @Test
        void countedLotto_case2_1(){
            int size = 1;
            int sizeOutput = 1;
            Lotto[] lottoPapers = getLottoPaperInput(size);
            assertThat(lottoCounter.countedLotto(lottoPapers,getWinningLotto()).size()).isEqualTo(sizeOutput);
        }

        @Test
        void countedLotto_case2_2(){
            int size = 1;
            testDataIsAllCorrect(size);
        }

        @Test
        void countedLotto_case3_1(){
            int size = 3;
            int sizeOutput = 3;

            Lotto[] lottoPapers = getLottoPaperInput(size);
            assertThat(lottoCounter.countedLotto(lottoPapers,getWinningLotto()).size()).isEqualTo(sizeOutput);
        }

        @Test
        void countedLotto_case3_2(){
            int size = 3;
            testDataIsAllCorrect(size);
        }

        @Test
        void countedLotto_case4_1(){
            int size = 5;
            int sizeOutput = 5;

            Lotto[] lottoPapers = getLottoPaperInput(size);
            assertThat(lottoCounter.countedLotto(lottoPapers,getWinningLotto()).size()).isEqualTo(sizeOutput);
        }

        @Test
        void countedLotto_case4_2(){
            int size = 5;
            testDataIsAllCorrect(size);
        }

        @Test
        void countedLotto_case5_1(){
            int size = 8;
            int sizeOutput = 8;

            Lotto[] lottoPapers = getLottoPaperInput(size);
            assertThat(lottoCounter.countedLotto(lottoPapers,getWinningLotto()).size()).isEqualTo(sizeOutput);
        }

        @Test
        void countedLotto_case5_2(){
            int size = 8;
            testDataIsAllCorrect(size);
        }
    }

    
}