package lotto;

public class BuyLotto {
    private final String money;
    static String numberOfLottoPurchased = "%d개를 구매했습니다.%n";
    public BuyLotto(String money) {
        validate(money);
        this.money = money;
    }
    public int buyLotto(){
        return Integer.valueOf(money) / 1000;
    }
    public int buyLottoprint(){
        System.out.printf(numberOfLottoPurchased,buyLotto());
        return buyLotto();
    }
    private void validate(String money){
        if(Integer.valueOf(money) % 1000 != 0) throw new IllegalArgumentException("[ERROR]");
        if(money.replaceAll("[^0-9]]","").length() != money.length()) throw new IllegalArgumentException("[ERROR]");
    }

}