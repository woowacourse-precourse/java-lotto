package lotto.domain;

public class ValidatorProcessorImpl implements ValidatorProcessor{

    @Override
    public void validateMoney(Integer money, PriceEnum priceEnum) {
        if (money % priceEnum.getValue() != 0) {
            throw new IllegalArgumentException("금액 단위를 일치시켜야 합니다.");
        }
    }
}
