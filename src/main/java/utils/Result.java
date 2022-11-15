package utils;

import model.Game;
import model.Rank;

import java.util.Collections;
import java.util.List;

public class Result {

    Game game;

    public Result(Game game) {
        this.game = game;
    }

    public Rank getResultRank(int count, boolean isIncludeBonus) {
        if(count == 3) {
            return Rank.FIFTH;
        }
        if(count == 4) {
            return Rank.FOURTH;
        }
        if(count == 5) {
            if(isIncludeBonus) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        }
        if(count == 6) {
            return Rank.FIRST;
        }
        return Rank.NONE;
    }

    public Rank getResult(List<Integer> userLottoNumber, List<Integer> lotto, int bonusNum) {
        int count = 0;
        boolean isIncludeBonus = false;

        count += compareUserLottoAndLotto(userLottoNumber, lotto);
        if (compareUserLottoAndBonusNum(userLottoNumber, bonusNum)) {
            count++;
            isIncludeBonus = true;
        }

        Rank rank = getResultRank(count, isIncludeBonus);

        return rank;
    }

    public int compareUserLottoAndLotto(List<Integer> userLottoNumber, List<Integer> lotto) {
        int count = 0;

        for (Integer userLottoNum : userLottoNumber) {
            for (Integer lottoNum : lotto) {
                count += compareUserLottoNumAndLottoNum(userLottoNum, lottoNum);
            }
        }

        return count;
    }

    public int compareUserLottoNumAndLottoNum(int userLottoNum, int lottoNum) {
        if (userLottoNum == lottoNum) {
            return 1;
        }
        return 0;
    }

    public boolean compareUserLottoAndBonusNum(List<Integer> userLottoNumber, int bonusNum) {
        for (Integer userLottoNum : userLottoNumber) {
            if (userLottoNum == bonusNum) {
                return true;
            }
        }
        return false;
    }

}
