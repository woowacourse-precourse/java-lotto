package controller;

import util.Constant;
import util.Error;

import java.util.HashSet;
import java.util.List;

public class InputValidator {

    public void checkDigitPrice(String lottoPurAmount) {
        for(int i=0; i<lottoPurAmount.length(); i++) {
            if(!Character.isDigit(lottoPurAmount.charAt(i))) {
                throw new IllegalArgumentException(Error.NUMBER.getErrorMsg());
            }
        }
    }

    public void checkDividePrice(Integer lottoPurAmount) {
        if(lottoPurAmount % Constant.DIVIDEPRICE != 0) {
            throw new IllegalArgumentException(Error.DIVIDE.getErrorMsg());
        }
    }

    public void checkWinNumber(List<Integer> lottoNumber) {
        checkNumberQuantity(lottoNumber);
        checkLottoNumberRange(lottoNumber);
    }

    public void checkNumberQuantity(List<Integer> lottoNumber) {
        HashSet<Integer> setlottonumber = new HashSet<>(lottoNumber);
        if(setlottonumber.size() != Constant.NUMBERQUANTITY) {
            throw new IllegalArgumentException(Error.SAMENUMBER.getErrorMsg());
        }
    }

    public void checkDigitNumber(String lottoNumber) {
        for(int i=0; i<lottoNumber.length(); i++) {
            if(!Character.isDigit(lottoNumber.charAt(i)) && lottoNumber.charAt(i) != ',') {
                throw new IllegalArgumentException(Error.WINNUMBER.getErrorMsg());
            }
        }
    }

    public void checkLottoNumberRange(List<Integer> lottoNumber) {
        for(int checkNum : lottoNumber) {
            if(!(checkNum >= Constant.MINLOTTOVALUE && checkNum <= Constant.MAXLOTTOVALUE)) {
                throw new IllegalArgumentException(Error.RANGE.getErrorMsg());
            }
        }
    }

    public void checkBonusNumber(String bonusNumber) {
        isDigitBonusNumber(bonusNumber);
        checkBonusNumberRange(bonusNumber);
    }

    public void isDigitBonusNumber(String bonusNumber) {
        for(int i=0; i<bonusNumber.length(); i++) {
            if(!Character.isDigit(bonusNumber.charAt(i))) {
                throw new IllegalArgumentException(Error.NUMBER.getErrorMsg());
            }
        }
    }

    public void checkBonusNumberRange(String bonusNumber) {
        if(Integer.parseInt(bonusNumber) > Constant.MAXLOTTOVALUE || Integer.parseInt(bonusNumber) < Constant.MINLOTTOVALUE) {
            throw new IllegalArgumentException(Error.RANGE.getErrorMsg());
        }
    }
}
