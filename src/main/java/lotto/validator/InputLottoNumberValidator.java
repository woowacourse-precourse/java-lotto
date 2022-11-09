package lotto.validator;


import java.util.stream.Collectors;

public class InputLottoNumberValidator {

    private static final String REGEX = "^([0-9]*,){5}[0-9]*$";

    public static void validate(String lottoNumbers) {
        if (!lottoNumbers.matches(REGEX)) {
            throw new IllegalArgumentException();
        }

        LottoValidator.validate(lottoNumbers.chars().filter(number -> (char) number == ',')
                .boxed()
                .collect(Collectors.toList()));
    }

}
