package lotto.service;

import lotto.constant.ExceptionConstant;
import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LottoException {

    static public void exceptionLottoByDuplicatedNumber(List<Integer> numbers) throws IllegalArgumentException{
        HashSet<Integer> lottoSetUniqueNumber = new HashSet<Integer>(numbers);
        if (lottoSetUniqueNumber.size() != 6) {
            throw new IllegalArgumentException(LottoConstant.ERROR_MESSAGE + ExceptionConstant.DUPLICATED_LOTTO_NUMBERS);
        }
    }

    static public void exceptionBonusNumberByDuplicatedLotto(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException{
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoConstant.ERROR_MESSAGE + ExceptionConstant.DUPLICATED_BONUS_WITH_LOTTO);
        }
    }

    static public void exceptionLottoNumberOutOfRange(List<Integer> numbers) throws IllegalArgumentException{
        for (Integer lottoNumber : numbers) {
            if (lottoNumber > LottoConstant.LOTTO_MAX_RANGE || lottoNumber < LottoConstant.LOTTO_MIN_RANGE) {
                throw new IllegalArgumentException(LottoConstant.ERROR_MESSAGE + ExceptionConstant.INVALID_LOTTO_RANGE);
            }
        }
    }

    static public int exceptionInvalidBonusNumber(String bonusNumber) throws IllegalArgumentException{
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(LottoConstant.ERROR_MESSAGE + ExceptionConstant.INVALID_BONUS_RANGE);
        }
    }

    static public void exceptionBonusNumberOutOfRange(int bonusNumber) throws IllegalArgumentException{
        if (bonusNumber > LottoConstant.LOTTO_MAX_RANGE || bonusNumber < LottoConstant.LOTTO_MIN_RANGE) {
            throw new IllegalArgumentException(LottoConstant.ERROR_MESSAGE + ExceptionConstant.INVALID_BONUS_RANGE);
        }
    }

    static public int exceptionInvalidPurchasePrice(String purchasePrice){
        try {
            return Integer.parseInt(purchasePrice);
        } catch (Exception e) {
            throw new IllegalArgumentException(LottoConstant.ERROR_MESSAGE + ExceptionConstant.INVALID_PURCHASE_PRICE);
        }
    }

    static public void exceptionDividedIntoThousands(int purchasePrice) throws IllegalArgumentException{
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(LottoConstant.ERROR_MESSAGE + ExceptionConstant.INCORRECT_DIVIDED_PURCHASE_PRICE);
        }
    }

    static public String[] exceptionInvalidLottoNumber(String lottoNumber) throws IllegalArgumentException{
        try {
            return lottoNumber.split(",");
        } catch (NumberFormatException exception) {
            throw new IllegalStateException(LottoConstant.ERROR_MESSAGE + ExceptionConstant.INVALID_LOTTO_RANGE);
        }
    }
}
