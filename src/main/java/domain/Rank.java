package domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static values.Constants.Digit.*;

public class Rank {
    private final LinkedHashMap<Integer, Integer> ranking;

    public Rank(LinkedHashMap<Integer, Integer> ranking) {
        this.ranking = ranking;
    }

    public LinkedHashMap<Integer, Integer> getRank() {
        return ranking;
    }

    public static Rank getRank(Lotto winningLotto, int bonusNumber, List<Lotto> lottos) {
        LinkedHashMap<Integer, Integer> ranking = createRankingBoard();
        List<Integer> winningLottoNumbers = winningLotto.getLottoNumbers();
        List<Integer> rightNumbers, wrongNumbers;

        for (Lotto lotto : lottos) {
            //getRightORWrongNumbers
            rightNumbers = getRightNumbers(winningLottoNumbers, lotto);
            wrongNumbers = getWrongNumbers(winningLottoNumbers, lotto);
            int rightNumberCnt = rightNumbers.size();

            //checkFirstPlace
            if (checkFirstPlace(rightNumberCnt)) {
                ranking.put(FIRST_PLACE, ranking.get(FIRST_PLACE) + 1);
                continue;
            }
            //checkSecondPlace
            if (checkSecondPlace(rightNumberCnt, wrongNumbers, bonusNumber)) {
                ranking.put(SECOND_PLACE, ranking.get(SECOND_PLACE) + 1);
                continue;
            }
            //checkOtherPlace
            if (rightNumberCnt > 2) {
                int rank = rightNumberCnt - 1;
                ranking.put(rank, ranking.get(rank) + 1);
            }
        }
        return new Rank(ranking);
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
            if (lottoNumbers.get(i) == winningLottoNumbers.get(i)) {
                rightNumbers.add(lottoNumbers.get(i));
            }
        }
        return rightNumbers;
    }

    private static List<Integer> getWrongNumbers(List<Integer> winningLottoNumbers, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        List<Integer> wrongNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            if (lottoNumbers.get(i) != winningLottoNumbers.get(i)) {
                wrongNumbers.add(lottoNumbers.get(i));
            }
        }
        return wrongNumbers;
    }

    private static boolean checkFirstPlace(int rightNumberCnt) {
        if (rightNumberCnt == LOTTO_NUMBER_COUNT) {
            return true;
        }
        return false;
    }

    private static boolean checkSecondPlace(int rightNumberCnt, List<Integer> wrongNumbers, int bonusNumber) {
        if (rightNumberCnt == LOTTO_NUMBER_COUNT - 1 && wrongNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
