package lotto;

public class View {
    public void lottoStartMsg() {
        String msg = "구입금액을 입력해 주세요.";
        System.out.println(msg);
    }

    public void purchaseMsg(int moneyInput) {
        int numberOfLotto = moneyInput / 1000;
        System.out.printf("\n%d개를 구매했습니다.\n", numberOfLotto);
    }

    public void registerWinningNumberMsg() {
        String msg = "당첨 번호를 입력해 주세요.";
        System.out.println(msg);
    }

    public void registerLuckyNumberMsg() {
        String msg = "보너스 번호를 입력해 주세요.";
        System.out.println(msg);
    }
}
