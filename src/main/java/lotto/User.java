package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class User {

    Lotto[] tickets;

    User(int payment){
        validatePayment(payment);

        int ticketNum = payment/1000;
        tickets = new Lotto[ticketNum];

        List<Integer> random6Digit;
        for(int i = 0; i < ticketNum; i++){
            random6Digit = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets[i] = new Lotto(random6Digit);
        }
    }

    public static void validatePayment(int payment){
        if(payment <= 0 || payment%1000 != 0)
            throw new IllegalArgumentException();
    }
}
