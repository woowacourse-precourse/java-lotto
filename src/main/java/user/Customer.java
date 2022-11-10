package user;

import store.Lotto;

import java.util.List;

public class Customer {
    private static final String UNIT_ERROR = "[ERROR] 올바른 단위가 아닙니다.";

    private List<Lotto> lotteries;
    private int pay;

    public Customer(int pay){
        validatePayUnit(pay);
        this.pay = pay;
    }

    private void validatePayUnit(int pay) {
        if(pay%1000 != 0){
            throw new IllegalArgumentException(UNIT_ERROR);
        }
    }

}
