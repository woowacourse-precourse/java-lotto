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

    public void start() {
        inputAnswerNumbers();
        inputBonusNumber();
    }

    public void inputAnswerNumbers() {
        System.out.println(Message.INPUT_WIN_LOTTO_NUMBER);
        String numbers = Console.readLine();
        DealerValidator.validAnswerNumber(numbers);
        List<Integer> lottoNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        lotto = new Lotto(lottoNumbers);
    }

    public void inputBonusNumber() {
        System.out.println(Message.INPUT_BONUS_LOTTO_NUMBER);
        String number = Console.readLine();
        // 숫자 입력이 아닐 때 예외처리
        // 당첨 번호 숫자일 때 예외처리
        // 1 ~ 45 범위의 숫자가 아닐 때 예외처리
        bonusNumber = Integer.parseInt(number);
    }
}
