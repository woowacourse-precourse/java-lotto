package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exceptions;

public class User {
    public int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        boolean chkPrice = price.matches("-?\\d+");
        if (!chkPrice) {
            new Exceptions();
        }
        return Integer.parseInt(price);
    }
}
