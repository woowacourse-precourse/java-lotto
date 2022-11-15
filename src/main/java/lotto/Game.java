package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
        }
    }

    private void start() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = readLine();
        ExceptionCase.checkInputMoney(inputMoney);

        LottoMachine game = new LottoMachine();
        List<List<Integer>> LottoPaper = game.makeBuyLottoPaper(inputMoney);
        Display.displayLottoPaper(LottoPaper);

        System.out.println("당첨 번호를 입력해 주세요");
        String winSixNumber = readLine();

        System.out.println("보너스 번호를 입력해 주세요");
        String bonusNumber = readLine();

        Lotto startGame = new Lotto(game.winSixNumber(winSixNumber));
        startGame.winSevenNumber(bonusNumber);
        startGame.totalRank(LottoPaper);

        Display.displayRank();
        Display.displayRate(inputMoney);
    }
}
