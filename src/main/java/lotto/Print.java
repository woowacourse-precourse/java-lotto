package lotto;

public class Print {
    public static void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void outputNumberOfLotto(int numberOfLottos) {
        printEmptyLine();
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
