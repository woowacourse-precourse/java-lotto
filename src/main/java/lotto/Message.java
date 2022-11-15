package lotto;

public class Message {
    public static void requestPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void printPurchaseAmount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void requestLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
