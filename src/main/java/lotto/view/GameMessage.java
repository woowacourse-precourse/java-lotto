package lotto.view;

public class GameMessage {
    public static void printInputMoney() {
        System.out.println("구입금액을 입력해 주세요");
    }

    public static void printLottoCount(int change) {
        System.out.println(change + "개를 구매했습니다.");
    }

    public static void printInputLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusLottoNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
