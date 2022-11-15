package lotto;

public class Application {
    public static void main(String[] args) {
        lottery();
    }

    static void lottery() {
        User customer = new User();
        WinningTicket winningTicket = new WinningTicket();
        Result result = new Result();

        customer.getLottoTickets();
        winningTicket.setNumbers();
        winningTicket.setBonusNumber();
        result.getResult(customer.lottoTickets, winningTicket);
        printProfitRate(result.prizeMoney, customer.purchasingAmount);
    }

    private static void printProfitRate(int prizeMoney, int purchasingAmount) {
        float profitRate = (float)prizeMoney / (float)purchasingAmount * 100;
        System.out.printf("총 수익률은 %.1f", profitRate);
        System.out.println("%입니다.");

    }
}
