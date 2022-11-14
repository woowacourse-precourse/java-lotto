package util;

import domain.WinningNumber;
import util.Constant;
import util.Error;

import java.util.ArrayList;
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
        HashSet<Integer> setLottoNumber = new HashSet<>(lottoNumber);
        if(setLottoNumber.size() != Constant.NUMBERQUANTITY) {
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

    public void checkBonusNumber(String bonusNumber, WinningNumber winningNumber) {
        isDigitBonusNumber(bonusNumber);
        checkBonusNumberRange(bonusNumber);
        checkSameNumber(bonusNumber,winningNumber);
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

    public void checkSameNumber(String bonusNumber, WinningNumber winningNumber) {
        List<Integer> remWinNum = new ArrayList<>(winningNumber.getWinNumbers());
        Integer remBonusNum = Integer.parseInt(bonusNumber);
        for(int i=0; i<remWinNum.size(); i++) {
            if(remBonusNum.equals(remWinNum.get(i))) {
                throw new IllegalArgumentException(Error.SAMEBONUSNUMBER.getErrorMsg());
            }
        }
    }
}
