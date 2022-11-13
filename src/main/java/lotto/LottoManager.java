package lotto;

import java.util.ArrayList;
import java.util.List;

// 로또 발행 및 통계 담당
public class LottoManager {

    /**
     * 로또 발행
     *
     * @param numberOfLotto 발행할 로또의 개수
     * @return 발행된 로또 List
     */
    public static List<List<Integer>> generateLotto(int numberOfLotto) {
        List<List<Integer>> lotto = new ArrayList<>();
        return lotto;
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
