package domain;

import ui.UserInput;

import java.util.List;

public class LottoService {

    private final UserInput userInput;
    private final Result result;

    public LottoService(UserInput userInput, Result result) {
        this.userInput = userInput;
        this.result = result;
    }

    public Prize getResultOfLotto(List<Integer> userNumbers) {
        List<Integer> winningNumbers = InputConverter.getWinningNumbers(userInput.enterWinningLottoNumber());
        int bonusNumber = InputConverter.getNumber(userInput.enterBonusNumber());

        int matchingCount = result.countMatchingNumber(winningNumbers, userNumbers);
        boolean checkBonusNumber = false;
        if (matchingCount == 5) {
            checkBonusNumber = result.isMatchingBonusNumber(userNumbers, bonusNumber);
        }
        Rank rank = result.getRank(matchingCount, checkBonusNumber);
        return result.getPrize(rank);
    }
}
