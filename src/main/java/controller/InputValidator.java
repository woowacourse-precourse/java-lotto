package controller;

import util.Constant;

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
}
