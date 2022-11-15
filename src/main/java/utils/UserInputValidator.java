package utils;

import model.Game;
import model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserInputValidator {
    private static Game game;

    public UserInputValidator(Game game) {
        this.game = game;
    }

    public static void validateInputIsNum(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 혹은 형식에 맞게 입력해주세요.");
        }
    }

    public static void validateInputMoney(String userInput) {
        int userInputMoney = Integer.parseInt(userInput);

        if (userInputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 입력해주세요.");
        }
    }

    public static void validateInputLottoNumbers(String userInput) {
        StringTokenizer st = new StringTokenizer(userInput, ",");
        int tokenCount = st.countTokens();

        while (st.hasMoreTokens()) {
            validateInputIsNum(st.nextToken());
        }

        if (tokenCount != 6) {
            throw new IllegalArgumentException("[ERROR] 형식에 맞게 입력해주세요. 번호는 쉼표(,)를 기준으로 구분합니다.");
        }
    }

    public static List<Integer> inputLottoNumberToList(String userInput) {
        StringTokenizer st = new StringTokenizer(userInput, ",");
        List<Integer> lottoNumbers = new ArrayList<>();

        while (st.hasMoreTokens()) {
            lottoNumbers.add(Integer.parseInt(st.nextToken()));
        }

        return lottoNumbers;
    }

    public static void validateDuplicateBonusNumber(String userInput) {
        int userInputBonusNumber = Integer.parseInt(userInput);
        Lotto lotto = game.getLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        for (Integer lottoNumber : lottoNumbers) {
            if (lottoNumber == userInputBonusNumber) {
                throw new IllegalArgumentException("[ERROR] 당첨번호와 중복되지 않는 보너스번호를 입력해주세요.");
            }
        }
    }

    public static void validateNumberRange(String userInput) {
        int userInputNumber = Integer.parseInt(userInput);

        if (userInputNumber < 1 || userInputNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력해주세요.");
        }
    }
}
