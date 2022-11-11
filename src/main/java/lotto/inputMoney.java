package lotto;

public class inputMoney {
    private final String money;

    public inputMoney(String money) {
        validate(money);
        this.money = money;
    }
    private int buyLotto(){
        return Integer.valueOf(money) / 1000;
    }
    public int buyLottoprint(){
        System.out.println(buyLotto()+"개를 구매했습니다.");
        return buyLotto();
    }
    private void validate(String money){
        if(Integer.valueOf(money) % 1000 != 0) throw new IllegalArgumentException();
        if(money.replaceAll("[^0-9]]","").length() != money.length()) throw new IllegalArgumentException();
    }
}