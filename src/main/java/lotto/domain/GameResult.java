package lotto.domain;

import lotto.constant.WinningConstants;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.constant.GameConstants.LOTTO_PRICE;

public class GameResult {
    private final List<Integer> result;
    private float profitRate;

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
            if (matchesWinningCondition(matchingNumber, hasBonusNumber, nthPlace)) {
                place = nthPlace.getPlace();
            }
        }
        return place;
    }

    private boolean matchesWinningCondition(int matchingNumber, boolean hasBonusNumber, WinningConstants nthPlace) {
        int requiredWinningNumber = nthPlace.getRequiredWinningNumber();
        boolean needsBonusNumber = nthPlace.getNeedsBonusNumber();

        if (matchingNumber < requiredWinningNumber) {
            return false;
        }
        return !needsBonusNumber || hasBonusNumber;
    }

    public void calculateProfitRate(int numberLotto) {
        int expenditure = LOTTO_PRICE * numberLotto;
        int income = Arrays.stream(WinningConstants.values())
                .map(this::calculatePrize)
                .mapToInt(i -> i)
                .sum();

        profitRate = 100.0f * income / expenditure;
    }

    private int calculatePrize(WinningConstants nthPlace) {
        int reward = nthPlace.getReward();
        int place = nthPlace.getPlace();
        int count = result.get(place);
        return reward * count;
    }

    public void printTotalResult() {
        OutputView.printStatistics();

        Arrays.stream(WinningConstants.values())
                .forEach(this::printPlaceResult);

        OutputView.printProfitRate(profitRate);
    }

    private void printPlaceResult(WinningConstants nthPlace) {
        int place = nthPlace.getPlace();
        int count = result.get(place);
        String message = nthPlace.getMessage();
        OutputView.printPlaceResult(String.format(message, count));
    }
}
