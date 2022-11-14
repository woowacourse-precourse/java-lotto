package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchasePrice = 0;
        purchasePrice = LottoInterface.getPurchasePrice();
        System.out.println(purchasePrice);
    }
}
