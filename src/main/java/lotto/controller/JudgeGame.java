package lotto.controller;

import lotto.model.GameDTO;
import lotto.model.Lotto;
import lotto.model.UserDTO;

import java.util.List;

public class JudgeGame {
    private UserDTO userDTO;
    private GameDTO gameDTO;

    public JudgeGame(UserDTO userDTO, GameDTO gameDTO) {
        this.userDTO = userDTO;
        this.gameDTO = gameDTO;
        gameDTO.setPurchaseAmount(userDTO.getPurchaseAmount());
        judgeGame();
    }
    private void judgeGame() {
        for (int i = 0; i < userDTO.getGameCount(); i++) {
            checkTypeWinning(userDTO.getGames().get(i));
        }
    }

    private void checkTypeWinning(Lotto lotto) {
        int count = checkWinCount(lotto);
        if (count == 3) {
            gameDTO.setWinningCount("THREE");
        }
        if (count == 4) {
            gameDTO.setWinningCount("FOUR");
        }
        if (count == 6) {
            gameDTO.setWinningCount("SIX");
        }
        if (count == 5) {
            setBonusWinningCheck(lotto);
        }
    }

    private void setBonusWinningCheck(Lotto lotto) {
        if (lotto.getLotto().contains(gameDTO.getBonusNumber())) {
            gameDTO.setWinningCount("FIVE_BONUS");
            return ;
        }
        gameDTO.setWinningCount("FIVE");
    }

    private int checkWinCount(Lotto lotto) {
        int count = 0;
        List<Integer> gameNumbers = lotto.getLotto();

        for (int i = 0; i < gameNumbers.size(); i++) {
            if (containCheckWinGame(gameNumbers.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    private boolean containCheckWinGame(int checkNumber) {
        List<Integer> winGame = gameDTO.getWinningNumber().getLotto();
        if (winGame.contains(checkNumber)) {
            return true;
        }
        return false;
    }
}

