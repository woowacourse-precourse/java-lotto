package lotto.domain;

import java.util.List;
import lotto.Lotto;
import lotto.Score;

public class UahanBank {
    private final List<Score> rankScores;

    public UahanBank(){
        rankScores = createRankScore();
    }

    private List<Score> createRankScore(){
        return null;
    }

    public int changeLottoToMoney(Lotto lotto){
        return 0;
    }

    private Score calculateLottoToScore(Lotto lotto){
        return null;
    }
}
