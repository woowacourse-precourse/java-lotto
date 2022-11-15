package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinCount;

import java.util.ArrayList;
import java.util.List;

public class LottoLogic {

    public int getAffordableLottoCount(int money, int lottoPrice) {
        return money / lottoPrice;
    }

    public List<Lotto> pickNumbers(int lottoCount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            result.add(new Lotto(RandomUtil.pickLottoNumbers()));
        }
        return result;
    }

    public List<LottoResult> calculateWins(List<Lotto> lottos, List<Integer> winNumbers, int bonusNumber) {
        List<LottoResult> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(getGrade(winNumbers, bonusNumber, lotto.getNumbers()));
        }
        return result;
    }

    public LottoResult getGrade(List<Integer> winNumbers, int bonus, List<Integer> pickNumbers) {
        int count = 0;
        for (int number : pickNumbers) {
            if (winNumbers.contains(number)) {
                count++;
            }
        }
        return gradeByHitCount(bonus, pickNumbers, count);
    }

    public WinCount getWinCount(List<LottoResult> lottoResults) {
        int firstPlaceCount = (int) lottoResults.stream().filter(e -> e == LottoResult.first).count();
        int secondPlaceCount = (int) lottoResults.stream().filter(e -> e == LottoResult.second).count();
        int thirdPlaceCount = (int) lottoResults.stream().filter(e -> e == LottoResult.third).count();
        int fourthPlaceCount = (int) lottoResults.stream().filter(e -> e == LottoResult.fourth).count();
        int fifthPlaceCount = (int) lottoResults.stream().filter(e -> e == LottoResult.fifth).count();
        return new WinCount(firstPlaceCount, secondPlaceCount, thirdPlaceCount, fourthPlaceCount, fifthPlaceCount);
    }

    public LottoResult gradeByHitCount(int bonus, List<Integer> pickNumbers, int count) {
        if (count == 6) {
            return LottoResult.first;
        }
        if (count == 5 && pickNumbers.contains(bonus)) {
            return LottoResult.second;
        }
        if (count == 5 && !pickNumbers.contains(bonus)) {
            return LottoResult.third;
        }
        if (count == 4) {
            return LottoResult.fourth;
        }
        if (count == 3) {
            return LottoResult.fifth;
        }
        return LottoResult.none;
    }

    public int getPrizeMoney(WinCount winCount) {
        int result = 0;
        result += winCount.getFirst() * LottoResult.first.getPrizeMoney();
        result += winCount.getSecond() * LottoResult.second.getPrizeMoney();
        result += winCount.getThird() * LottoResult.third.getPrizeMoney();
        result += winCount.getFourth() * LottoResult.fourth.getPrizeMoney();
        result += winCount.getFifth() * LottoResult.fifth.getPrizeMoney();
        return result;
    }

    public String calculateRatio(int cost, int prize) {
        return String.format("%.1f", (prize * 100.0 / cost));
    }
}
