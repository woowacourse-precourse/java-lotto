package lotto.domain;

import lotto.domain.constant.LottoProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DomainValidator {
    public static boolean hasCorrectSize (List<Integer> numbers) {
        return numbers.size() == LottoProperty.LENGTH.getProperty();
    }

    public static boolean hasCorrectRange (int number) {
        return (number >= LottoProperty.MIN_NUMBER.getProperty())
                && (number <= LottoProperty.MAX_NUMBER.getProperty());
    }

    public static boolean isAllUnique (List<Integer> numbers) {
        Set<Integer> lottoNumberSet = new HashSet<>(numbers);
        return lottoNumberSet.size() == LottoProperty.LENGTH.getProperty();
    }

    public static boolean hasNumberInLottery (List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
