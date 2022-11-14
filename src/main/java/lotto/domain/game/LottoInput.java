package lotto.domain.game;

import java.util.List;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.LottoNumberEnum;
import lotto.util.UserInput;

public class LottoInput {
    
    private static final String lottoNumberExceptionMessage =
            "당첨 번호는 " + LottoNumberEnum.START_NUMBER.getValue() + " ~ " + LottoNumberEnum.END_NUMBER.getValue()
                    + " 사이의 " + LottoNumberEnum.NUMBER_COUNT + "개의 수로 ',' 문자로 구분하여 입력해주세요. ex) 1,2,3,4,5,6";
    private static final String purchaseAmountExceptionMessage =
            "구입 금액은 " + LottoMachine.LOTTO_PRICE + "원 단위로 숫자만 입력 "
                    + "해주세요. ex) 17000";
    
    public static Integer getPurchaseAmount() {
        Integer purchaseAmount = UserInput.getNumberInput();
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }
    
    private static void validatePurchaseAmount(Integer amount) {
        if (amount == 0 || amount % LottoMachine.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(purchaseAmountExceptionMessage);
        }
    }
    
    public static List<Integer> getNormalNumbers() {
        List<Integer> splittingNumbers = UserInput.getSplittingNumberList(",");
        validateNumberSize(splittingNumbers);
        
        for (Integer number : splittingNumbers) {
            validateLottoNumber(number);
        }
        
        return splittingNumbers;
    }
    
    public static Integer getBonusNumber() throws IllegalArgumentException {
        Integer bonusNumberInput = UserInput.getNumberInput();
        validateLottoNumber(bonusNumberInput);
        return bonusNumberInput;
    }
    
    private static void validateNumberSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LottoNumberEnum.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(lottoNumberExceptionMessage);
        }
    }
    
    private static void validateLottoNumber(Integer number) throws IllegalArgumentException {
        if (number < LottoNumberEnum.START_NUMBER.getValue() || number > LottoNumberEnum.END_NUMBER.getValue()) {
            throw new IllegalArgumentException(lottoNumberExceptionMessage);
        }
    }
}
