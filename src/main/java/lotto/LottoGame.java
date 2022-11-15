package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;

    public void start() {
        int lottoAmount = getLottoAmount();
    }

    private int getLottoAmount(){
        int payment = getPayment();

        return (payment / TICKET_PRICE);
    }

    private int getPayment(){
        System.out.println("구입 금액을 입력해 주세요.");
        String payment = readLine();

        if(!isValidPayment(payment)){
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(payment);
    }

    private boolean isValidPayment(String payment){
        if(!isValidPaymentCharacter(payment) || !isValidPaymentScope(payment)) {
            return false;
        }

        return true;
    }

    private boolean isValidPaymentCharacter(String payment) {
        try{
            Integer.parseInt(payment);
        } catch(IllegalArgumentException illegalArgumentException){
            return false;
        }

        return true;
    }

    private boolean isValidPaymentScope(String payment) {
        return Integer.parseInt(payment) > 0;
    }
}
