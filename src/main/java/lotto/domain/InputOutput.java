package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.commons.LottoResult;

public class InputOutput {

    public int getLottoBuyAmount() {
        String input = Console.readLine();
        //ErrorHandler#getLottoBuyAmountError()
        int money = Integer.parseInt(input);
        return money / 1000;
    }

    public List<Integer> getLottoNumbers() {
        String input = Console.readLine();
        //ErrorHandler#getLottoWinnerNumberError()
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }

    public int getLottoBonusNumbers() {
        String input = Console.readLine();
        //ErrorHandler#getLottoBonusNumberError()
        int number = Integer.parseInt(input);
        return number;
    }

    public void printWinHistory(Map<String, Integer> winHistory) {
        System.out.println(LottoResult.FIFTH_WIN + " - " + winHistory.get("FIFTH_WIN") + "개");
        System.out.println(LottoResult.FIRTH_WIN + " - " + winHistory.get("FIRTH_WIN") + "개");
        System.out.println(LottoResult.THIRD_WIN + " - " + winHistory.get("THIRD_WIN") + "개");
        System.out.println(LottoResult.SECOND_WIN + " - " + winHistory.get("SECOND_WIN") + "개");
        System.out.println(LottoResult.FIRST_WIN + " - " + winHistory.get("FIRST_WIN") + "개");
    }

    public void printRateOfProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

}
