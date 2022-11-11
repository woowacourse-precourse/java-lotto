package lotto;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public View(){

    }

    /**
     * input money by user
     * @return user input value
     */
    public String inputMoney() {
        System.out.println("구입 금액을 입력해 주세요");
        return Console.readLine();
    }
}
