package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoShop lottoShop = new LottoShop();
        Customer customer = new Customer();

        lottoShop.requestWantBuyAmountInputMessage();
        try {
            customer.wantBuyAmountInput();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000 단위 이상의 숫자를 입력해주세요.");
        }

    }
}
