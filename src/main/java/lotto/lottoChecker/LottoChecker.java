package lotto.lottoChecker;

import lotto.numbers.Lotto;
import lotto.numbers.WinningNumbers;

import java.util.List;

public interface LottoChecker {
    //return int 배열의 의미
    //n번 index의 값 x => n등 x개
    void checkLottos(List<Lotto> lottos);
    int[] getRankResult();
    int getRewardResult();
    double calculateROI();
    int[] checkHowManyMatches(List<Integer> lottoNumbers);
}
