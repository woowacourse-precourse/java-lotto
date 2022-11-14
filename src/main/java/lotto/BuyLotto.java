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
    private void validate(String money) throws IllegalArgumentException{
        if(!money.equals(money.replaceAll("[^0-9]", ""))) {throw new IllegalArgumentException("문자가 포함되어 있습니다.");}
        if(Integer.valueOf(money) % 1000 != 0) {throw new IllegalArgumentException("1000원 이상의 금액을 입력해주세요");}
    }

}