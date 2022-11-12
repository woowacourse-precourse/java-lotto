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

    public void checkSameLottoNumber(List<Integer> lottonumber) {
        HashSet<Integer> setlottonumber = new HashSet<>(lottonumber);
        if(setlottonumber.size() != lottonumber.size()) {
            throw new IllegalArgumentException("[ERROR] 동일한 로또 번호가 입력되었습니다.");
        }
    }
}
