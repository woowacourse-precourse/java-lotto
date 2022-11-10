package lotto;

import java.util.List;

public class User {

    List<Lotto> tickets;

    User(int payment){
        validatePayment(payment);
    }

    public static void validatePayment(int payment){
        if(payment <= 0 || payment%1000 != 0)
            throw new IllegalArgumentException();
    }
}
