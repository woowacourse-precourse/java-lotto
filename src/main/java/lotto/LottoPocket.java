package lotto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 플레이어가 발행한 전체 로또 목록을 관리하는 클래스
 */
public class LottoPocket {

    private List<Lotto> lottoGroup;

    public LottoPocket(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public ScratchResult getScratchResult(WinningLotto winningLotto) {
        return null;
    }

    private Map<LottoGrade, Integer> getNumberOfWinsByGrade(WinningLotto winningLotto) {
        return null;
    }

    private long getTotalEarning(Map<LottoGrade, Integer> numberOfWinsByGrade) {
        return 0;
    }

    private double getEarningRate(double totalEarning) {
        return 0;
    }
}
