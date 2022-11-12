package validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Check {

    public static int countLottoTicket(Long paperMoney) {
        int tickets = (int) (paperMoney / 1000);

        if (paperMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액이 아닙니다. (지폐만 가능)");
        }

        return tickets;
    }

    public static void numberDuplicate(List<String> numbers) {

        Set<String> checkDuplicate = new HashSet<>(numbers);

        if (checkDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 잘못된 입력값 입니다.");
        }
    }

    public static void numberDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 잘못된 입력값 입니다.");
        }
    }

    public static void winningNumberSize(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 숫자는 6개를 입력해야 합니다.");
        }
    }

    public static void isNumber(String number) {
        if (number.matches(".*[^0-9].*")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 콤마 이외의 문자는 입력할 수 없습니다.");
        }
    }
}
