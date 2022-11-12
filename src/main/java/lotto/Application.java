package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Print print = new Print();

        System.out.println("구입금액을 입력해 주세요.");

        print.userLotto(user.inputMoney());


    }
}
