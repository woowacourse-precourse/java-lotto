package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.User;

import java.util.List;

public class LottoService {

    private User user = new User();
    private LottoMachine lottoMachine;

    public void buyLotto(int money) {
        user = User.initUserLotto(money);
    }

    public void saveWinningLotto(String bonusNumber) {
        lottoMachine = LottoMachine.initLottoMachineNumber(bonusNumber).get();
    }

    public List<Lotto> getUserLotties() {
        return user.getLotties();
    }

    public void saveBonusNumber(String bonusNumber) {
        lottoMachine.addBonusNumber(Integer.parseInt(bonusNumber));
    }

    public int matchLottoCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBonusNumber(int bonusNumber, int lottoCount, List<Integer> lottoNumbers) {
        if (lottoCount == 5) {
            return lottoNumbers.contains(bonusNumber);
        }

        return false;
    }
}
