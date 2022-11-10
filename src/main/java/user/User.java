package user;

import lotto.Lotto;

import java.util.List;

public class User {
    private final boolean NOT_VALID = false;
    private final int BASE_MONEY = 1000;
    private List<Lotto> lottos = null;
    private int seedMoney = 0;
    private int prizeMoney = 0;

    public User(int money) {
        if (isMoneyNumeric(money) == NOT_VALID) {
            throw new IllegalArgumentException();
        }
        if (isMoneyThousandMultiple(money) == NOT_VALID) {
            throw new IllegalArgumentException();
        }
        this.seedMoney = money;
    }

    private boolean isMoneyNumeric(int money) {
        if (isMoneyNotNull(money) == NOT_VALID) {
            throw new IllegalArgumentException();
        }
        if (isMoneyPositive(money) == NOT_VALID) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean isMoneyNotNull(Integer money) {
        return !money.equals(null);
    }

    private boolean isMoneyPositive(int money) {
        return money > 0;
    }

    private boolean isMoneyThousandMultiple(int money) {
        return (money % BASE_MONEY == 0) && (money / BASE_MONEY > 0);
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setPrizeMoney(int prizeMoney) {
        if (isMoneyNumeric(prizeMoney) == NOT_VALID) {
            throw new IllegalArgumentException();
        }
        this.prizeMoney = prizeMoney;
    }
    public String getRatio(){
        isMoneyNumeric(seedMoney);
        isMoneyNumeric(prizeMoney);
        return String.format("%.2f",(double)prizeMoney/(double)seedMoney);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
