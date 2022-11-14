package lotto.domain;

import static lotto.Config.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.Score;

public class UahanBank {
    public final List<Score> rankScores;

    public UahanBank(){
        rankScores = createRankScore();
    }

    private List<Score> createRankScore(){
        List<Score> scores = new ArrayList<>();
        scores.add(new Score(LOTTO_LENGTH, 0));

        int rankAmountLength = WINNING_RANK_AMOUNT.length;
        for(int index = 0, win = LOTTO_LENGTH - 1; index < rankAmountLength - BONUS_LOTTO_LENGTH - 1; index++, win--){
            scores.add(new Score(win, 0));
        }

        for(int bonus = BONUS_LOTTO_LENGTH; scores.size() < rankAmountLength && bonus > 0; bonus--){
            scores.add(BONUS_LOTTO_LENGTH - bonus + 1, new Score(LOTTO_LENGTH - 1, bonus));
        }

        return Collections.unmodifiableList(scores);
    }

    public int changeLottoToMoney(Lotto wonLotto, Lotto bonusLotto, Lotto lotto){
        return 0;
    }

    private Score calculateLottoToScore(Lotto wonLotto, Lotto bonusLotto, Lotto lotto){
        return null;
    }
}
