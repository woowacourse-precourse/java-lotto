package lotto.Controller;

import Utils.InputUtils;
import Utils.RandomUtils;
import lotto.Domain.Player;
import lotto.Domain.Rank;
import lotto.View.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerService {

    private Player player;

    public PlayerService(Player player) {
        this.player = player;
    }

    public void winningNumberService() throws IllegalArgumentException {
        getWinningNumber();
        getBonusNumber();
    }

    public void getWinningNumber() throws IllegalArgumentException {
        String winnerNumbers = InputView.requestWinnerNumber();
        isValidWinningNumber(winnerNumbers);
        List<String> numbers = isValidRangeNumber(winnerNumbers);
        List<Integer> lotto = numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        player.setWinningNumber(lotto);
    }

    public void getBonusNumber() {
        String bonusBall = InputView.requestBonusNumber();
        isValidBonusNumber(bonusBall, player.getWinningNumber());
        player.setBonusNumber(Integer.parseInt(bonusBall));
    }

    public void isValidWinningNumber(String input) {
        final String COMMA_ERROR_MESSAGE = "[ERROR] 번호는 쉼표로 구분해야 합니다.";

        if (!InputUtils.isInputSplitWithComma(input)) {
            throw new IllegalArgumentException(COMMA_ERROR_MESSAGE);
        }
    }

    public List<String> isValidRangeNumber(String input) {
        final String ERROR_MESSAGE = "[ERROR] 1~45 사이의 숫자를 입력해야 합니다.";
        List<String> playerInputs = InputUtils.splitPlayerInput(input);

        boolean isValid = playerInputs.stream()
                .allMatch(value -> InputUtils.isDigit(value) && InputUtils.isNumberInLottoRange(value));

        if (!isValid) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return playerInputs;
    }

    public void isValidBonusNumber(String bonusBall, List<Integer> lottoNumbers) {
        final String ERROR_MESSAGE = "[ERROR] 1~45 사이의 숫자를 입력해야 합니다.";
        final String UNIQUE_ERROR_MESSAGE = "[ERROR] 입력하신 당첨 번호와 중복됩니다.";

        if (!InputUtils.isDigit(bonusBall) || !InputUtils.isNumberInLottoRange(bonusBall)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        if (!RandomUtils.isUniqueBonusNumber(Integer.parseInt(bonusBall), lottoNumbers)) {
            throw new IllegalArgumentException(UNIQUE_ERROR_MESSAGE);
        }
    }
}