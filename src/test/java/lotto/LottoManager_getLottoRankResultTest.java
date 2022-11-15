package lotto;

import lotto.manageLotto.LottoManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoManager_getLottoRankResultTest {

    @BeforeAll
    static void init() throws IllegalArgumentException {
        int numberOfLotto = 1;
        ProgramManager.lotto = LottoManager.generateLotto(numberOfLotto);
    }

    /**
     * getLottoResult - 당첨 내역 계산
     */
    @Test
    void getLottoRankResult_1등_테스트() {
        List<Integer> userPredictLottoNumbers = ProgramManager.lotto.get(0);
        int userPredictBonusNumber = ProgramManager.lotto.get(0).get(0);

        Map<String, Integer> answerOfLottoRankResult = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.fifth.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.fourth.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.third.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.second.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.first.toString(), 1)
        );
        assertThat(true).isEqualTo(answerOfLottoRankResult.equals(LottoManager.getLottoRankResult(userPredictLottoNumbers, userPredictBonusNumber)));
    }

    @Test
    void getLottoRankResult_2등_테스트() {
        List<Integer> userPredictLottoNumbers = getUserPredictLottoNumbers_modified(2);
        int userPredictBonusNumber_same = ProgramManager.lotto.get(0).get(LottoManager.LOTTO_LENGTH - 1);

        Map<String, Integer> answerOfLottoRankResult = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.fifth.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.fourth.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.third.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.second.toString(), 1),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.first.toString(), 0)
        );
        assertThat(true).isEqualTo(answerOfLottoRankResult.equals(LottoManager.getLottoRankResult(userPredictLottoNumbers, userPredictBonusNumber_same)));
    }

    @Test
    void getLottoRankResult_3등_테스트() {
        List<Integer> userPredictLottoNumbers = getUserPredictLottoNumbers_modified(3);
        int userPredictBonusNumber_notSame = getNotSameBonusNumber();

        Map<String, Integer> answerOfLottoRankResult = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.fifth.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.fourth.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.third.toString(), 1),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.second.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.first.toString(), 0)
        );
        assertThat(true).isEqualTo(answerOfLottoRankResult.equals(LottoManager.getLottoRankResult(userPredictLottoNumbers, userPredictBonusNumber_notSame)));
    }

    private int getNotSameBonusNumber() {
        int number = 1;
        List<Integer> lotto = ProgramManager.lotto.get(0);
        while (true) {
            if (!lotto.contains(number)) {
                return number;
            }
            number++;
        }
    }

    @Test
    void getLottoRankResult_4등_테스트() {
        List<Integer> userPredictLottoNumbers = getUserPredictLottoNumbers_modified(4);
        int userPredictBonusNumber = userPredictLottoNumbers.get(0);

        Map<String, Integer> answerOfLottoRankResult = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.fifth.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.fourth.toString(), 1),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.third.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.second.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.first.toString(), 0)
        );
        assertThat(true).isEqualTo(answerOfLottoRankResult.equals(LottoManager.getLottoRankResult(userPredictLottoNumbers, userPredictBonusNumber)));
    }

    @Test
    void getLottoRankResult_5등_테스트() {
        List<Integer> userPredictLottoNumbers = getUserPredictLottoNumbers_modified(5);
        int userPredictBonusNumber = userPredictLottoNumbers.get(0);

        Map<String, Integer> answerOfLottoRankResult = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.fifth.toString(), 1),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.fourth.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.third.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.second.toString(), 0),
                new AbstractMap.SimpleEntry<>(LottoManager.Rank.first.toString(), 0)
        );
        assertThat(true).isEqualTo(answerOfLottoRankResult.equals(LottoManager.getLottoRankResult(userPredictLottoNumbers, userPredictBonusNumber)));
    }

    /**
     * @param rank 테스트 등수
     * @return 테스트에 맞춰서 사용자 입력을 변형한 로또 당첨 번호
     */
    public static List<Integer> getUserPredictLottoNumbers_modified(int rank) {
        int sameLottoNumber = LottoManager.LOTTO_LENGTH - rank + 2;
        if (rank == 2) {
            sameLottoNumber = LottoManager.LOTTO_LENGTH - rank + 1;
        }

        List<Integer> lotto = ProgramManager.lotto.get(0);
        List<Integer> userPredictLottoNumbers = new ArrayList<>();

        int number = 1;
        for (int i = 0; i < LottoManager.LOTTO_LENGTH; i++) {
            if (i < sameLottoNumber) {
                userPredictLottoNumbers.add(lotto.get(i));
                continue;
            }
            if (!lotto.contains(number)) {
                userPredictLottoNumbers.add(number++);
                continue;
            }
            number++;
            i--;
        }

        Collections.sort(userPredictLottoNumbers);
        return userPredictLottoNumbers;
    }

}
