package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoGameView {

    private static final String PERCENT = "%";

    private String purchaseAmount;
    private String raffleNumbers;
    private String bonusNumber;

    public void askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Console.readLine();
    }

    public void askRaffleNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        raffleNumbers = Console.readLine();
    }

    public void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Console.readLine();
    }

    public void noticeNumberOfTickets(int numberOfTickets) {
        System.out.printf("%d개를 구매했습니다.\n", numberOfTickets);
    }

    public void noticeRateOfRevenue(float rateOfRevenue) {
        System.out.printf("총 수익률은 %.1f%s입니다.", rateOfRevenue, PERCENT);
    }

    public void noticeLotteries(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void noticeReport(String winReport) {
        System.out.println(winReport);
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public String getRaffleNumbers() {
        return raffleNumbers;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }
}
