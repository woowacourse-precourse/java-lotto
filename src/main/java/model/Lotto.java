package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import util.message.ErrorMessage;
import view.PrintView;

public class Lotto {
    public static final int PER_PRICE_LOTTO=1000;

    protected List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortAscend(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
    }

    protected void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_LENGTH_SIZE_NOT_SIX);
        }
        if (hasDuplicateNum(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_NOT_DUPLICATE_NUM);
        }
        if (!isNumRangeLotto(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_LOTTO_RANGE_NUM);
        }
    }

    protected void sortAscend(List<Integer> numbers){
        Collections.sort(numbers);
    }

    protected static boolean hasDuplicateNum(List<Integer> numbers) {
        HashSet hashSet = new HashSet();
        for (Integer number : numbers) {
            if (hashSet.contains(number)) {
                return true;
            }
            hashSet.add(number);
        }
        return false;
    }

    protected static boolean isNumRangeLotto(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lotto;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
