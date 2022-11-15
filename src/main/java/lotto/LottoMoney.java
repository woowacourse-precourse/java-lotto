package lotto;

import static java.lang.Integer.parseInt;

public class LottoMoney {
    public static final int LOTTO_PRICE = 1000;

    private static final String VALID_INPUT_NOT_NUMBER = "[ERROR] 숫자가 아닌 문자를 입력했습니다.";
    private static final String VALID_UNDER_MINIMUM_PRICE = "[ERROR] 최소 금액보다 낮은 가격을 입력했습니다.";
    private static final String VALID_NOT_MULTIPLIES_PRICE = "[ERROR] 로또 개당 가격의 배수를 입력해야 합니다.";
    private int money;

    public LottoMoney(String money){
        validate(money);
        this.money = parseInt(money);
    }
    public int changeToLottoCount() {
        return money / LOTTO_PRICE;
    }
    private void validate(String inputMoney){
        validInputNotNumber(inputMoney);
        validUnderMinimumPrice(inputMoney);
        validNotMultipliesPrice(inputMoney);
    }
    private void validInputNotNumber(String inputMoney) {
        try {
            parseInt(inputMoney);
        } catch (Exception ex) {
            throw new IllegalArgumentException(VALID_INPUT_NOT_NUMBER);
        }
    }

    private void validUnderMinimumPrice(String inputMoney) {
        if (parseInt(inputMoney) < LottoMoney.LOTTO_PRICE){
            throw new IllegalArgumentException(VALID_UNDER_MINIMUM_PRICE);
        }
    }
    private void validNotMultipliesPrice(String inputMoney){
        if(parseInt(inputMoney) % LottoMoney.LOTTO_PRICE != 0){
            throw new IllegalArgumentException(VALID_NOT_MULTIPLIES_PRICE);
        }
    }

    public int getMoney() {
        return money;
    }
}
