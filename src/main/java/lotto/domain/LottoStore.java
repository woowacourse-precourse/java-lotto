package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.IOProcessor;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    static final int PRICE = 1000; // 로또의 가격

    private final List<Lotto> lottoBoard; // 발행한 로또정보

    public LottoStore() {
        this.lottoBoard = new ArrayList<>();
    }

    public void purchaseLotto(int amount) {
        lottoBoard.clear(); // 구매하기 이전 로또정보를 초기화 함
        int count = amount / PRICE; // 구매할 수 있는 로또의 수를 구함
        for (int i = 0; i < count; i++) {
            lottoBoard.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public List<Lotto> getPurchasedLotto() {
        return this.lottoBoard;
    }

    public int getPrice() {
        return this.PRICE;
    }
}