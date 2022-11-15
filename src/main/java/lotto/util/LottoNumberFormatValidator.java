package lotto.util;

public class LottoNumberFormatValidator {
    public static int LOTTO_NUMBER_MIN = 1;
    public static int LOTTO_NUMBER_MAX = 45;

    public static int validateInteger(String inputMoney) {
        try{
            return Integer.parseInt(inputMoney);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 숫자 형식이어야 합니다.");
        }
    }

    public static void validateLottoNumberFormat(Integer number) {
        if ( number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호는 "+ LOTTO_NUMBER_MIN +"이상 " + LOTTO_NUMBER_MAX + "이하 이어야 합니다.");
        }
    }
}