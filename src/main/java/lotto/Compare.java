package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compare {
    private List<Integer> winningLotto;
    private int bonusNumber;

    private final Map<Integer,Rank> RANK_BOARD = new HashMap<>();

    public Compare() {
        this.initRankBoard();
    }

    private void initRankBoard() {
        RANK_BOARD.put(6,Rank.RANK_1);
        RANK_BOARD.put(5,Rank.RANK_3);
        RANK_BOARD.put(4,Rank.RANK_4);
        RANK_BOARD.put(3,Rank.RANK_5);
        RANK_BOARD.put(0,Rank.RANK_NONE);
    }

    public Rank compareLotto(Lotto lotto) {
        int count = 0;
        for (int number : winningLotto) {
            if (lotto.isContainNumber(number)) {
                count += 1;
            }
        }
        Rank rank = RANK_BOARD.get(count);

        if (rank == null) {
            return Rank.RANK_NONE;
        }

        if (rank == Rank.RANK_3) {
            if (lotto.isContainBonusNumber(bonusNumber)) {
                return Rank.RANK_2;
            }
        }
        return rank;
    }

    public void setWinningLotto(List<Integer> winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void inputTargetNumbers() {
        this.winningLotto = UserInput.inputTargetNumbers();
    }

    public void inputBonusNumber() {
        this.bonusNumber = UserInput.inputBonusNumber();
    }
    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;

    }
}