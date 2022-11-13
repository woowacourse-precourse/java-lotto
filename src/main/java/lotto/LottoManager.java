package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

// 로또 발행 및 통계 담당
public class LottoManager {

    public static final int LOTTO_LENGTH = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public enum Reward {
        fifth(5000),
        fourth(50000),
        third(1500000),
        second(30000000),
        first(2000000000);

        private final int rewardPrice;

        Reward(int rewardPrice) {
            this.rewardPrice = rewardPrice;
        }

        public int getRewardPrice() {
            return rewardPrice;
        }
    }

    public enum Rank {
        fifth(3, 0),
        fourth(4, 1),
        third(5, 2),
        second(5, 3),
        first(6, 4);

        private final int numberOfSameLottoNumber;
        private final int indexInRankResult;

        Rank(int numberOfSameLottoNumber, int indexInRankResult) {
            this.numberOfSameLottoNumber = numberOfSameLottoNumber;
            this.indexInRankResult = indexInRankResult;
        }

        public int getNumberOfSameLottoNumber() {
            return numberOfSameLottoNumber;
        }

        public int getIndexInRankResult() {
            return indexInRankResult;
        }
    }


    /**
     * TODO: 로또 발행
     *
     * @param numberOfLotto 발행할 로또의 개수
     * @return 발행된 로또 List
     */
    public static List<List<Integer>> generateLotto(int numberOfLotto) {
        List<List<Integer>> lottos = new ArrayList<>();
        List<Integer> lotto;
        for (int i = 0; i < numberOfLotto; i++) {
            lotto = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_LENGTH);
            lottos.add(lotto);
        }
        return lottos;
    }


    /**
     * TODO: 당첨 내역 계산
     *
     * @param userPredictLottoNumbers 사용자가 입력한 당첨 번호 List
     * @param userPredictBonusNumber  사용자가 입력한 보너스 번호
     * @return 당첨 내역
     */
    public static int[] getLottoRankResult(List<Integer> userPredictLottoNumbers, int userPredictBonusNumber) {
        Lotto userLotto = new Lotto(userPredictLottoNumbers);

        int[] lottoRankResult = new int[Rank.values().length];
        int numberOfSameLottoNumber;
        boolean isBonusNumberSame;

        for (List<Integer> lotto : ProgramManager.lotto) {
            numberOfSameLottoNumber = userLotto.countSameLottoNumber(lotto);
            isBonusNumberSame = userLotto.checkBonusLottoNumber(lotto, userPredictBonusNumber);
            setLottoResult(lottoRankResult, numberOfSameLottoNumber, isBonusNumberSame);
        }
        return lottoRankResult;
    }

    /**
     * @param lottoRankResult         당첨 내역 저장 배열
     * @param numberOfSameLottoNumber 당첨 번호 일치 개수
     * @param isBonusNumberSame       보너스 번호 일치 여부
     */
    private static void setLottoResult(int[] lottoRankResult, int numberOfSameLottoNumber, boolean isBonusNumberSame) {
        if (numberOfSameLottoNumber == Rank.first.numberOfSameLottoNumber) {
            lottoRankResult[Rank.first.indexInRankResult]++;
            return;
        }
        if (numberOfSameLottoNumber == Rank.second.numberOfSameLottoNumber && isBonusNumberSame) {
            lottoRankResult[Rank.second.indexInRankResult]++;
            return;
        }
        if (numberOfSameLottoNumber == Rank.third.numberOfSameLottoNumber && !isBonusNumberSame) {
            lottoRankResult[Rank.third.indexInRankResult]++;
            return;
        }
        if (numberOfSameLottoNumber == Rank.fourth.numberOfSameLottoNumber) {
            lottoRankResult[Rank.fourth.indexInRankResult]++;
            return;
        }
        if (numberOfSameLottoNumber == Rank.fifth.numberOfSameLottoNumber) {
            lottoRankResult[Rank.fifth.indexInRankResult]++;
        }
    }


    /**
     * TODO: 수익률 계산
     *
     * @param price           구입 금액
     * @param lottoRankResult 당첨 내역
     * @return 수익률
     */
    public static float getRevenueRate(int price, int[] lottoRankResult) {
        float revenue = 0;
        for (Rank rank : Rank.values()) {
            revenue += lottoRankResult[rank.indexInRankResult] * Reward.valueOf(rank.toString()).rewardPrice;
        }
        return (revenue / price) * 100;
    }

}
