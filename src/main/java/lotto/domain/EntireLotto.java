package lotto.domain;

import lotto.utils.Constant;
import lotto.utils.LottoGenerator;
import lotto.utils.Ranking;
import lotto.view.outputView.EntireLottoOutputView;

import java.util.ArrayList;
import java.util.List;

public class EntireLotto {
    private LottoGenerator lottoGenerator;
    private List<Lotto> entireLotto;

    public EntireLotto() {
        lottoGenerator = new LottoGenerator();
        entireLotto = new ArrayList<>();
    }

    public void generateEntireLotto(int entireLottoCount) {
        for (int count = 0; count < entireLottoCount; count++) {
            entireLotto.add(lottoGenerator.generateLotto());
        }
    }

    public void showEntireLottoInfo() {
        StringBuffer lottoInfo = new StringBuffer();
        lottoInfo.append(entireLotto.size()).append("개를 구매했습니다.").append("\n");
        for (Lotto lotto : entireLotto) {
            lottoInfo.append(lotto.toString()).append("\n");
        }
        EntireLottoOutputView.showEntireLottoInfo(lottoInfo);
    }

    public void judgementEntireLottoWinning(WinningNumbers winningNumbers, RankingCount rankingCount) {
        for (Lotto lotto : entireLotto) {
            int correctLottoNumberCount = calculateContainsWinningNumbers(lotto, winningNumbers);
            boolean isBonus = calculateHasBonusNumber(lotto, winningNumbers);
            applyLottoRank(correctLottoNumberCount, isBonus, rankingCount);
        }
    }

    public int getLottoCount() {
        return entireLotto.size();
    }

    private int calculateContainsWinningNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        int count = 0;
        for (int index = 0; index < Constant.CORRECT_LOTTO_SIZE; index++) {
            int lottoNumber = lotto.getIndexLottoNumber(index);
            if (winningNumbers.contains(lottoNumber)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean calculateHasBonusNumber(Lotto lotto, WinningNumbers winningNumbers) {
        for (int index = 0; index < Constant.CORRECT_LOTTO_SIZE; index++) {
            int lottoNumber = lotto.getIndexLottoNumber(index);
            if (winningNumbers.hasBonusNumber(lottoNumber)) {
                return true;
            }
        }
        return false;
    }

    private void applyLottoRank(int correctLottoNumberCount, boolean isBonus, RankingCount rankingCount) {
        for (Ranking value : Ranking.values()) {
            if (value.getCorrectNumberCount() == correctLottoNumberCount && value.isBonus() == isBonus) {
                rankingCount.plusRankingCount(value.name());
            }
        }
    }
}
