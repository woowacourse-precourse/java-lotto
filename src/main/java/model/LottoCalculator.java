package model;

import java.util.Collections;
import java.util.List;

public class LottoCalculator {
    private boolean isContainsBonus = false;

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
}
