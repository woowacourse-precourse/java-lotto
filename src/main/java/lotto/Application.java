package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoGame newGame = new LottoGame();
            newGame.setMoneyToBuy(inputForMoney());
            newGame.buyLotto();
            outputTickets(newGame);
            newGame.setWinningNumber(inputWinningNumber());
            newGame.setBonusNumber(inputBonusNumber());
            newGame.setWinningCount();
            newGame.setEarnedMoney();
            outputWinningTickets(newGame);
            outputRevenueLotto(newGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /* ask for user */
    public static String inputForMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine().replace(" ", "");
    }

    public static String[] inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine().split(",");
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readLine().replace(" ", "");
    }

    /* print data */
    public static void outputTickets(LottoGame lottoGame) {
        List<Lotto> tickets = lottoGame.getPurchasedLottoTickets();
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getLottoNumbers());
        }
    }

    public static void outputWinningTickets(LottoGame lottoGame) {
        int[] winningCount = lottoGame.getWinningCount();
        System.out.println("3개 일치 (5,000원) - " + winningCount[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + winningCount[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningCount[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCount[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningCount[0] + "개");
    }

    public static void outputRevenueLotto(LottoGame lottoGame) {
        System.out.println("총 수익률은 " + String.format("%.1f", lottoGame.getRevenue()*100) + "%입니다.");
    }
}
