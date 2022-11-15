package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoConst.*;

public class LottoIssuer {
    public LottoIssuer() {

    }

    /**
     * 사용자가 입력한 구매 금액만큼의 로또를 담은 Lottos를 return
     */
    public Lottos purchaseLottos(int purchasePrice) {
        int numberOfLottos = getNumberOfLottos(purchasePrice);
        return new Lottos(createLottos(numberOfLottos));
    }

    public PrizeLotto createPrizeLotto(List<Integer> numbers, int bonusNumber) {
        return new PrizeLotto(numbers, bonusNumber);
    }

    private int getNumberOfLottos(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }

    private List<Lotto> createLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < numberOfLotto) {
            lottos.add(new Lotto(pickLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> pickLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
