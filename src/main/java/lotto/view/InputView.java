package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.InputMessage;
import lotto.utils.Validator;

public class InputView {
    private static final Validator validator = new Validator();
    public String inputUserMoney() {
        System.out.println(InputMessage.INPUT_MONEY);
        String input = Console.readLine();
        validator.isValidMoney(input);
        return input;
    }

    public List<Integer> inputLottoNumber() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBER);
        List<Integer> lottoNumbers = Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        validator.isValidLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    public int inputBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER);
        int input = Integer.parseInt(Console.readLine());
        return input;
    }
}
