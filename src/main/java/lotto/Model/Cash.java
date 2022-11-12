package lotto.Model;

public class Cash {
    private int cash;

    public Cash(String cash){
        this.cash = validate(cash);
    }
    private int validate(String cash){
        int result = 0;
        try {
            result = Integer.parseInt(cash);
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("[ERROR] 현금은 숫자로만 입력이 되어야합니다.");
        }
        if(result % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 로또 구입 가격은 1000으로 나누어 떨어져야 합니다.");
        return result;
    }

    public int getCash() {
        return cash;
    }

    public int getLottoCnt() {
        return cash / 1000;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
