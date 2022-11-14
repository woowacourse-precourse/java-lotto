package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class User {
    static final int LOTTO_PRICE = 1000;
    public int purchasingAmount = 0;
    private int lottoTicketCount = 0;
    public List<Lotto> lottoTickets = new ArrayList<>();

    public User() {
    }

    public void getLottoTickets() {
        inputAmount();
        countTicket();
        buyTickets(this.lottoTicketCount);
        printTicketCount();
        printLottoTickets();
    }

    private void inputAmount() {
        int userInputAmount;

        System.out.println("구입금액을 입력해 주세요.");
        userInputAmount = Integer.parseInt(Console.readLine());
        validate(userInputAmount);
        this.purchasingAmount = userInputAmount;
    }

    private void validate(int purchasingAmount) throws IllegalArgumentException{
        if (purchasingAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000으로 나누어 떨어지지 않습니다");
        }
    }

    private void countTicket() {
    }

    private void buyTickets(int lottoTicketCount) {
    }

    private void printTicketCount() {
    }

    private void printLottoTickets() {
    }
}
