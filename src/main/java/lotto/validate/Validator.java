package lotto.validate;

import java.util.List;

import static lotto.util.LottoGenerator.*;

public class Validator {

    public static boolean isNumber(String str) {
        validNumber(str);
        return true;
    }

    public static void validNumber(String str) {
        long count = str.chars()
                .filter(i -> !Character.isDigit(i))
                .count();
        if (count != 0) {
            throw new IllegalArgumentException("숫자 입력이 아닙니다.");
        }
    }

    public static boolean isBetween1And45(int number) {
        validBetween1And45(number);
        return true;
    }

    public static void validBetween1And45(int number) {
        boolean check = LOTTO_NUMBER_START <= number && number <= LOTTO_NUMBER_END;
        if (!check) {
            throw new IllegalArgumentException("1~45 범위의 숫자가 아닙니다.");
        }
    }

    public static void validLottoNumberSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호가 6개가 아닙니다.");
        }
    }

    public static void validDuplicateNumbers(List<Integer> numbers) {
        int size = numbers.size();
        long distinctedSize = numbers.stream().distinct().count();
        if (size != distinctedSize) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }
}
