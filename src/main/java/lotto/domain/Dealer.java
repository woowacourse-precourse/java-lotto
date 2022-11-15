package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Message;
import lotto.validate.DealerValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dealer {
    private Lotto lotto;
    private int bonusNumber;

    public void inputAnswerNumbers() {
        System.out.println(Message.INPUT_WIN_LOTTO_NUMBER);
        String numbers = Console.readLine();
        DealerValidator.validAnswerNumber(numbers);
        List<Integer> lottoNumber = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        lotto = new Lotto(lottoNumber);
    }
}
