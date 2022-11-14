package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    static final int LOTTO_PRICE = 1000;
    int purchasingAmount = 0;
    int lottoTicketCount = 0;

    void inputAmount() {
        int userInputAmount;

        System.out.println("구입금액을 입력해 주세요.");
        userInputAmount = Integer.parseInt(Console.readLine());
        validate(userInputAmount);
        this.purchasingAmount = userInputAmount;
    }

    void validate(int purchasingAmount) throws IllegalArgumentException{
        if (purchasingAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000으로 나누어 떨어지지 않습니다");
        }
    }

    void countTicket() {

    }

    void printTicketCount() {

    }
}
