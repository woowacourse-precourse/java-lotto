package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoSystem;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {
    private User user;

    public void setPayMent() {
        int payMent;

        try {
            payMent = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하셔야 됩니다.");
        }

        user = new User(payMent);
    }

}
