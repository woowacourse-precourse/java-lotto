package lotto.player;

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
            System.out.print("[ERROR] 구입금액을 정수형 데이터로 변환할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
    private void validate(int payment){
        if(payment <= 0 || payment%1000 != 0)
        {
            System.out.print("[ERROR] 구입금액은 0보다 크고 1000으로 나누어 떨어져야합니다.");
            throw new IllegalArgumentException();
        }
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
