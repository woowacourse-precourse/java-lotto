package lotto.view;

import lotto.model.GameDTO;
import lotto.model.Lotto;
import lotto.model.UserDTO;

public class Print {
    public void printGames(UserDTO userDTO) {
        System.out.println();
        System.out.println(userDTO.getGameCount() + PrintMassage.PURCHASE_LIST.message());
        for (Lotto lotto : userDTO.getGames()) {
            System.out.println(lotto.getLotto());
        }
    }

    public void printResult(GameDTO gameDTO) {
        System.out.println();
        System.out.println(PrintMassage.END_SENTENCE.message());
        System.out.println(PrintMassage.CORRECT_THREE.message() + gameDTO.getWinningCount()[0] +
                PrintMassage.COUNT.message());
        System.out.println(PrintMassage.CORRECT_FOUR.message() + gameDTO.getWinningCount()[1] +
                PrintMassage.COUNT.message());
        System.out.println(PrintMassage.CORRECT_FIVE.message() + gameDTO.getWinningCount()[2] +
                PrintMassage.COUNT.message());
        System.out.println(PrintMassage.CORRECT_FIVE_BONUS.message() + gameDTO.getWinningCount()[3] +
                PrintMassage.COUNT.message());
        System.out.println(PrintMassage.CORRECT_SIX.message() + gameDTO.getWinningCount()[4] +
                PrintMassage.COUNT.message());
        System.out.println(PrintMassage.ALL_RATIO.message() + gameDTO.getReturnOfRate() +
                PrintMassage.ALL_RATIO_SEC.message());
    }
}
