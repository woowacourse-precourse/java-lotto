package lotto;

public class Print {

    public static void printBuyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(int count) {
        System.out.println(String.format("%d개를 구입했습니다.", count));
    }

    public static void printWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
