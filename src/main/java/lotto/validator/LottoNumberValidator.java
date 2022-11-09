package lotto.validator;

import java.util.stream.Collectors;

public class LottoNumberValidator {

    private static final String REGEX = "^([0-9]*,){5}[0-9]*$";
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MAX_NUMBER = 46;
    private static final int MIN_NUMBER = 0;

    public static void validate(String lottoNumber) {
        if (lottoNumber.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
        if (isisOverlap(lottoNumber)) {
            throw new IllegalArgumentException();
        }

        if (!isCorrectRange(lottoNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCorrectRange(String lottoNumber) {
        return lottoNumber.chars().mapToObj(i -> (char) i)
                .collect(Collectors.toList())
                .stream().allMatch(lottoNumbers -> lottoNumbers < MAX_NUMBER && lottoNumbers > MIN_NUMBER);
    }

    private static boolean isisOverlap(String lottoNumber) {
        return lottoNumber.chars().filter(i -> (char) i == ',')
                .boxed()
                .collect(Collectors.toSet()).size() != LOTTO_NUMBER_SIZE;
    }
}
