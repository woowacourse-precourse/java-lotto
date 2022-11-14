package lotto.player;

import static lotto.util.Error.ERROR_OUT_OF_RANGE_PAYMENT;
import static lotto.util.Error.ERROR_PARSE_INT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.data.Lotto;

public class User {

    public final Lotto[] tickets;

    public User(String payment){
        int pay = tryParseInt(payment);
        validate(pay);

        int ticketNum = pay/1000;
        Lotto[] tickets = new Lotto[ticketNum];
        List<Integer> random6Digit;
        for(int i = 0; i < ticketNum; i++){
            random6Digit = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets[i] = new Lotto(random6Digit);
        }

        this.tickets = tickets;
    }
    private int tryParseInt(String payment){
        try{
            return Integer.parseInt(payment);
        }catch(Exception e){
            ERROR_PARSE_INT.generate();
        }
        return 0;
    }
    private void validate(int payment){
        if(payment <= 0 || payment%1000 != 0)
            ERROR_OUT_OF_RANGE_PAYMENT.generate();
    }

    public int getTicketNum(){
        return this.tickets.length;
    }

    @Override
    public String toString() {
        StringBuilder tickets = new StringBuilder();
        for(int i = 0; i < getTicketNum(); i++)
            tickets.append(this.tickets[i].toString()).append(System.lineSeparator());
        return tickets.toString();
    }
}
