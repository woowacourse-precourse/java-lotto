package controller;

import util.Constant;

import java.util.HashSet;
import java.util.List;

public class InputValidator {

    public void checkDigitPrice(String lottopuramount) {
        for(int i=0; i<lottopuramount.length(); i++) {
            if(!Character.isDigit(lottopuramount.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
            }
        }
    }

    public void checkDividePrice(Integer lottopuramount) {
        if(lottopuramount % Constant.DIVIDEPRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1000원 단위로 나누어 떨어지지 않습니다.");
        }
    }

    public void checkWinNumber(List<Integer> lottonumber) {
        checkNumberQuantity(lottonumber);
        checkLottoNumberRange(lottonumber);
    }

    public void checkNumberQuantity(List<Integer> lottonumber) {
        if(lottonumber.size() != Constant.LOTTONUMBERQUANTITY) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
        }
    }

    public void checkDigitNumber(String lottonumber) {
        for(int i=0; i<lottonumber.length(); i++) {
            if(!Character.isDigit(lottonumber.charAt(i)) && lottonumber.charAt(i) != ',') {
                throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호 입력입니다.");
            }
        }
    }

    public void checkLottoNumberRange(List<Integer> lottonumber) {
        for(int checklottonum : lottonumber) {
            if(!(checklottonum >= Constant.MINLOTTOVALUE && checklottonum <= Constant.MAXLOTTOVALUE)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다.");
            }
        }
    }

    public void checkBonusNumber(String bonusNumer) {
        isDigitBonusNumber(bonusNumer);
        checkBonusNumberRange(bonusNumer);
    }

    public void isDigitBonusNumber(String bonusNumber) {
        for(int i=0; i<bonusNumber.length(); i++) {
            if(!Character.isDigit(bonusNumber.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
            }
        }
    }

    public void checkBonusNumberRange(String bonusNumber) {
        if(Integer.parseInt(bonusNumber) > 45 || Integer.parseInt(bonusNumber) < 1) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }
}
