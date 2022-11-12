package lotto.util;

import static lotto.ui.ConsoleMessage.INVALID_INPUT_PRICE;

public class Validator {
    public static void validateLottoPrice(String lottoPrice){
        if (!isLottoPriceNumeric(lottoPrice)){
            throw new IllegalArgumentException(INVALID_INPUT_PRICE.toString());
        }
        if (!isLottoPriceMultiplesof1000(Integer.parseInt(lottoPrice))){
            throw new IllegalArgumentException(INVALID_INPUT_PRICE.toString());
        }
    }

    private static boolean isLottoPriceMultiplesof1000(int lottoPrice) {
        return (lottoPrice % 1000 == 0);
    }

    private static boolean isLottoPriceNumeric(String lottoPrice) {
        return lottoPrice.chars().allMatch(Character::isDigit);
    }
}
