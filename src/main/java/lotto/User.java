package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    public static Integer askTicketNumber() {
        System.out.println(Constant.ASK_BUDGET);
        String input = Console.readLine();

        Validator.ticketNumber(input);
        Integer budget = Integer.valueOf(input);

        return budget / Constant.TICKET_PRICE;
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
        List<Integer> winNumbers = new ArrayList<>();

        System.out.println(Constant.ASK_WIN_NUMBERS);
        String input = Console.readLine();
        List<String> commaSeparatedInput = Arrays.asList(input.split(",", -1));

        Validator.winNumbers(commaSeparatedInput);

        for (String separated : commaSeparatedInput) {
            winNumbers.add(Integer.valueOf(separated));
        }

        Validator.lottoNumber(winNumbers);

        return winNumbers;
    }

    public static Integer askBonusNumber() {
        System.out.println(Constant.ASK_BONUS_NUMBER);
        String inputBonus = Console.readLine();
        if (!inputBonus.equals("input bonus validate")) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    public static void getEarning() {

    }
}
