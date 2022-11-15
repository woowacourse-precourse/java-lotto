package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Printer.LottoMatchMoney;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> amountEachWin = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        String UNIT = "개";

        int i = 0;
        for (LottoMatchMoney matchNumber : LottoMatchMoney.values()) {
            int index = matchNumber.ordinal();
            String message = matchNumber.getNumberMessage();

            System.out.println(message+ amountEachWin.get(i) + UNIT);
            i++;
        }

    }
}
