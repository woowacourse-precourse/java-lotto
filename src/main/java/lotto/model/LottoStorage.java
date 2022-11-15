package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoStorage {

    private static List<List<Integer>> lottoTickets = new ArrayList<>();

    private static int numberOfTickets = 0;

    public static void setLottoTickets(List<List<Integer>> tickets) {
        lottoTickets = tickets;
    }
    public static void setNumberOfTickets(int numberOfTicket) { numberOfTickets = numberOfTicket; }

    public static List<List<Integer>> getLottoTickets() {
        return lottoTickets;
    }
    public static int getNumberOfTickets() { return numberOfTickets; }
}
