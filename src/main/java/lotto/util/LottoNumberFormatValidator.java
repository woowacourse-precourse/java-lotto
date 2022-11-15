package lotto.util;

public class LottoNumberFormatValidator {

    public static int validateInteger(String inputMoney) {
        try{
            return Integer.parseInt(inputMoney);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 숫자 형식이어야 합니다.");
        }
    }
}