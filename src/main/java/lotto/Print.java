package lotto;

public class Print {
    public static void money() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void purchaseLotto(int lottoTickets) {
        newLine();
        System.out.println(lottoTickets + "개를 구매했습니다.");
    }

    private static void newLine() {
        System.out.println();
    }
}
