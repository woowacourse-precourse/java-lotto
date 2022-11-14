package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TicketNumbers {

    private final int tickets;
    private final List<List<Integer>> allTicket = new ArrayList<>();

    public TicketNumbers(int tickets){
        this.tickets = tickets;
    }

    public List<List<Integer>> collectTickets(){
        for(int i=0; i<tickets; i++){
            List<Integer> numbers = makeTicketNumbers();
            allTicket.add(numbers);
        }
        System.out.println("allTicket = " + allTicket);
        return allTicket;
    }

    public List<Integer> makeTicketNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

}
