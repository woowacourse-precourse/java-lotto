package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;
import java.util.List;

public class User {
    public Integer askTickets() {
        Integer tickets;

        System.out.println(Constant.ASK_PRICE);
        String input = Console.readLine();

        tickets = validate(input);
        return tickets;
    }

    public Integer validate(String input) {
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

    public List<Integer> askWinNumbers() {
        System.out.println(Constant.ASK_WIN_NUMBERS);
        String inputWin = Console.readLine();
        List<Integer> numbers = winNumbers(inputWin);

        return null;
    }

    public Integer askBonusNumbers() {
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

    public void getEarning() {

    }
}
