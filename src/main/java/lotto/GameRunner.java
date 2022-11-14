package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.mvc.controller.LottoGameController;
import lotto.mvc.util.LottoGameStatus;

public class GameRunner {

    private static final String DEFAULT_PLAYER_INPUT = "";
    private static final LottoGameController controller = new LottoGameController();

    public static void run(LottoGameStatus lottoGameStatus) {
        while (!lottoGameStatus.isExit()) {
            String playerInput = processPlayerInput(lottoGameStatus);
            lottoGameStatus = controller.process(lottoGameStatus, playerInput);
        }
    }

    private static String processPlayerInput(LottoGameStatus lottoGameStatus) {
        String playerInput = DEFAULT_PLAYER_INPUT;

        if (lottoGameStatus.isLogic()) {
            playerInput = Console.readLine();
        }
        return playerInput;
    }
}
