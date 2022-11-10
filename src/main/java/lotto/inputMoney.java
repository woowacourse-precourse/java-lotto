package lotto;

public class inputMoney {
    private final String money;

    public inputMoney(String money) {
        validate(money);
        this.money = money;
    }
    private void validate(String money){
        if(Integer.valueOf(money) % 1000 != 0) throw new IllegalArgumentException();
        if(money.replaceAll("[^0-9]]","").length() != money.length()) throw new IllegalArgumentException();
    }
}
