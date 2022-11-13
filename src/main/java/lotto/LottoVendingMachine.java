package lotto;

public class LottoVendingMachine {

    public static int getLottoTickets(int purchaseAmount) {
        int lottoTickets = purchaseAmount / 1000;
        System.out.printf("\n%d개를 구매했습니다.\n", lottoTickets);
        return lottoTickets;
    }
}
