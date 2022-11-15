package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//구매한 로또의 구입 가격과 발행된 로또 번호들을 가진 클래스
public class PurchasedLotto {
    private Integer cost; //구입 가격

    private List<Lotto> purchasedLottoNumbers; //발행된 로또 번호들

    public Integer getCost() {
        return cost;
    }

    public List<Lotto> getPurchasedLottoNumbers() {
        return purchasedLottoNumbers;
    }

    //구입 금액을 입력받으면 생성자에서 금액을 검증하고 구입 금액 만큼 로또를 발행한다.
    public PurchasedLotto(Integer purchaseCost) {
        validate(purchaseCost);
        this.cost = purchaseCost;

        purchasedLottoNumbers = publishLottos(this.cost);
    }

    //구입 금액 검증
    public void validate(Integer value) {
        if (value % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액이 천원 단위여야 합니다.");
        if (value <= 0) throw new IllegalArgumentException("[ERROR] 구입 금액이 천원 이상이어야 합니다.");
    }

    //로또 발행
    public List<Lotto> publishLottos(Integer cost) {
        List<Lotto> lottos = new LinkedList<>();
        for (int i = 0; i < cost / 1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    //수익률 계산
    public Double calculateReturn(List<Integer> winNumbers, Integer bonusNumber) {
        Double winnings = 0.0;
        for (Lotto lotto : purchasedLottoNumbers) {
            winnings += Double.valueOf(lotto.checkWin(winNumbers, bonusNumber).getValue());
        }

        Double returnRate = winnings / this.cost * 100.0;
        returnRate = Math.round(returnRate * 10.0) / 10.0;
        return returnRate;
    }
}
