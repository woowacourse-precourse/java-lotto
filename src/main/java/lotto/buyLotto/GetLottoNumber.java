package lotto.buyLotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.buyLotto.Lotto;

public class GetLottoNumber {
    public void createLottoNumbers(List<Lotto> lottoNumbers) {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(randomNumbers);
        lottoNumbers.add(lotto);
        lotto.printLottoNumbers();
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers, int money) {

        for(int loop = 0; loop < money; loop++) {
            createLottoNumbers(lottoNumbers);
        }
    }
}
