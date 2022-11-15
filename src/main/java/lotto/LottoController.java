package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.User;
import lotto.model.WinningLotto;
import lotto.model.vallidator.NumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final String SPLIT_REGEX = ",";

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        try {
            User user = getUser();
            outputView.printLottoNumbers(user.getLottos());

            WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers()), bonusNumber());
            Result result = new Result(winningLotto, user);
            outputView.printStatistics(result);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private User getUser() {
        inputView.printInputMoney();
        String input = Console.readLine();
        NumberValidator.validate(input);

        return new User(Integer.parseInt(input));
    }

    private List<Integer> winningNumbers() {
        inputView.printInputLotto();
        String input = Console.readLine();

        String[] numbers = input.split(SPLIT_REGEX);
        NumberValidator.validate(numbers);

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int bonusNumber() {
        inputView.printInputBonus();
        String input = Console.readLine();
        NumberValidator.validate(input);

        return Integer.parseInt(input);
    }
}
