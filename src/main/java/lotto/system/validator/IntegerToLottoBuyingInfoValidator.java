package lotto.system.validator;

import lotto.vo.LottoBuyingInfo;

public class IntegerToLottoBuyingInfoValidator implements Validator {
    public static final int LOTTO_PRICE = 1000;
    public static final String LOWER_THEN_MIN_VALUE_MESSAGE = "로또를 최소 1장 이상 살 수 있는 금액을 입력해야 합니다.";
    public static final String NOT_DIVIDED_VALUE_MESSAGE = "로또의 금액인 1,000원으로 나누어 떨어지는 금액을 입력해야 합니다.";

    @Override
    public boolean supports(Object target, Class<?> to) {
        return target.getClass() == Integer.class && to == LottoBuyingInfo.class;
    }

    @Override
    public void validate(Object target) {
        isMoreThanLottoPrice((int) target);
        isDividedInLottoPrice((int) target);
    }

    private void isMoreThanLottoPrice(Integer target) {
        if (target < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOWER_THEN_MIN_VALUE_MESSAGE);
        }
    }

    private void isDividedInLottoPrice(Integer target) {
        if (target % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_VALUE_MESSAGE);
        }
    }
}
