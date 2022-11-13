package lotto.service;

public class LottoService {

    final static int LOTTO_PAYMENT = 1000;

    public int buyLotto(String inputPayment){
        int payment = inputPaymentToNumber(inputPayment);
        int amount = getLottoAmount(payment);
        return amount;
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

    public int getLottoAmount(int payment) {
        if(payment % LOTTO_PAYMENT != 0){
            throw new IllegalArgumentException();
        }
        return payment/LOTTO_PAYMENT;
    }
}
