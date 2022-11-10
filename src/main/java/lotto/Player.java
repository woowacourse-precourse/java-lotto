package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.Constants.*;

public class Player {

    int lottoCount;

    public void inputCostForLotto() {
        System.out.println(PURCHASE_MESSAGE);
        String input = Console.readLine();
        Validator.validateForIllegalInput(input);

        int cost = Integer.parseInt(input);
        Validator.validateForDividedBy1000(cost);

        lottoCount = cost / LOTTO_PRICE;
    }
}
