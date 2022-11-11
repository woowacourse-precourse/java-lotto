package lotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<List<Integer>> randomNumbers = new ArrayList<>();
    private static Rank rank = Rank.LOSE;
    private static int rankOne = 0;
    private static int rankTwo = 0;
    private static int rankThree = 0;
    private static int rankFour = 0;
    private static int rankFive = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 로또 구입 금액 입력
        Input.inputCoin();
        // 구매 개수만큼 로또용지 출력
        for (int i = 0; i < Input.buyCount; i++) {
            randomNumbers.add(NumberGenerator.createRandomNumber());
        }
        // 당첨 번호를 입력
        Input.inputWinningNumber();
        // 보너스 번호 입력
        Input.inputBonusNumber();

        System.out.println("당첨 통계");
        System.out.println("---");

        // 일치하는 숫자 확인 기능 실행
        for (int i = 0; i < Input.buyCount; i++) {
            rank = NumberCompare.compare(Input.lottoNumber, randomNumbers.get(i), Input.lottoBonusNumber);
            if (rank == Rank.LOSE) continue;
            if (rank == Rank.ONE) rankOne += 1;
            if (rank == Rank.TWO) rankTwo += 1;
            if (rank == Rank.THREE) rankThree += 1;
            if (rank == Rank.FOUR) rankFour += 1;
            if (rank == Rank.FIVE) rankFive += 1;
        }
        // 등수당 일치 개수 출력
        Output.outputLottoRank(rankOne, rankTwo, rankThree, rankFour, rankFive);
        // 로또 총 수익 계산 기능 실행
        Calculator.revenue(rankOne, rankTwo, rankThree, rankFour, rankFive);
        // 수익률 계산 기능 실행
        Calculator.yield(Calculator.revenue, Input.coin);
    }
}
