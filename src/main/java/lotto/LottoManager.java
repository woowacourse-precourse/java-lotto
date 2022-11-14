package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

// 로또 발행 및 통계 담당
public class LottoManager {

    public static final int LOTTO_LENGTH = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public enum Rank {
        fifth(3, 5000),
        fourth(4, 50000),
        third(5, 1500000),
        second(5, 30000000),
        first(6, 2000000000);

        private final int numberOfSameLottoNumber;
        private final int rewardPrice;

        Rank(int numberOfSameLottoNumber, int rewardPrice) {
            this.numberOfSameLottoNumber = numberOfSameLottoNumber;
            this.rewardPrice = rewardPrice;
        }

        public int getNumberOfSameLottoNumber() {
            return numberOfSameLottoNumber;
        }

        public int getRewardPrice() {
            return rewardPrice;
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
    public static Map<String, Integer> getLottoRankResult(List<Integer> userPredictLottoNumbers, int userPredictBonusNumber) {
        Lotto userLotto = new Lotto(userPredictLottoNumbers);
        Map<String, Integer> lottoRankResult = initiateLottoRankResult();
        int numberOfSameLottoNumber;
        boolean isBonusNumberSame;

        for (List<Integer> lotto : ProgramManager.lotto) {
            numberOfSameLottoNumber = userLotto.countSameLottoNumber(lotto);
            isBonusNumberSame = userLotto.checkBonusLottoNumber(lotto, userPredictBonusNumber);
            setLottoResult(lottoRankResult, numberOfSameLottoNumber, isBonusNumberSame);
        }
        return lottoRankResult;
    }

    private static Map<String, Integer> initiateLottoRankResult() {
        Map<String, Integer> lottoRankResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            lottoRankResult.put(rank.toString(), 0);
        }
        return lottoRankResult;
    }

    /**
     * @param lottoRankResult         당첨 내역 저장 배열
     * @param numberOfSameLottoNumber 당첨 번호 일치 개수
     * @param isBonusNumberSame       보너스 번호 일치 여부
     */
    private static void setLottoResult(Map<String, Integer> lottoRankResult, int numberOfSameLottoNumber, boolean isBonusNumberSame) {
        for (Rank rank : Rank.values()) {
            int previousRankResult = lottoRankResult.get(rank.toString());
            if (rank.toString().compareTo("second") != 0 && rank.toString().compareTo("third") != 0 && numberOfSameLottoNumber == rank.numberOfSameLottoNumber) {
                lottoRankResult.replace(rank.toString(), previousRankResult + 1);
                return;
            }
            if (rank.toString().compareTo("second") == 0 && numberOfSameLottoNumber == rank.numberOfSameLottoNumber && isBonusNumberSame) {
                lottoRankResult.replace(rank.toString(), previousRankResult + 1);
                return;
            }
            if (rank.toString().compareTo("third") == 0 && numberOfSameLottoNumber == rank.numberOfSameLottoNumber && !isBonusNumberSame) {
                lottoRankResult.replace(rank.toString(), previousRankResult + 1);
                return;
            }
        }
    }


    /**
     * TODO: 수익률 계산
     *
     * @param price           구입 금액
     * @param lottoRankResult 당첨 내역
     * @return 수익률
     */
    public static float getRevenueRate(int price, Map<String, Integer> lottoRankResult) {
        float revenue = 0;
        for (Rank rank : Rank.values()) {
            String rankName = rank.toString();
            revenue += lottoRankResult.get(rankName) * Rank.valueOf(rankName).rewardPrice;
        }
        return (revenue / price) * 100;
    }

}
