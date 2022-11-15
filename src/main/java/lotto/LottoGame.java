package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public int purchaseAmount;
    public List<Integer> winningNumber;
    public int bonusNumber;
    public List<Lotto> issuedLotto;

    public void play() {
        Input input = new Input();
        this.purchaseAmount = input.getPurchaseAmount();
        issueLotto();
        // TODO: 발행된 로또 출력
        this.winningNumber = input.getWinningNumber();
        this.bonusNumber = input.getBonusNumber();
        // TODO: 당첨 통계 계산과 출력
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public List<Lotto> issueLotto() {
        this.issuedLotto = new ArrayList<Lotto>(purchaseAmount);
        for (int i=0; i<purchaseAmount; i++) {
            List<Integer> newLottoNumbers = generateLottoNumbers();
            Lotto newLotto = new Lotto(newLottoNumbers);
            issuedLotto.add(newLotto);
        }
        return issuedLotto;
    }
}