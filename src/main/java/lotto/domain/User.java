package lotto.domain;

import java.util.List;

public class User {
    private final int payAmount;
    private List<List<Integer>> userLottoNumber;


    public User(int payAmount){
        this.payAmount = payAmount;
    }

    public void setUserLottoNumber(List<List<Integer>> userLottoNumber){
        this.userLottoNumber = userLottoNumber;
        System.out.println(userLottoNumber);
    }

    public Integer getUserPayAmount(){
        return payAmount;
    }
    public List<List<Integer>> getUserLottoNumber(){
        return this.userLottoNumber;
    }
}