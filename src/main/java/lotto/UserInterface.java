package lotto;

import camp.nextstep.edu.missionutils.*;

public class UserInterface {
    int getPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
