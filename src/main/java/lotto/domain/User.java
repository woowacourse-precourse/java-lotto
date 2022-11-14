package lotto.domain;

public class User {
    private final LottoManager lottoManager = new LottoManager();
    private int price;


    public void start() {
        System.out.println("구입금액을 입력해 주세요.");
        price = lottoManager.inputPrice();
    }
}
