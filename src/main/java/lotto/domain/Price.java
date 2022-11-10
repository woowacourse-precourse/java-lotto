package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Price {
    int input;

    public int purchaseAmount() {
        input = Integer.parseInt(Console.readLine());
        return input;
    }
}
