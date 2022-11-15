package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Calculator;
import lotto.model.Comparison;

public class Output {
    public static void printPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printLottoBundle(List<Lotto> lottos, int purchaseAmount) {
        System.out.println();
        System.out.println(purchaseAmount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요");
    }

    public static void printResult(double rate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + Calculator.convertNull(Comparison.compareLotto.get(3)) + "개");
        System.out.println("4개 일치 (50,000원) - " + Calculator.convertNull(Comparison.compareLotto.get(4)) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Calculator.convertNull(Comparison.compareLotto.get(5)) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + Calculator.convertNull(Comparison.compareLotto.get(6)) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Calculator.convertNull(Comparison.compareLotto.get(7)) + "개");
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    public enum ErrorMessage {
        ERROR_NUMBER("숫자만 입력해 주세요."),
        ERROR_DIVIDE("1000원 단위로 입력해 주세요."),
        ERROR_LENGTH("6자리 숫자와 쉼표로 입력해 주세요."),
        ERROR_OVERLAP("중복되지 않는 숫자를 입력하세요."),
        ERROR_RANGE("1~45 숫자를 입력하세요."),
        ERROR_BONUS_NUMBER_OVERLAP("당첨번호와 중복되지 않는 숫자를 입력하세요.");

        protected final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String printMessage() {
            return "[ERROR] " + message;
        }
    }
}
