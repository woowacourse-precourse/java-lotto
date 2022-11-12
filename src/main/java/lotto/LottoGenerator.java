package lotto;

import static lotto.FinalString.REQUIRE_INPUT_MONEY;

import camp.nextstep.edu.missionutils.Console;

// 랜덤한 로또 생성
public class LottoGenerator {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_NUM_LENGTH = 6;

    private int inputMoney() {
        System.out.println(REQUIRE_INPUT_MONEY);
        int inputMoney = Integer.parseInt(Console.readLine());

        return inputMoney;
    }

    public int getInputMoney(){
        return inputMoney();
    }
}
