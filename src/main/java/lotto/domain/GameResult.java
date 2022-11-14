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
}
