package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCountingTest {

    LottoCounting lottoCounter = new LottoCounting();

    // 테스트를 위해,당첨 숫자는 1,2,3,4,5,6 으로 고정한다.
    Lotto getWinningLotto(){
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        return new Lotto(winningNumber);
    }

    // 로또종이 인풋 모음을 위에서 만들어놓고, 일일이 하드코딩하는 대신 대입하는 식으로 해본다.
    // 위에서부터 6개 일치, 5개 일치 및 보너스번호 일치, 5개 일치, 4개 일치, 3개 일치, 2개 일치, 1개 일치, 0개 일치 2개 순으로 나열했다.
    // 1등,2등,3등,4등,5등,당첨없음 4개 순이다.
    Lotto[] lottoPaperInput = new Lotto[]{
            new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 6, 1등
            new Lotto(List.of(1, 2, 4, 5, 6, 8)), // 5, 2등
            new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 5, 3등
            new Lotto(List.of(1, 2, 3, 4, 9, 19)), // 4, 4등
            new Lotto(List.of(4, 5, 6, 7, 8, 9)), // 3, 5등
            new Lotto(List.of(1, 5, 10, 20, 30, 40)), // 2, 탈락
            new Lotto(List.of(1, 10, 20, 30, 40, 45)), // 1, 탈락
            new Lotto(List.of(10, 20, 30, 40, 42, 44)), // 0, 탈락
            new Lotto(List.of(20, 30, 40, 41, 42, 43)), // 0, 탈락
    };
    // 보너스 넘버도, 테스트를 위해서 8로 고정한다.
    int bonusNumber = 8;

    // ex) input = "1 2 3 4 5" -> 1등 1개, 2등 2개, 3등 3개, 4등 4개, 5등 5개로 매핑하여, 맵을 만든다.
    Map<Integer, Integer> getWinningCountFromInput(String input){
        Map<Integer,Integer> winningCount = new HashMap<>();
        String[] individualCount = input.split(" ");
        for(int inputIndex = 1; inputIndex <= individualCount.length; inputIndex++){
            int oneWinningCount = Integer.parseInt(individualCount[inputIndex-1]);
            winningCount.put(inputIndex,oneWinningCount);
        }

        return winningCount;
    }

    @Nested
    class CompareLottoAndCountTest{

        // 테스트 방식이 같아서, 하나로 합쳤다.
        void getCaseTest(List<Integer> input, int output){
            Lotto oneLottoPaper = new Lotto(input);
            Lotto winningLotto = getWinningLotto();
            assertThat(lottoCounter.compareLottoAndCount(oneLottoPaper,winningLotto)).isEqualTo(output);
        }

        @DisplayName("1등 LottoNumber Case.")
        @Test
        void compareLottoAndCount_case1(){
            List<Integer> oneSetOfNumber = lottoPaperInput[0].getNumbers();
            int output = 6;
            getCaseTest(oneSetOfNumber,output);
        }

        @DisplayName("2,3등 LottoNumber Case")
        @Test
        void compareLottoAndCount_case2(){
            List<Integer> oneSetOfNumber = lottoPaperInput[1].getNumbers();
            int output = 5;
            getCaseTest(oneSetOfNumber,output);
        }

        @DisplayName("4등 LottoNumber Case")
        @Test
        void compareLottoAndCount_case3(){

            List<Integer> oneSetOfNumber = lottoPaperInput[3].getNumbers();
            int output = 4;
            getCaseTest(oneSetOfNumber,output);
        }

        @DisplayName("5등 LottoNumber Case")
        @Test
        void compareLottoAndCount_case4(){
            List<Integer> oneSetOfNumber = lottoPaperInput[4].getNumbers();
            int output = 3;
            getCaseTest(oneSetOfNumber,output);
        }

        @DisplayName("당첨제외 LottoNumber Case1 : 2개 맞음")
        @Test
        void compareLottoAndCount_case5() {
            List<Integer> oneSetOfNumber = lottoPaperInput[5].getNumbers();
            int output = 2;
            getCaseTest(oneSetOfNumber,output);
        }

        @DisplayName("당첨제외 LottoNumber Case2 : 1개 맞음")
        @Test
        void compareLottoAndCount_case6(){
            List<Integer> oneSetOfNumber = lottoPaperInput[6].getNumbers();
            int output = 1;
            getCaseTest(oneSetOfNumber,output);
        }

        @DisplayName("당첨제외 LottoNumber Case3 : 0개 맞음")
        @Test
        void compareLottoAndCount_case7(){
            List<Integer> oneSetOfNumber = lottoPaperInput[7].getNumbers();
            int output = 0;
            getCaseTest(oneSetOfNumber,output);
        }
    }

    @Nested
    class CountedLottoTest{

        List<Lotto> getLottoPaperInput(int size){
            return new ArrayList<>(Arrays.asList(lottoPaperInput).subList(0, size));
        }
        boolean isDataAllCorrect(List<Lotto> lottoPapers, Lotto winningLotto, Map<Lotto, Integer> countedLotto){

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
            List<Lotto> lottoPapers = getLottoPaperInput(size);
            Map<Lotto, Integer> countedLotto = lottoCounter.countedLotto(lottoPapers,getWinningLotto());
            assertThat(isDataAllCorrect(lottoPapers,getWinningLotto(),countedLotto)).isTrue();
        }


        @Test
        void countedLotto_case1_1(){
            List<Lotto> lottoPapers = new ArrayList<>();
            int sizeOutput = 0;
            assertThat(lottoCounter.countedLotto(lottoPapers,getWinningLotto()).size()).isEqualTo(sizeOutput);
        }

        @Test
        void countedLotto_case1_2(){
            List<Lotto> lottoPapers = new ArrayList<>();
            Map<Lotto, Integer> countedLotto = lottoCounter.countedLotto(lottoPapers,getWinningLotto());
            assertThat(isDataAllCorrect(lottoPapers,getWinningLotto(),countedLotto)).isTrue();
        }

        @Test
        void countedLotto_case2_1(){
            int size = 1;
            int sizeOutput = 1;
            List<Lotto> lottoPapers = getLottoPaperInput(size);
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

            List<Lotto> lottoPapers = getLottoPaperInput(size);
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

            List<Lotto> lottoPapers = getLottoPaperInput(size);
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

            List<Lotto> lottoPapers = getLottoPaperInput(size);
            assertThat(lottoCounter.countedLotto(lottoPapers,getWinningLotto()).size()).isEqualTo(sizeOutput);
        }

        @Test
        void countedLotto_case5_2(){
            int size = 8;
            testDataIsAllCorrect(size);
        }
    }

    @Nested
    class CountWinningPaperTest{

        Map<Lotto, Integer> getCountedLotto(int size){
            Lotto winningLotto = getWinningLotto();
            List<Lotto> lottoPapers = getLottoPapersFromData(size);
            return lottoCounter.countedLotto(lottoPapers,winningLotto);
        }

        List<Lotto> getLottoPapersFromData(int size){
            return new ArrayList<>(Arrays.asList(lottoPaperInput).subList(0, size));
        }

        // 체크해야 되는 부분 : 1등 몇개 2등 몇개 등등 잘 매칭되어 들어갔는지?
        // index :
        // 0 : 1등
        // 1 : 2등
        // 2 : 3등
        // 3 : 4등
        // 4 : 5등
        // 5~8 : 탈락(-1)

        void putExpectedResult(Map<Integer, Integer> expectedResult,String input){
            String[] inputs = input.split(" ");
            for(int inputIndex = 1 ; inputIndex <= inputs.length; inputIndex++){
                int value = Integer.parseInt(inputs[inputIndex-1]);
                int ranking = inputIndex;
                if(6 <= ranking) {
                    ranking = -1;
                }
                expectedResult.put(ranking,value);
            }
        }

        void testWinningPaperCase(int sizeInput, String expectedOutput){
            Map<Lotto,Integer> countedLotto = getCountedLotto(sizeInput);

            Map<Integer, Integer> expectedResult = new HashMap<>();
            putExpectedResult(expectedResult,expectedOutput);
            Map<Integer, Integer> actualResult = lottoCounter.countWinningPaper(countedLotto,bonusNumber);

            assertThat(actualResult).isEqualTo(expectedResult);
        }

        @Test
        void countWinningPaper_case1(){
            int sizeInput = 1;
            String expectedOutput = "1";
            testWinningPaperCase(sizeInput,expectedOutput);
        }

        @Test
        void countWinningPaper_case2(){
            int sizeInput = 2;
            String expectedOutput = "1 1";
            testWinningPaperCase(sizeInput,expectedOutput);
        }

        @Test
        void countWinningPaper_case3(){
            int sizeInput = 3;
            String expectedOutput = "1 1 1";
            testWinningPaperCase(sizeInput,expectedOutput);
        }


        @Test
        void countWinningPaper_case4(){
            int sizeInput = 4;
            String expectedOutput = "1 1 1 1";
            testWinningPaperCase(sizeInput,expectedOutput);
        }

        @Test
        void countWinningPaper_case5(){
            int sizeInput = 5;
            String expectedOutput = "1 1 1 1 1";
            testWinningPaperCase(sizeInput,expectedOutput);
        }

        @Test
        void countWinningPaper_case6(){
            int sizeInput = 8;
            String expectedOutput = "1 1 1 1 1 3";
            testWinningPaperCase(sizeInput,expectedOutput);
        }
    }

    @Nested
    class CalculateEarningMoneyTest{



        @Test
        void calculateEarningMoney_case1(){
            String input = "1 0 0 0 0";
            int output = 2_000_000_000;

            Map<Integer, Integer> winningCount = getWinningCountFromInput(input);
            assertThat(lottoCounter.calculateEarningMoney(winningCount)).isEqualTo(output);
        }

        @Test
        void calculateEarningMoney_case2(){
            String input = "0 1 0 0 0";
            int output = 30_000_000;

            Map<Integer, Integer> winningCount = getWinningCountFromInput(input);
            assertThat(lottoCounter.calculateEarningMoney(winningCount)).isEqualTo(output);
        }

        @Test
        void calculateEarningMoney_case3(){
            String input = "0 0 1 0 0";
            int output = 1_500_000;

            Map<Integer, Integer> winningCount = getWinningCountFromInput(input);
            assertThat(lottoCounter.calculateEarningMoney(winningCount)).isEqualTo(output);
        }

        @Test
        void calculateEarningMoney_case4(){
            String input = "0 0 0 1 0";
            int output = 50_000;

            Map<Integer, Integer> winningCount = getWinningCountFromInput(input);
            assertThat(lottoCounter.calculateEarningMoney(winningCount)).isEqualTo(output);
        }

        @Test
        void calculateEarningMoney_case5(){
            String input = "0 0 0 0 1";
            int output = 5_000;

            Map<Integer, Integer> winningCount = getWinningCountFromInput(input);
            assertThat(lottoCounter.calculateEarningMoney(winningCount)).isEqualTo(output);
        }

        @Test
        void calculateEarningMoney_case6(){
            String input = "0 0 1 1 1";
            int output = 1_555_000;

            Map<Integer, Integer> winningCount = getWinningCountFromInput(input);
            assertThat(lottoCounter.calculateEarningMoney(winningCount)).isEqualTo(output);
        }

        @Test
        void calculateEarningMoney_case7(){
            String input = "1 1 1 0 0";
            int output = 2_031_500_000;

            Map<Integer, Integer> winningCount = getWinningCountFromInput(input);
            assertThat(lottoCounter.calculateEarningMoney(winningCount)).isEqualTo(output);
        }

        @Test
        void calculateEarningMoney_case8(){
            String input = "0 0 0 0 0";
            int output = 0;

            Map<Integer, Integer> winningCount = getWinningCountFromInput(input);
            assertThat(lottoCounter.calculateEarningMoney(winningCount)).isEqualTo(output);
        }
    }

    @Nested
    class GetThisRankingsAmountTest{

        String input = "4 3 2 1 5";
        Map<Integer, Integer> winningCounts = getWinningCountFromInput(input);

        @Test
        void getThisRankingsAmount_case1(){
            int ranking = 1;
            int output = 4;
            assertThat(lottoCounter.getThisRankingsAmount(winningCounts,ranking)).isEqualTo(output);
        }

        @Test
        void getThisRankingsAmount_case2(){
            int ranking = 2;
            int output = 3;
            assertThat(lottoCounter.getThisRankingsAmount(winningCounts,ranking)).isEqualTo(output);
        }

        @Test
        void getThisRankingsAmount_case3(){
            int ranking = 3;
            int output = 2;
            assertThat(lottoCounter.getThisRankingsAmount(winningCounts,ranking)).isEqualTo(output);
        }

        @Test
        void getThisRankingsAmount_case4(){
            int ranking = 4;
            int output = 1;
            assertThat(lottoCounter.getThisRankingsAmount(winningCounts,ranking)).isEqualTo(output);
        }

        @Test
        void getThisRankingsAmount_case5(){
            int ranking = 5;
            int output = 5;
            assertThat(lottoCounter.getThisRankingsAmount(winningCounts,ranking)).isEqualTo(output);
        }
    }
}