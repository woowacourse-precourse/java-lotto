package user;

import lotto.Lotto;
import java.util.List;

public class User {
    private final boolean NOT_VALID = false;
    private List<Lotto> lottos = null;
    private int seedMoney = 0;
    private int prizeMoney = 0;
    public User(int money){
        if(isMoneyValid() == NOT_VALID){
            throw new IllegalArgumentException();
        }
        this.seedMoney = money;
    }
    private boolean isMoneyValid(){
        if(isMoneyNotNull(seedMoney)==NOT_VALID){
            throw new IllegalArgumentException();
        }
        if(isMoneyPositive(seedMoney)==NOT_VALID){
            throw new IllegalArgumentException();
        }
        if(isMoneyThousandMultiple(seedMoney)==NOT_VALID){
            throw new IllegalArgumentException();
        }
        return true;
    }
    private boolean isMoneyNotNull(Integer money){
        return !money.equals(null);
    }
    private boolean isMoneyPositive(int money){
        return money > 0;
    }
    private boolean isMoneyThousandMultiple(int money){
        return (money % 1000 == 0) && (money / 1000 > 0);
    }
}
