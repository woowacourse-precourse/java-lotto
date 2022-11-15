package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Reward;
import lotto.domain.User;

import java.util.List;
import java.util.Map;

public class LottoService {

    private final static int PROFIT_CALCULATE_NUMBER = 10000;
    private final static double ROUND_NUMBER = 100.00;

    private User user = new User();
    private LottoMachine lottoMachine;

    public void buyLotto(String inputMoney) {
        user = User.initUserLotto(inputMoney);
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

    public void initResultLotto() {
        user.initLottiesResult();
    }

    public void saveResultLotto() {
        final int bonusNumber = lottoMachine.getBonusNumber();
        final List<Integer> winngingNumbers = lottoMachine.getNumbers();

        for (Lotto lotto : user.getLotties()) {
            final List<Integer> lottoNumbers = lotto.getNumbers();
            int winningCount = matchLottoCount(lottoNumbers, winngingNumbers);

            if (winningCount < 3) {
                continue;
            }

            if (winningCount == 5 && checkBonusNumber(bonusNumber, lottoNumbers)) {
                user.saveResult(RewardFactory.createBonusReward());
            } else {
                user.saveResult(RewardFactory.createRewardByLottoCount(winningCount));
            }
        }
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

    public boolean checkBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public Map<Reward, Integer> getLottiesResult() {
        return user.getLottiesResult();
    }

    public void calculateReward() {
        user.saveTotalReward();
    }

    public double getProfitRate() {
        int totalReward = user.getRewardMoney();
        int totalMoney = user.getMoney();
        return Math.round((double) totalReward / totalMoney * PROFIT_CALCULATE_NUMBER)
                / ROUND_NUMBER;
    }

    //테스트를 위한 메서드
    public User getUserForTest() {
        return user;
    }
}
