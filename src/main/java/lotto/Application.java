package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();
        Customer customer = new Customer();

        lottoMachine.requestWantBuyAmountInputMessage();

        int wantBuyAmountInput = 0;

        try {
            wantBuyAmountInput = customer.wantBuyAmountInput();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000 단위 이상의 숫자를 입력해주세요.");
        }

        int canBuyAmount = lottoMachine.canBuyAmount(wantBuyAmountInput);

    }
}
