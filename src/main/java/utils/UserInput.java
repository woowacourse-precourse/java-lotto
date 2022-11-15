package utils;

import camp.nextstep.edu.missionutils.Console;
import model.Lotto;
import model.Game;

import java.util.List;

public class UserInput {
    private static Game game;
    private static UserInputValidator userInputValidator;

    public UserInput(Game game) {
        this.game = game;
        userInputValidator = new UserInputValidator(game);
    }

    public static void inputMoney() {
        String userInputMoney = Console.readLine();

        userInputValidator.validateInputIsNum(userInputMoney);
        userInputValidator.validateInputMoney(userInputMoney);

        int lottoCount = getLottoCount(userInputMoney);
        game.setPurchaseNumber(lottoCount);
    }

    public static int getLottoCount(String userInput) {
        int userInputMoney = Integer.parseInt(userInput);

        return userInputMoney / 1000;
    }

    public static void inputLottoNumber() {
        String userInputLottoNumbers = Console.readLine();

        userInputValidator.validateInputLottoNumbers(userInputLottoNumbers);
        List<Integer> lottoNumbers = userInputValidator.inputLottoNumberToList(userInputLottoNumbers);
        Lotto lotto = new Lotto(lottoNumbers);

        game.setLotto(lotto);
    }

    public static void inputBonusNumber() {
        String userInputBonusNumber = Console.readLine();

        userInputValidator.validateInputIsNum(userInputBonusNumber);
        userInputValidator.validateNumberRange(userInputBonusNumber);
        userInputValidator.validateDuplicateBonusNumber(userInputBonusNumber);

        game.setBonusNumber(Integer.parseInt(userInputBonusNumber));
    }


}
