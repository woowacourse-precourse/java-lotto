package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class User {
    static final int LOTTO_PRICE = 1000;
    public int purchasingAmount = 0;
    int lottoTicketCount = 0;
    public List<Lotto> lottoTickets = new ArrayList<>();

    public User() {
    }

    public User(int purchasingAmount) {
        this.purchasingAmount = purchasingAmount;
    }

    public void getLottoTickets() {
        inputAmount();
        countTickets();
        buyTickets();
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

    void validate(int purchasingAmount) throws IllegalArgumentException {
        if (purchasingAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000으로 나누어 떨어지지 않습니다");
        }
    }

    void countTickets() {
        this.lottoTicketCount = this.purchasingAmount / LOTTO_PRICE;
    }

    void buyTickets() {
        for (int index = 0; index < this.lottoTicketCount; index++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            lottoTickets.add(lotto);
        }
    }

    List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    private void printTicketCount() {
        System.out.println("\n" + this.lottoTicketCount + "개를 구매했습니다.");
    }

    private void printLottoTickets() {
        for (Lotto lotto : lottoTickets) {
            lotto.printNumbers();
        }
    }
}
