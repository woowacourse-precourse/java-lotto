package lotto.domain;

import java.util.List;

public class User {
    private final int payAmount;
    private List<List<Integer>> userLottoNumber;


    public User(String payMent){
        int pay = validate(payMent);
        this.payAmount = pay;
    }

    private Integer validate(String payAmount){
        boolean isNumeric = payAmount.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isNumeric){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

        int returnPay = Integer.parseInt(payAmount);
        return returnPay;

    }
    public void setUserLottoNumber(List<List<Integer>> userLottoNumber){
        this.userLottoNumber = userLottoNumber;
    }

    public Integer getUserPayAmount(){
        return payAmount;
    }
    public List<List<Integer>> getUserLottoNumber(){
        return this.userLottoNumber;
    }
}