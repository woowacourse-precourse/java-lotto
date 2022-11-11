package view;

import camp.nextstep.edu.missionutils.Console;

import static model.NoticeMessage.PURCHASING_AMOUNT;

public class InputView {
    public String inputMoney() {
        System.out.println(PURCHASING_AMOUNT.toString());
        return Console.readLine();
    }

}
