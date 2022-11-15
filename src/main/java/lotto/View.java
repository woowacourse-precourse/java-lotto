package lotto;

import java.util.List;

public class View {
    public void lottoStartMsg() {
        String msg = "구입금액을 입력해 주세요.";
        System.out.println(msg);
    }

    public void purchaseMsg(String moneyInput) {
        int money = Integer.parseInt(moneyInput);
        int numberOfLotto = money / 1000;
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

    public void resultInitMsg() {
        String msg = "\n당첨 통계\n" +
                "---";
        System.out.println(msg);
    }

    public void winnerListMsg(List<Integer> winnerList) {
        System.out.printf("3개 일치 (5,000원) - %d개\n" +
                        "4개 일치 (50,000원) - %d개\n" +
                        "5개 일치 (1,500,000원) - %d개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                        "6개 일치 (2,000,000,000원) - %d개",
                winnerList.get(0), winnerList.get(1), winnerList.get(2),
                winnerList.get(3), winnerList.get(4));
    }

    public void profitMsg(double profit) {
        System.out.printf("\n총 수익률은 %.1f%%입니다.", profit);
    }
}
