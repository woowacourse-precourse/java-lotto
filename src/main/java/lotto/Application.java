package lotto;

public class Application {
    public static void main(String[] args) {
        LotterySeller lotterySeller = new LotterySeller();
        lotterySeller.sellLotto();
        System.out.println(lotterySeller.soldLotto);
    }
}
