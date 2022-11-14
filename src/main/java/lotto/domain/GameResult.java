package lotto.domain;

import lotto.constant.WinningConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
    private final List<Integer> result;

    public GameResult() {
        int placeRange = WinningConstants.values().length;
        result = new ArrayList<>(Collections.nCopies(placeRange + 1, 0));
    }

    public void calculateTotalResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        lottos.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(lottoNumbers -> calculateSingleResult(lottoNumbers, winningNumbers, bonusNumber));
    }

    private void calculateSingleResult(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchingNumber = countMatchingNumber(lottoNumbers, winningNumbers);
        boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);

        int place = calculatePlace(matchingNumber, hasBonusNumber);
        result.set(place, result.get(place) + 1);
    }

    private int countMatchingNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private int calculatePlace(int matchingNumber, boolean hasBonusNumber) {
        int place = 0;

        for (WinningConstants nthPlace : WinningConstants.values()) {
            if (check(matchingNumber, hasBonusNumber, nthPlace)) {
                place = nthPlace.getPlace();
            }
        }
        return place;
    }

    private boolean check(int matchingNumber, boolean hasBonusNumber, WinningConstants nthPlace) {
        int requiredWinningNumber = nthPlace.getRequiredWinningNumber();
        boolean needsBonusNumber = nthPlace.getNeedsBonusNumber();

        if (matchingNumber < requiredWinningNumber) {
            return false;
        }
        return !needsBonusNumber || hasBonusNumber;
    }

    private int calculatePrize(WinningConstants nthPlace) {
        int reward = nthPlace.getReward();
        int place = nthPlace.getPlace();
        int count = result.get(place);
        return reward * count;
    }
}
