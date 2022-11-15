package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TicketNumbers {

    private final int tickets;
    static List<List<Integer>> allTicket = new ArrayList<>();

    public TicketNumbers(int tickets){
        this.tickets = tickets;
    }

    public List<List<Integer>> collectTickets(){
        for(int i=0; i<tickets; i++){
            List<Integer> numbers = makeTicketNumbers();
            allTicket.add(numbers);
        }
        return allTicket;
    }

    public List<Integer> makeTicketNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        checkSorted(numbers);
        return numbers;
    }

    private void checkSorted(List<Integer> numbers) {
        int before = numbers.get(0);
        for(int i=1; i<6; i++){
            Integer after = numbers.get(i);
            if(before > after){
                Collections.sort(numbers);
            }
            before = after;
        }
    }

    public void showTickets(){
        for(int i=0; i<tickets; i++){
            System.out.println(allTicket.get(i));
        }
    }

}
