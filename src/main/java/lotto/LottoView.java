package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {

    public void printPurchaseAmountQuestion(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public String getUserInput(){
        return Console.readLine();
    }
}
