package lotto;

public class Print {
    public static void money() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void purchaseLotto(int lottoTickets, Lottos lottos) {
        newLine();
        System.out.println(lottoTickets + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void winningNumber() {
        newLine();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumber() {
        newLine();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private static void newLine() {
        System.out.println();
    }
}
