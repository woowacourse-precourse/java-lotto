package lotto.Model;

public class Cash extends Money{
    private int validate(String cash){
        int result = 0;
        try {
            result = Integer.parseInt(cash);
        }catch (NumberFormatException numberFormatException){
            System.out.println("[ERROR] 현금은 숫자로만 입력이 되어야합니다.");
        }
        if(result % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 로또 구입 가격은 1000으로 나누어 떨어져야 합니다.");
        return result;
    }
    public Cash(String cash){
        this.setMoney(validate(cash));
    }
    public int getLottoCnt() {
        return this.getMoney() / 1000;
    }

}
