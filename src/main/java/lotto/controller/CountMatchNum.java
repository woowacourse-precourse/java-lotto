package lotto.controller;

import lotto.model.Lotto;
import lotto.model.UserLottoNum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountMatchNum {

    public final static int SCORE_BOARD = 5;
    public Map<Integer, Integer> scoreBoard = new HashMap<>();

    public void initScoreBoard() {
        for (int key = SCORE_BOARD+2; key > 2; key--) {
            scoreBoard.put(key, 0);
        }
        System.out.println("SCORE_BOARD = " + scoreBoard);
    }

    public void DoMatchNumber(UserLottoNum userLottoNum, Lotto targetLottoNum) {
        int count;
        for (Lotto userLottoNumber : userLottoNum.getUserLottoNumbers()) {
            count = countMatchNumber(userLottoNumber, targetLottoNum);
        }
    }

    public int countMatchNumber(Lotto userLottoNumber, Lotto targetLottoNum) {
        int count = 0;
        List<Integer> targetNumber = targetLottoNum.getLotto();

        for (Integer lotto : userLottoNumber.getLotto()) {
            if (targetNumber.contains(lotto)) {
                count++;
            }
        }
        return count;
    }
}
