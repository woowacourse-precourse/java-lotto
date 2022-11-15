package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class TicketHandler {
    Map<Winnings, Integer> winningTickets = new LinkedHashMap<>();

    public TicketHandler() {
        this.winningTickets.put(Winnings.FifthPlace, 0);
        this.winningTickets.put(Winnings.FourthPlace, 0);
        this.winningTickets.put(Winnings.ThirdPlace, 0);
        this.winningTickets.put(Winnings.SecondPlace, 0);
        this.winningTickets.put(Winnings.FirstPlace, 0);
    }

    public List<Lotto> generateTickets() {
        int count = Application.getPurchaseAmount() / 1000;
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lotto.add(new Lotto(numbers));
        }
        return lotto;
    }

    public void compareTickets(List<Integer> winningNum, int bonusNum) {
        int count;
        List<Integer> temp = new ArrayList<>();
        for (Lotto ticket : Application.getLotto()) {
            temp.clear();
            temp.addAll(winningNum);
            temp.removeAll(ticket.getNumbers());
            count = temp.size();
            if (((count == 1) && !ticket.getNumbers().contains(bonusNum)) || (count >= 2)) {
                count++;
            }
            this.countTickets(count);
        }
    }

    public void countTickets(int count) {
        Winnings place;
        if (count <= 4) {
            place = Winnings.values()[count];
            this.winningTickets.put(place, this.winningTickets.get(place) + 1);
        }
        Application.setWinningTickets(this.winningTickets);
    }

    public double calcProfit(int winnings) {
        return ((double) winnings / Application.getPurchaseAmount()) * 100;
    }
}
