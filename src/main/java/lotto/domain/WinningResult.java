package lotto.domain;

import static lotto.utils.MessagesUtil.*;

import lotto.utils.ConsoleUtil;
import lotto.utils.RankUtil;
import lotto.utils.RewardUtil;

public class WinningResult {
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public WinningResult() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
        this.fourth = 0;
        this.fifth = 0;
    }

    public void addRank(RankUtil rank) {
        if (rank == RankUtil.FIRST) {
            first++;
        } else if (rank == RankUtil.SECOND) {
            second++;
        } else if (rank == RankUtil.THIRD) {
            third++;
        } else if (rank == RankUtil.FOURTH) {
            fourth++;
        } else if (rank == RankUtil.FIFTH) {
            fifth++;
        }
    }

    public void show() {
        ConsoleUtil.showMessage(WINNING_RESULT.getMessage());
        showParamMessage(RankUtil.FIFTH.getMessage(), RewardUtil.FIFTH.getReward(), fifth);
        showParamMessage(RankUtil.FOURTH.getMessage(), RewardUtil.FOURTH.getReward(), fourth);
        showParamMessage(RankUtil.THIRD.getMessage(), RewardUtil.THIRD.getReward(), third);
        showParamMessage(RankUtil.SECOND.getMessage(), RewardUtil.SECOND.getReward(), second);
        showParamMessage(RankUtil.FIRST.getMessage(), RewardUtil.FIRST.getReward(), first);
    }

    private void showParamMessage(String message, int reward, int rank) {
        ConsoleUtil.showParamMessage(message, reward, rank);
    }

}
