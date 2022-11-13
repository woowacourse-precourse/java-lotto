package lotto.service;

public class LottoService {

    public void buyLotto(String inputPayment){
        int payment = inputPaymentToNumber(inputPayment);
    }

    public int inputPaymentToNumber(String inputPayment){
        int payment;

        try {
            payment = Integer.parseInt(inputPayment);
            return payment;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
