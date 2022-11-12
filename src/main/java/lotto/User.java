package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    String money_str;

    User() {
        System.out.println("구입금액을 입력해 주세요.");
        money_str = Console.readLine();
    }


}
