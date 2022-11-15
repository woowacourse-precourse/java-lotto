package lotto;

import java.text.NumberFormat;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void ticketNumber(String input) {
        Integer budget;

        try {
            budget = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    Constant.ERROR + " 로또 1장의 가격은 " + NumberFormat.getInstance().format(Constant.TICKET_PRICE)
                            + "원입니다. 구입금액을 " + Constant.TICKET_PRICE + "의 배수로 입력해주세요.");
        }
        if ((budget % Constant.TICKET_PRICE != 0) || (budget <= 0)) {
            throw new IllegalArgumentException(
                    Constant.ERROR + " 로또 1장의 가격은 " + NumberFormat.getInstance().format(Constant.TICKET_PRICE)
                            + "원입니다. 구입금액을 " + Constant.TICKET_PRICE + "의 배수로 입력해주세요.");
        }
    }

    public static void lottoNumber(List<Integer> numbers) {
        Set<Integer> distinct = Set.copyOf(numbers);

        if (numbers.size() != Constant.SIZE) {
            throw new IllegalArgumentException(Constant.ERROR + " 서로 다른 " + Constant.SIZE + "가지 번호를 입력해 주세요");
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(
                        Constant.ERROR + " " + Constant.MIN_NUMBER + "과 "
                                + Constant.MAX_NUMBER + " 사이의 번호를 입력해 주세요.");
            }
        }
        if (distinct.size() != Constant.SIZE) {
            throw new IllegalArgumentException(Constant.ERROR + " 서로 다른 " + Constant.SIZE + "가지 번호를 입력해 주세요");
        }
    }

    public static void winNumbers(List<String> commaSeparatedInput) {
        for (String element : commaSeparatedInput) {
            try {
                Integer.valueOf(element);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Constant.ERROR + " 당첨 번호를 쉼표로 구분된 숫자들로 입력해주세요.");
            }
        }
    }

    public static void bonusNumber(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(
                    Constant.ERROR + " " + Constant.MIN_NUMBER + "과 "
                            + Constant.MAX_NUMBER + " 사이의 번호를 입력해 주세요.");
        }
        if (Lotto.isContainedWinNumber(bonusNumber)) {
            throw new IllegalArgumentException(Constant.ERROR + " 보너스 번호는 당첨 번호와 중복되지 않아야합니다.");
        }
    }
}
