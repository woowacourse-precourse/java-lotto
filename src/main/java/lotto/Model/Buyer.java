package lotto.Model;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.View.Input;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private final int AMOUNT_PER_LOTTO = 1000;
    private int purchased;
    private List<Lotto> lottos = new ArrayList<>();

    /**
     * 입력한 금액을 바탕으로 구매한 로또의 개수를 설정(로또 1장 당 1000원)
     */
    public Buyer(int budget){
        validateBudget(budget);
        purchased = budget / AMOUNT_PER_LOTTO;
    }

    /**
     * 구입 금액을 AMOUNT_PER_LOTTO 로 나눴을 때 나누어 떨어지는 않을 시 예외 처리
     * @param amount 구매한 로또의 개수
     */
    private void validateBudget(int amount){
        if (amount % 1000 != 0 || amount <= 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

}
