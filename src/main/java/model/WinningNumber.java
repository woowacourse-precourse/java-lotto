package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static model.LottoStatus.END;
import static model.LottoStatus.START;
import static model.WinningNumberStatus.*;

public class WinningNumber {
    private final Lotto luckyNumber;
    private final int bonusNumber;

    public WinningNumber(Lotto luckyNumber, int bonusNumber) {
        this.luckyNumber = luckyNumber;
        validateRange(bonusNumber);
        validateDuplication(luckyNumber, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.toString());
        }
    }

    private boolean isOutOfRange(int bonusNumber) {
        return bonusNumber < START.getValue() || END.getValue() < bonusNumber;
    }

    private void validateDuplication(Lotto luckyNumber, int bonusNumber) {
        if (isDuplicate(luckyNumber, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION.toString());
        }
    }

    private boolean isDuplicate(Lotto luckyNumber, int bonusNumber) {
        return getLuckyNumber(luckyNumber).contains(bonusNumber);
    }

    private List<Integer> getLuckyNumber(Lotto luckyNumber) {
        return luckyNumber.getNumbers();
    }

    public HashMap<Integer, Integer> checkLotto(List<Lotto> lotteries) {
        HashMap<Integer, Integer> result = new HashMap<>();
        HashSet<Integer> exist = new HashSet<>();

        initResult(result);
        initExist(exist);
        for (int index = 0; index < lotteries.size(); index++) {
            addResult(result, getNumbers(lotteries, index), getCount(lotteries, exist, index));
        }
        return result;
    }

    private void addResult(HashMap<Integer, Integer> result, List<Integer> numbers, int count) {
        if (count == FIRST.getCount()) {
            result.put(FIRST.getOrder(), result.get(FIRST.getOrder()) + 1);
            return;
        }

        if (count == SECOND.getCount() && numbers.contains(bonusNumber)) {
            result.put(SECOND.getOrder(), result.get(SECOND.getOrder()) + 1);
            return;
        }

        if (FIFTH.getCount() <= count && count <= THIRD.getCount()) {
            result.put(getOrderOverTHIRD(count), result.get(getOrderOverTHIRD(count)) + 1);
        }
    }

    private int getCount(List<Lotto> lotteries, HashSet<Integer> exist, int lotteriesIndex) {
        int count = 0;
        for (int numbersIndex = 0; numbersIndex < getNumbers(lotteries, lotteriesIndex).size(); numbersIndex++) {
            if (exist.contains(getNumbers(lotteries, lotteriesIndex).get(numbersIndex))) {
                count++;
            }
        }
        return count;
    }

    private List<Integer> getNumbers(List<Lotto> lotteries, int index) {
        return lotteries.get(index).getNumbers();
    }

    private void initExist(HashSet<Integer> exist) {
        for (int index = 0; index < luckyNumber.getNumbers().size(); index++) {
            exist.add(luckyNumber.getNumbers().get(index));
        }
    }

    private void initResult(HashMap<Integer, Integer> result) {
        for (int rank = FIRST.getOrder(); rank <= FIFTH.getOrder(); rank++) {
            result.put(rank, 0);
        }
    }
}


