package lotto;

import java.util.*;

public class Lottery {
    private static final String REQUEST_DESIRED_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public void start() {
        printRequestDesiredAmountMessage();
        Buyer buyer = new Buyer();
        buyer.payMoney();
        List<Lotto> lotteryTickets = buyer.getLotteryTickets();
        printLottoInfos(lotteryTickets);

        printRequestWinningNumberMessage();
        WinningNumber winningNumber = Generator.getWinningNumber();
    }

    private void printRequestWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void printLottoInfos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    private void printRequestDesiredAmountMessage() {
        System.out.println(REQUEST_DESIRED_AMOUNT_MESSAGE);
    }
}
