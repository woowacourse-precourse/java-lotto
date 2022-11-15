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
        String userInput;

        System.out.println("구입금액을 입력해 주세요.");
        userInput = Console.readLine();
        validateAmount(userInput);
        this.purchasingAmount = Integer.parseInt(userInput);
    }

    void validateAmount(String userInput) throws IllegalArgumentException {
        if (!isNum(userInput)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요");
        } else if (Integer.parseInt(userInput) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000으로 나누어 떨어지지 않습니다");
        }
    }

    static Boolean isNum(String userInput) {
        boolean isNumeric = true;

        for (int letterIdx = 0; letterIdx < userInput.length(); letterIdx++) {
            if (!Character.isDigit(userInput.charAt(letterIdx))) {
                isNumeric = false;
            }
        }
        return isNumeric;
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
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
