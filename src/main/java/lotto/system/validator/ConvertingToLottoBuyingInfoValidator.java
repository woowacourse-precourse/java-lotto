package lotto.system.validator;

import lotto.vo.LottoInfo;

public class ConvertingToLottoBuyingInfoValidator {
    public static final String NOT_NATURAL_NUMBER_MESSAGE = "자연수값만 입력해야 합니다.";
    public static final String LOWER_THEN_MIN_VALUE_MESSAGE = "로또를 최소 1장 이상 살 수 있는 금액을 입력해야 합니다.";
    public static final String NOT_DIVIDED_VALUE_MESSAGE
            = String.format("로또의 금액인 %d원으로 나누어 떨어지는 금액을 입력해야 합니다.", LottoInfo.LOTTO_PRICE);
    public static final String ONLY_NATURAL_NUMBER_AND_COMMA_REGEX = "^[\\d,]+$";

    public static void validate(String target) {
        isOnlyNaturalNumberWithComma(target);
        validate(Integer.parseInt(removeCommaFrom(target)));
    }

    public static void validate(int target) {
        isMoreThanLottoPrice(target);
        isDividedInLottoPrice(target);
    }

    private static String removeCommaFrom(String target) {
        return target.replaceAll(",", "");
    }

    private static void isOnlyNaturalNumberWithComma(String target) {
        if (!target.matches(ONLY_NATURAL_NUMBER_AND_COMMA_REGEX)) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_MESSAGE);
        }
    }

    private static void isMoreThanLottoPrice(Integer target) {
        if (target < LottoInfo.LOTTO_PRICE) {
            throw new IllegalArgumentException(LOWER_THEN_MIN_VALUE_MESSAGE);
        }
    }

    private static void isDividedInLottoPrice(Integer target) {
        if (target % LottoInfo.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_VALUE_MESSAGE);
        }
    }
}
