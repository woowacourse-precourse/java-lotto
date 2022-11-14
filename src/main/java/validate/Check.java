package validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Check {

    private static final String ERROR_MESSAGE = "[ERROR]";

    public static int countLottoTicket(Long paperMoney) {
        int tickets = (int) (paperMoney / 1000);

        if (paperMoney % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 올바른 금액이 아닙니다. (지폐만 가능)");
        }

        return tickets;
    }

    public static void numberDuplicate(List<String> numbers) {

        Set<String> checkDuplicate = new HashSet<>(numbers);

        if (checkDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 중복된 숫자는 잘못된 입력값 입니다.");
        }
    }

    public static void numberDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 중복된 숫자는 잘못된 입력값 입니다.");
        }
    }

    public static void winningNumberCount(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 당첨번호 숫자는 6개를 입력해야 합니다.");
        }
    }

    public static void bonusNumberCount(List<String> numbers) {
        if (numbers.size() != 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스번호 숫자는 1개를 입력해야 합니다.");
        }
    }

    public static void isNumber(String numbers) {
        if (!numbers.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자만 입력해주세요.");
        }
    }

    public static void isNumber(List<String> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (!numbers.get(i).chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자만 입력해주세요.");
            }

        }
    }

    public static void rightRange(List<String> numbers, int startNumber, int finishNumber) {
        for (int i = 0; i < numbers.size(); i++) {
            if (Integer.parseInt(numbers.get(i)) < startNumber || Integer.parseInt(numbers.get(i)) > finishNumber) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " 범위를 벗어난 숫자입니다.");
            }
        }
    }
}
