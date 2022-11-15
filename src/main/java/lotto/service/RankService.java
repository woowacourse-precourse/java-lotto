package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static lotto.values.Constants.Console.STATISTICS_MESSAGE;
import static lotto.values.Constants.Digit.*;

public class RankService {
    private static final RankService rankService = new RankService();

    public static RankService getRankService(){
        return rankService;
    }

    public Rank getLottosRanking(Lotto winningLotto, int bonusNumber, List<Lotto> lottos) {
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

    public Rank getLottoDrawResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) { // Value 다른 이름으로 변ㅎ
        System.out.println(STATISTICS_MESSAGE);
        Rank rank = getLottosRanking(winningLotto, bonusNumber, lottos);
        return rank;
    }

    public int calculateRankingPrize(Integer rank, int cnt) {
        int prize = 0;
        if (rank.equals(FIRST_PLACE)) {
            prize = FIRST_PLACE_PRIZE;
        } else if (rank.equals(SECOND_PLACE)) {
            prize = SECOND_PLACE_PRIZE;
        } else if (rank.equals(THIRD_PLACE)) {
            prize = THIRD_PLACE_PRIZE;
        } else if (rank.equals(FOURTH_PLACE)) {
            prize = FOURTH_PLACE_PRIZE;
        } else if (rank.equals(FIFTH_PLACE)) {
            prize = FIFTH_PLACE_PRIZE;
        }

        return prize * cnt;
    }
}
