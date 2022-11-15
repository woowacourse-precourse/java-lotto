package lotto.InputOutput;

import lotto.controller.LottoCounting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameOutputHandlerTest {

    GameOutputHandler outputHandler = new GameOutputHandler();
    LottoCounting lottoCounter = new LottoCounting();
    static OutputStream out;

    // input : 1 2 3 4 5 -> 1등 1개, 2등 2개, 3등 3개, 4등 4개, 5등 5개 식으로 받아서 매핑하기
    Map<Integer, Integer> getWinningCounts(String input){
        Map<Integer, Integer> winningCounts = new HashMap<>();
        String[] inputs = input.split(" ");

        for(int inputIndex = 1; inputIndex <= inputs.length; inputIndex++){
            int oneWinningCount = Integer.parseInt(inputs[inputIndex-1]);
            winningCounts.put(inputIndex,oneWinningCount);
        }

        return winningCounts;
    }


    @BeforeEach
    void beforeExecuteTest(){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Nested
    class PrintWinningRecordTest{

        @DisplayName("1등 1개 받았을 때, 당첨내역 출력")
        @Test
        void printWinningRecord_case1(){
            String input = "1 0 0 0 0";
            Map<Integer, Integer> winningCounts = getWinningCounts(input);
            outputHandler.printWinningRecord(winningCounts,lottoCounter);
            assertThat(out.toString().trim()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 1개"
            );
        }

        @DisplayName("2등 1개 받았을 때, 당첨내역 출력")
        @Test
        void printWinningRecord_case2(){
            String input = "0 1 0 0 0";
            Map<Integer, Integer> winningCounts = getWinningCounts(input);
            outputHandler.printWinningRecord(winningCounts,lottoCounter);
            assertThat(out.toString().trim()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 0개"
            );
        }

        @DisplayName("3등 1개 받았을 때, 당첨내역 출력")
        @Test
        void printWinningRecord_case3(){
            String input = "0 0 1 0 0";
            Map<Integer, Integer> winningCounts = getWinningCounts(input);
            outputHandler.printWinningRecord(winningCounts,lottoCounter);
            assertThat(out.toString().trim()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개"
            );
        }

        @DisplayName("4등 1개 받았을 때, 당첨내역 출력")
        @Test
        void printWinningRecord_case4(){
            String input = "0 0 0 1 0";
            Map<Integer, Integer> winningCounts = getWinningCounts(input);
            outputHandler.printWinningRecord(winningCounts,lottoCounter);
            assertThat(out.toString().trim()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개"
            );
        }

        @DisplayName("5등 1개 받았을 때, 당첨내역 출력")
        @Test
        void printWinningRecord_case5(){
            String input = "0 0 0 0 1";
            Map<Integer, Integer> winningCounts = getWinningCounts(input);
            outputHandler.printWinningRecord(winningCounts,lottoCounter);
            assertThat(out.toString().trim()).contains(
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개"
            );
        }

        @DisplayName("1등 1개,2등 2개, 3등 3개, 4등 4개, 5등 5개 받았을 때, 당첨내역 출력")
        @Test
        void printWinningRecord_case6(){
            String input = "1 2 3 4 5";
            Map<Integer, Integer> winningCounts = getWinningCounts(input);
            outputHandler.printWinningRecord(winningCounts,lottoCounter);
            assertThat(out.toString().trim()).contains(
                    "3개 일치 (5,000원) - 5개",
                    "4개 일치 (50,000원) - 4개",
                    "5개 일치 (1,500,000원) - 3개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
                    "6개 일치 (2,000,000,000원) - 1개"
            );
        }
    }

    @Nested
    class PrintProfitRateTest{

        @DisplayName("로또 산돈과 번 돈이 같을 때 수익률 출력테스트")
        @Test
        void printProfitRate_case1(){
            int totalEarnMoney = 5000;
            int buyingMoney = 5000;
            outputHandler.printProfitRate(totalEarnMoney,buyingMoney);
            assertThat(out.toString().trim()).isEqualTo(
                    "총 수익률은 100.0%입니다."
            );
        }

        @DisplayName("로또 번 돈이 산돈의 10배일 때 수익률 출력테스트")
        @Test
        void printProfitRate_case2(){
            int totalEarnMoney = 50000;
            int buyingMoney = 5000;
            outputHandler.printProfitRate(totalEarnMoney,buyingMoney);
            assertThat(out.toString().trim()).isEqualTo(
                    "총 수익률은 1,000.0%입니다."
            );
        }

        @DisplayName("수익률이 62.5%일 때, 수익률 출력테스트")
        @Test
        void printProfitRate_case3(){
            int totalEarnMoney = 5000;
            int buyingMoney = 8000;
            outputHandler.printProfitRate(totalEarnMoney,buyingMoney);
            assertThat(out.toString().trim()).isEqualTo(
                    "총 수익률은 62.5%입니다."
            );
        }

        @DisplayName("수익률이 대단히 높을 때, 수익률에 콤마 잘 찍혀 나오는지 테스트")
        @Test
        void printProfitRate_case4(){
            int totalEarnMoney = 2_000_000_000;
            int buyingMoney = 200_000;
            outputHandler.printProfitRate(totalEarnMoney,buyingMoney);
            assertThat(out.toString().trim()).isEqualTo(
                    "총 수익률은 1,000,000.0%입니다."
            );
        }

        @DisplayName("당첨금액이 없을때, 수익률 출력테스트")
        @Test
        void printProfitRate_case5(){
            int totalEarnMoney = 0;
            int buyingMoney = 200_000;
            outputHandler.printProfitRate(totalEarnMoney,buyingMoney);
            assertThat(out.toString().trim()).isEqualTo(
                    "총 수익률은 0.0%입니다."
            );
        }
    }
}