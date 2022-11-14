package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static lotto.values.Constants.Digit.*;

public class Rank {
    private final LinkedHashMap<Integer, Integer> ranking;

    public Rank(LinkedHashMap<Integer, Integer> ranking) {
        this.ranking = ranking;
    }

    public LinkedHashMap<Integer, Integer> getRank() {
        return ranking;
    }

    public static Rank getLottosRanking(Lotto winningLotto, int bonusNumber, List<Lotto> lottos) {
        LinkedHashMap<Integer, Integer> lottoRanking = createRankingBoard();
        List<Integer> winningLottoNumbers = winningLotto.getLottoNumbers();
        List<Integer> rightNumbers, wrongNumbers;
        int rightNumberCnt;

        for (Lotto lotto : lottos) {
            rightNumbers = getRightNumbers(winningLottoNumbers, lotto);
            wrongNumbers = getWrongNumbers(winningLottoNumbers, lotto);
            rightNumberCnt = rightNumbers.size();

            lottoRanking = getLottoRanking(lottoRanking, bonusNumber, wrongNumbers, rightNumberCnt);
        }
        return new Rank(lottoRanking);
    }

    private static LinkedHashMap<Integer, Integer> getLottoRanking(LinkedHashMap<Integer, Integer> ranking, int bonusNumber, List<Integer> wrongNumbers, int rightNumberCnt) {
        Integer lottoRank = checkLottoRanking(rightNumberCnt, wrongNumbers, bonusNumber);
        if (lottoRank != null) {
            ranking.put(lottoRank, ranking.get(lottoRank) + 1);
        }

        return ranking;
    }

    private static Integer checkLottoRanking(int rightNumberCnt, List<Integer> wrongNumbers, int bonusNumber) {
        Integer ranking = null;
        if (rightNumberCnt == SIX_CORRECT) {
            ranking = FIRST_PLACE;
        } else if (rightNumberCnt == FIVE_CORRECT && wrongNumbers.contains(bonusNumber)) {
            ranking = SECOND_PLACE;
        } else if (rightNumberCnt == FIVE_CORRECT) {
            ranking = THIRD_PLACE;
        } else if (rightNumberCnt == FOUR_CORRECT) {
            ranking = FOURTH_PLACE;
        } else if (rightNumberCnt == THREE_CORRECT) {
            ranking = FIFTH_PLACE;
        }

        return ranking;
    }

    private static LinkedHashMap<Integer, Integer> createRankingBoard() {
        LinkedHashMap<Integer, Integer> rankingBoard = new LinkedHashMap<>();
        rankingBoard.put(FIRST_PLACE, 0);
        rankingBoard.put(SECOND_PLACE, 0);
        rankingBoard.put(THIRD_PLACE, 0);
        rankingBoard.put(FOURTH_PLACE, 0);
        rankingBoard.put(FIFTH_PLACE, 0);

        return rankingBoard;
    }

    private static List<Integer> getRightNumbers(List<Integer> winningLottoNumbers, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        List<Integer> rightNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            if (lottoNumbers.contains(winningLottoNumbers.get(i))) {
                rightNumbers.add(lottoNumbers.get(i));
            }
        }
        return rightNumbers;
    }

    private static List<Integer> getWrongNumbers(List<Integer> winningLottoNumbers, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        List<Integer> wrongNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            if (!lottoNumbers.contains(winningLottoNumbers.get(i))) {
                wrongNumbers.add(lottoNumbers.get(i));
            }
        }
        return wrongNumbers;
    }
}
