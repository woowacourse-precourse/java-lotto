package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constants.*;

public class Game {

    Player player;
    WinningNumber winningNumber;

    public Game() {
        player = new Player();
        winningNumber = new WinningNumber();
    }

    private void printWinningStatistics() {
        int[] result = countMatch(player.lottoSet, winningNumber.getLotto(), winningNumber.getBonusNumber());
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(FIFTH_PLACE_MESSAGE + result[5] + "개");
        System.out.println(FOURTH_PLACE_MESSAGE + result[4] + "개");
        System.out.println(THIRD_PLACE_MESSAGE + result[3] + "개");
        System.out.println(SECOND_PLACE_MESSAGE + result[2] + "개");
        System.out.println(FIRST_PLACE_MESSAGE + result[1] + "개");
    }

    private int[] countMatch(List<Lotto> lottoSet, Lotto winningNumber, int bonusNumber) {
        return findNthPlace(lottoSet, winningNumber, bonusNumber);
    }

    private int[] findNthPlace(List<Lotto> lottoSet, Lotto winningNumber, int bonusNumber) {
        int result[] = new int[6];

        for (int i = 0; i < lottoSet.size(); i++) {
            int index = checkRank(lottoSet.get(i), winningNumber, bonusNumber);
            result[index]++;
        }
        return result;
    }

    private int checkRank(Lotto lotto, Lotto winningNumber, int bonusNumber) {
        int count = countNumberInLotto(lotto, winningNumber);

        if (count == NUM_TO_MATCH5TH)
            return 5;
        if (count == NUM_TO_MATCH4TH)
            return 4;
        if (count == NUM_TO_MATCH2TH && lotto.isContained(bonusNumber))
            return 2;
        if (count == NUM_TO_MATCH3TH)
            return 3;
        if (count == NUM_TO_MATCH1TH)
            return 1;
        return 0;
    }

    private int countNumberInLotto(Lotto lotto, Lotto winningNumber) {
        int count = 0;
        List<Integer> winningLotto = winningNumber.getNumbers();
        for (int i = 0; i < LOTTO_COUNT; i++) {
            if (lotto.isContained(winningLotto.get(i))) {
                count++;
            }
        }
        return count;
    }

}
