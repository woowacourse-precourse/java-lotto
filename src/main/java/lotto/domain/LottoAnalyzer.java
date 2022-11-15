package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 로또 당첨 번호, 보너스 번호, 사용자 로또 번호 분석
 */
public class LottoAnalyzer {
    private final List<Lotto> lottoNumbers;
    private final List<Integer> lottoWinNumber;
    private final int lottoBonusBall;

    public LottoAnalyzer(List<Lotto> lottoNumbers, List<Integer> lottoWinNumber, int lottoBonusBall) {
        this.lottoNumbers = lottoNumbers;
        this.lottoWinNumber = lottoWinNumber;
        this.lottoBonusBall = lottoBonusBall;
    }

    /**
     * 로또 당첨 번호와 당첨된 갯수 찾는 로직
     */
    public Map<LottoRank, Integer> analyzeLottoWin() {
        Map<LottoRank, Integer> lottoWinAmounts = new LinkedHashMap<>();
        initializeLottoRankNumber(lottoWinAmounts);

        for (Lotto lottoNumber : lottoNumbers) {
            int rankNumber = findLottoWinRank(lottoNumber);
            LottoRank lottoRank = LottoRank.scoreRankNumber(rankNumber);
            lottoRank = findSecondLottoWinRank(lottoRank, lottoNumber.getNumbers());
            if (validateNoRank(lottoRank)) {
                continue;
            }
            lottoWinAmounts.put(lottoRank, lottoWinAmounts.get(lottoRank) + 1);
        }

        return lottoWinAmounts;
    }

    /**
     * 로또 당첨 순위가 발견되지 않을 때를 검증
     */
    private boolean validateNoRank(LottoRank lottoRank) {
        return lottoRank == null;
    }

    /**
     * 로또 보너스 번호로 2등 당첨 찾기
     */
    private LottoRank findSecondLottoWinRank(LottoRank lottoRank, List<Integer> lottoNumber) {
        if (lottoRank == LottoRank.THIRD_RANK && lottoNumber.contains(lottoBonusBall)) {
            lottoRank = LottoRank.SECOND_RANK;
        }
        return lottoRank;
    }

    /**
     * 로또 당첨된 번호 찾기
     */
    private int findLottoWinRank(Lotto lottoNumber) {
        List<Integer> lotto = lottoNumber.getNumbers();
        int rankNumber = 0;
        for (int i = 0; i < lottoWinNumber.size(); ++i) {
            if (lotto.contains(lottoWinNumber.get(i))) {
                ++rankNumber;
            }
        }
        return rankNumber;
    }

    /**
     * 로또 당첨 순위 초기화
     */
    private void initializeLottoRankNumber(Map<LottoRank, Integer> lottoWinAmounts) {
        lottoWinAmounts.put(LottoRank.FIFTH_RANK, 0);
        lottoWinAmounts.put(LottoRank.FOURTH_RANK, 0);
        lottoWinAmounts.put(LottoRank.THIRD_RANK, 0);
        lottoWinAmounts.put(LottoRank.SECOND_RANK, 0);
        lottoWinAmounts.put(LottoRank.FIRST_RANK, 0);
    }
}
