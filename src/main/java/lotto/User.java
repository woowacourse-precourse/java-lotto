package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    public static Integer askTicketNumber() {
        Integer tickets;

        System.out.println(Constant.ASK_PRICE);
        String input = Console.readLine();

        tickets = validateAskedTicketNumber(input);
        return tickets;
    }

    public static Integer validateAskedTicketNumber(String input) {
        Integer price = 0;
        try {
            price = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    Constant.ERROR + " 로또 1장의 가격은 " + NumberFormat.getInstance().format(Constant.TICKET_PRICE)
                            + "원입니다. 구입금액을 " + Constant.TICKET_PRICE + "의 배수로 입력해주세요.");
        }
        if ((price % Constant.TICKET_PRICE != 0) || (price <= 0)) {
            throw new IllegalArgumentException(
                    Constant.ERROR + " 로또 1장의 가격은 " + NumberFormat.getInstance().format(Constant.TICKET_PRICE)
                            + "원입니다. 구입금액을 " + Constant.TICKET_PRICE + "의 배수로 입력해주세요.");
        }
        return price / Constant.TICKET_PRICE;
    }

    public static List<Lotto> buy(Integer tickets) {
        List<Lotto> lottos = new ArrayList<>();

        System.out.println(tickets + "개를 구매했습니다.");

        for (int i = 0; i < tickets; i++) {
            List<Integer> generated = Lotto.generate();
            Lotto lotto = new Lotto(generated);
            lottos.add(lotto);
        }
        return lottos;
    }

    public static List<Integer> askWinNumbers() {
        System.out.println(Constant.ASK_WIN_NUMBERS);
        String input = Console.readLine();
        List<String> commaSeparatedInput = Arrays.asList(input.split(",", -1));
        List<Integer> numbers = validateAskedWinNumbers(commaSeparatedInput);
        return numbers;
    }

    public static List<Integer> validateAskedWinNumbers(List<String> commaSeparatedInput) {
        List<Integer> numbers = new ArrayList<>();

        for (String element : commaSeparatedInput) {
            try {
                numbers.add(Integer.valueOf(element));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Constant.ERROR + " 당첨 번호를 쉼표로 구분된 숫자들로 입력해주세요.");
            }
        }
        return numbers;
    }

    public static Integer askBonusNumbers() {
        System.out.println(Constant.ASK_BONUS_NUMBER);
        String inputBonus = Console.readLine();
        if (!inputBonus.equals("input bonus validate")) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    public static List<Integer> winNumbers(String inputWinNumber) {

        return null;
    }

    public static void getEarning() {

    }
}
