package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.utils.Messages.*;

public class View {
    public String startLottoView(){
        System.out.println(LOTTO_BUY_MESSAGE);
        String amount = Console.readLine();
        return amount;
    }
}
