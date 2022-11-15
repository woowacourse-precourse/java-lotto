package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoManager {
    private boolean isContainsBonus = false;
    private List<List<Integer>> randomLottoNumber;

    public void calculateLottoRank(WinningLotto winningLotto, LottoResultBoard lottoResultBoard, List<List<Integer>> randomLottoNumber) {
        int count = 0;

        for (int i = 0; i < randomLottoNumber.size(); i++) {
            for (int j = 0; j < randomLottoNumber.get(i).size(); j++) {
                count += Collections.frequency(winningLotto.getWinningNumbers(), randomLottoNumber.get(i).get(j));
            }
            isContainsBonus(LottoBonus.getBonusNumber(), randomLottoNumber.get(i));
            lottoResultBoard.setLottoResultBoard(LottoRank.getLottoReward(count, isContainsBonus));
            count = 0;
        }
    }

    public static double calculateProfitRate(int resultMoney, int profitMoney) {
        double profitRate = (double) profitMoney / resultMoney * 100;
        return Math.round(profitRate * 100) / 100.0;
    }

    public boolean isContainsBonus(int bonus, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            return isContainsBonus = true;
        }
        return isContainsBonus = false;
    }

    public void makeRandomLottoNumber(int count) {
        randomLottoNumber = new ArrayList<>();

        for (int i = 0; i < count; ++i) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstant.MIN_LOTTO_NUMBER.getNumber(), LottoConstant.MAX_LOTTO_NUMBER.getNumber(), LottoConstant.LOTTO_NUMBER_COUNT.getNumber());
            Lotto lotto = new Lotto(numbers);
            randomLottoNumber.add(numbers);
        }
    }

    public List<List<Integer>> getRandomLottoNumber(){
        return randomLottoNumber;
    }
}
