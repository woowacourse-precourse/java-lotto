package validate;

import java.util.List;

public class Check {

    public static int countLottoTicket(int money) {
        int tickets = money / 1000;

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액이 아닙니다. (지폐만 가능)");
        }

        return tickets;
    }

    public static void winningNumberDuplicate(List<String> numbers, String number) {

        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 잘못된 입력값 입니다.");
        }
    }
}
