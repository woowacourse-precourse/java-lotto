package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public int payForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int pay = Integer.valueOf(Console.readLine())/1000;
        return pay;
    }
}
