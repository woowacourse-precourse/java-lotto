package lotto;

import java.util.List;

public class Pay {

    private final String pay;

    public Pay(String pay) {
        validate(pay);
        this.pay = pay;
    }

    private void validate(String pay) {
        for (int i=0; i<pay.length(); i++){
            int value = pay.charAt(i);
            if(!(value >= 48 && value <= 57)) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }
}
