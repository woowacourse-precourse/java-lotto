package lotto;

import java.util.List;

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

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void winningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumber() {
        printEmptyLine();
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
