package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Message;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dealer {
    private Lotto lotto;
    private int bonusNumber;

    public void inputAnswerNumbers() {
        System.out.println(Message.INPUT_WIN_LOTTO_NUMBER);
        String numbers = Console.readLine();
        // 숫자와 쉼표 입력이 아니면 예외처리
        List<Integer> lottoNumber = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        // 쉼표 기준으로 6개 숫자가 아니면 예외처리
        // 1 ~ 45 범위의 숫자가 아닐 때 예외처리
        // 중복된 수가 있으면 예외처리
        lotto = new Lotto(lottoNumber);
    }
}
