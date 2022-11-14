package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.InputException;
import lotto.util.Util;

import java.util.ArrayList;
import java.util.List;

import static lotto.constance.LottoConstance.*;
import static lotto.exception.InputException.*;
import static lotto.util.Util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNotDuplicate(toStringOfList(numbers));
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현

    public static Lotto create() {
        return new Lotto(createRandomNumbers());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER, NUMBER_LENGTH);
        return new ArrayList<>(randomNumbers);
    }
}
