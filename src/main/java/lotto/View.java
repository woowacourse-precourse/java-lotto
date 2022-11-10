package lotto;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public int askPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        return Integer.parseInt(price);
    }
}
