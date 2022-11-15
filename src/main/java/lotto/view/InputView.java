package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputBonusLottoValidator;
import lotto.util.InputLottoValidator;
import lotto.util.InputMoneyValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.InputView.Message.*;

public class InputView {

    enum Message {
        INPUT_MONEY("구입금액을 입력해 주세요."),
        INPUT_LOTTO("당첨 번호를 입력해 주세요."),
        INPUT_BONUS("보너스 번호를 입력해 주세요.");

        private String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static int inputMoney() {
        System.out.println(INPUT_MONEY.getMessage());

        String inputMoney = Console.readLine();

        validateInteger(inputMoney);
        InputMoneyValidator.validateInputMoney(inputMoney);
        int moneyInt = Integer.parseInt(inputMoney);
        return moneyInt;
    }

    private static int validateInteger(String inputMoney) {
        try{
            return Integer.parseInt(inputMoney);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 숫자 형식이어야 합니다.");
        }
    }

    public static List<Integer> inputLottoNumber() {
        System.out.println();
        System.out.println(INPUT_LOTTO.getMessage());

        String inputLottoNumbers = Console.readLine();
        InputLottoValidator.validateInputLotto(inputLottoNumbers);
        List<Integer> lottoNumbers = toIntegerList(inputLottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> toIntegerList(String inputLottoNumbers) {
        List<Integer> lottoNumbers = Arrays.stream(inputLottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return lottoNumbers;
    }

    public static int inputBonusNumber(List<Integer> lottoNumbers) {
        System.out.println();
        System.out.println(INPUT_BONUS.getMessage());

        String bonusLottoNumber = Console.readLine();
        InputBonusLottoValidator.validateInputBonusLotto(lottoNumbers, bonusLottoNumber);
        int bounsNumberInt = Integer.parseInt(bonusLottoNumber);
        return bounsNumberInt;
    }
}
