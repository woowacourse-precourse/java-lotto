package lotto;

import lotto.service.Seller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Seller seller = new Seller();
        seller.acceptMoney();
        seller.makeLottos();
        seller.makeCorrectNumber();
        seller.makeResult();
    }
}
