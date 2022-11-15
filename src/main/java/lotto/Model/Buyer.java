package lotto.Model;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.View.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buyer {
    private static final int AMOUNT_PER_LOTTO = 1000;
    private int purchasedAmount;
    private List<Lotto> lottos = new ArrayList<>();

    /**
     * 입력한 금액을 바탕으로 구매한 로또의 개수를 설정(로또 1장 당 1000원)
     */
    public void buyLotto(int budget){
        validateBudget(budget);
        purchasedAmount = budget / AMOUNT_PER_LOTTO;
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

    /**
     * 1~45 사이의 랜덤한 로또 번호 6자리를 선택
     */
    public void pickLottoNumbers(){
        while (lottos.size() < purchasedAmount){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            if (validateLottoNumber(numbers, lottos)){
                lottos.add(new Lotto(numbers));
            }
        }
    }

    /**
     * 로또 번호가 겹치지 않도록 검증
     * @param numbers 로또 번호로 사용할 랜덤으로 선택한 숫자들
     * @param lottos 로또 번호가 선택된 로또들
     * @return 중복된 값인지 여부
     */
    public static boolean validateLottoNumber(List<Integer> numbers, List<Lotto> lottos){
        for(Lotto lotto : lottos){
            if (lotto.getLottoNumbers().equals(numbers)){
                return false;
            }
        }
        return true;
    }

    public int getPurchasedAmount() { return purchasedAmount; }
    public List<Lotto> getLottos() { return lottos; }
}
