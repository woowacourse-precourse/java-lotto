package lotto.service;

public class LottoService {

    final static int LOTTO_PAYMENT = 1000;

    public void buyLotto(String inputPayment){
        int payment = inputPaymentToNumber(inputPayment);
        checkPaymentUnits(payment);
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

    public void checkPaymentUnits(int payment) {
        if(payment % LOTTO_PAYMENT != 0){
            throw new IllegalArgumentException();
        }
    }
}
