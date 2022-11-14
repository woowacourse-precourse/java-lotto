package lotto;

import java.util.HashMap;

public class Message {
    public static void startMessage() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public static void inputNumberMessage() {
        System.out.println("\n당첨번호를 입력해주세요.");
    }

    public static void inputBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printLottoCountMessage(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public static void printResultMessage(HashMap<Score, Integer> scoreBoard) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + scoreBoard.get(Score.third) + "개");
        System.out.println("4개 일치 (50,000원) - " + scoreBoard.get(Score.fourth) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + scoreBoard.get(Score.fifth) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + scoreBoard.get(Score.fifthBonus) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + scoreBoard.get(Score.six) + "개");
    }

    public static void printWinningRatioMessage(double result) {
        System.out.println("총 수익률은 " + String.format("%.1f", result) + "%입니다.");
    }

}