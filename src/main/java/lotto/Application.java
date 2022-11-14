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
}
