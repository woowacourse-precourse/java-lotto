package lotto.player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.data.Lotto;

public class User {

    private final Lotto[] tickets;

    public User(int payment){
        validatePayment(payment);

        int ticketNum = payment/1000;
        Lotto[] tickets = new Lotto[ticketNum];
        List<Integer> random6Digit;
        for(int i = 0; i < ticketNum; i++){
            random6Digit = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets[i] = new Lotto(random6Digit);
        }

        this.tickets = tickets;
    }

    private void validatePayment(int payment){
        if(payment <= 0 || payment%1000 != 0)
            throw new IllegalArgumentException();
    }

    public int getTicketNum(){
        return this.tickets.length;
    }

    @Override
    public String toString() {
        String tickets = "";
        for(int i = 0; i < getTicketNum(); i++)
            tickets = tickets + this.tickets[i].toString() + System.lineSeparator();
        return tickets;
    }
}
