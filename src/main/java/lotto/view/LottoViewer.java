package lotto.view;

public class LottoViewer {
    public static void showEnterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void showLottoPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void showEnterLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void showEnterLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void showYield(double yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
