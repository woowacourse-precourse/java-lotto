package lotto.util;

import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_PER_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void validateLotto(List<Integer> numbers){
        validateInputLength(numbers);
        for (Integer number : numbers) {
            validateLottoNumberRange(number);
        }
        validateDuplicatedNumber(numbers);
    }

    public static void validateInputLength(List<Integer> numbers){
        if(numbers.size() != LOTTO_LENGTH){
            throw new IllegalArgumentException(InputView.LOTTO_LENGTH_ERROR);
        }
    }

    public static void validateLottoNumberRange(int number){
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(InputView.LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers){
        List<Integer> temp= new ArrayList<>();
        temp.add(numbers.get(0));
        for(int i=1;i<numbers.size();i++){
            int number = numbers.get(i);
            if(temp.contains(number))
                throw new IllegalArgumentException(InputView.LOTTO_DUPLICATE_ERROR);
            temp.add(number);
        }
    }

    public static void validatePurchaseAmount(int purchaseAmount){
        if(purchaseAmount < 0){
            throw new IllegalArgumentException(InputView.PURCHASE_AMOUNT_SCOPE_ERROR);
        }
        if(purchaseAmount % LOTTO_PER_PRICE !=0){
            throw new IllegalArgumentException(InputView.PURCHASE_AMOUNT_DIVIDED_ERROR);
        }
    }

    public static void validateInputFormat(String s){
        s = s.trim();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c<'0' || c>'9') throw new IllegalArgumentException(InputView.PURCHASE_FORMAT_ERROR);
        }
    }
}
