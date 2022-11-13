package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    public Integer askTickets() {
        System.out.println(Constant.ASK_PRICE);
        String input = Console.readLine();
        // validate
        // divide 1000
        return null;
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
