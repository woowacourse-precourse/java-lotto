package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.WinCount;
import lotto.util.RandomUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    InputView in = new InputView();
    OutputView out = new OutputView();

    private final int lottoPrice = 1000;
    private final int firstPrize = 2000000000;
    private final int secondPrize = 30000000;
    private final int thirdPrize = 1500000;
    private final int fourthPrize = 50000;
    private final int fifthPrize = 5000;


    public void run() {
        out.announceInputMoney();
        int money = in.inputMoney();
        int lottoCount = getAffordableLottoCount(money);
        List<List<Integer>> boughtLottos = pickNumbers(lottoCount);
        out.printSpacer();
        out.announceBuyResult(lottoCount);
        out.printBoughtLotto(boughtLottos);

        out.printSpacer();
        out.announceInputWinNumber();
        List<Integer> winNumbers = in.inputWinNumbers();
        out.printSpacer();
        out.announceInputBonusNumber();
        int bonusNumber = in.inputBonusNumber(winNumbers);

        List<LottoResult> lottoResults = calculateWins(boughtLottos, winNumbers, bonusNumber);
        out.printSpacer();
        out.announceResult();
        out.printDivider();
        WinCount winCount = getWinCount(lottoResults);
        out.printWinCount(winCount);
        int prizeMoney = getPrizeMoney(winCount);
        String profitRatio = calculateRatio(money, prizeMoney);
        out.printProfitRatio(profitRatio);
    }

    private int getAffordableLottoCount(int money) {
        return money / lottoPrice;
    }

    private List<List<Integer>> pickNumbers(int lottoCount) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            result.add(RandomUtil.pickLottoNumbers());
        }
        return result;
    }

    private List<LottoResult> calculateWins(List<List<Integer>> pickNumberList, List<Integer> winNumbers, int bonusNumber) {
        List<LottoResult> result = new ArrayList<>();
        for (List<Integer> pickNumbers : pickNumberList) {
            result.add(getGrade(winNumbers, bonusNumber, pickNumbers));
        }
        return result;
    }

    private LottoResult getGrade(List<Integer> winNumbers, int bonus, List<Integer> pickNumbers) {
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

    private LottoResult gradeByHitCount(int bonus, List<Integer> pickNumbers, int count) {
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

    private int getPrizeMoney(WinCount winCount) {
        int result = 0;
        result += winCount.getFirst() * firstPrize;
        result += winCount.getSecond() * secondPrize;
        result += winCount.getThird() * thirdPrize;
        result += winCount.getFourth() * fourthPrize;
        result += winCount.getFifth() * fifthPrize;
        return result;
    }

    private String calculateRatio(int cost, int prize) {
        return String.format("%.1f", (prize * 100.0 / cost));
    }
}
