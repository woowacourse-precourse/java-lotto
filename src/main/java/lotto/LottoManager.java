package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

// 로또 발행 및 통계 담당
public class LottoManager {

    public static final int LOTTO_LENGTH = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    /**
     * 로또 발행
     *
     * @param numberOfLotto 발행할 로또의 개수
     * @return 발행된 로또 List
     */
    public static List<List<Integer>> generateLotto(int numberOfLotto) {
        List<List<Integer>> lottos = new ArrayList<>();
        List<Integer> lotto;
        for (int i = 0; i < numberOfLotto; i++) {
            lotto = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_LENGTH);
            Collections.sort(lotto);
            lottos.add(lotto);
        }
        return lottos;
    }

    /**
     * 당첨 내역 계산
     *
     * @param userLottoPredictNumber 사용자가 입력한 당첨 번호
     * @return 당첨 내역
     */
    public static List<Integer> getLottoResult(List<Integer> userLottoPredictNumber) {
        List<Integer> lottoResult = new ArrayList<>();
        return lottoResult;
    }

    /**
     * 수익률 계산
     *
     * @param price 구입 금액
     * @return 수익률
     */
    public static int getRevenueRate(int price) {
        int revenueRate = 0;
        return revenueRate;
    }

}
