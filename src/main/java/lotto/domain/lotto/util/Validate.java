package lotto.domain.lotto.util;

public class Validate {
    private static final String WARM = "[ERROR] ";
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final String WARM_INPUT_NUMBER_RANGE = WARM + START_RANGE + "~" + END_RANGE + " 사이의 수를 입력해 주세요";

    public static void validateLottoNumberRange(int lottoNumber) {
        if (lottoNumber < START_RANGE || END_RANGE < lottoNumber) {
            System.out.println(WARM_INPUT_NUMBER_RANGE);
            throw new IllegalArgumentException(WARM_INPUT_NUMBER_RANGE);
        }
    }
}
