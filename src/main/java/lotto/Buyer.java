package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.io.*;
import java.util.*;

public class Buyer {
    private static final String REQUEST_DESIRED_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private int money;
    private List<Lotto> lottoTickets;

    public void buyLotteyTickets() {
        printRequestDesiredAmountMessage();
        money = Integer.parseInt(Console.readLine());
        validate(money);
        setLottoTickets();
        printLottoInfos(lottoTickets);
    }

    private void printRequestDesiredAmountMessage() {
        System.out.println(REQUEST_DESIRED_AMOUNT_MESSAGE);
    }

    private void validate(int money) {
        if (money % 1_000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.DESIRED_AMOUNT_ERROR.getMessage());
        }
    }

    private void setLottoTickets() {
        int ticketCount = money / 1000;
        lottoTickets = Generator.createLottoTickets(ticketCount);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    private void printLottoInfos(List<Lotto> lottos) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            bw.write(lottos.size() + "개를 구매했습니다.\n");
            for (Lotto lotto : lottos) {
                bw.write(lotto.toString() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
