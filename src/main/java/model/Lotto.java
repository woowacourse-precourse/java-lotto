package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import util.message.ErrorMessage;

public class Lotto {
    public static final int PER_PRICE_LOTTO=1000;
    public static final int MIN_LOTTO_NUM=1;
    public static final int MAX_LOTTO_NUM=45;
    public static final int LOTTO_SIZE=6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
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

    protected static List<Integer> sortAscend(List<Integer> numbers){
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
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
            if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> generateAndSortLotto() {
        List<Integer> lotto = generateLotto();
        List<Integer> sortedLotto = sortAscend(lotto);
        return sortedLotto;
    }

    private static List<Integer> generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE);
        return lotto;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
