package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    int lottoCount;

    public void inputCostForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        Validator.validateForIllegalInput(input);

        int cost = Integer.parseInt(input);
        Validator.validateForDividedBy1000(cost);

        lottoCount = cost / 1000;
    }
}
