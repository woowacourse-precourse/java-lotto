package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidUserInputException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Game {

    private User user;
    private Computer computer;

    private Lotto winningLotto;
    private int bonusNumber;

    public Game(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void enterWinningNumber() {
        String[] numbers = Console.readLine().split(",");

        // (1) ,을 기준으로 올바르게 입력하지 않았다면, InvalidUserInputException 오류 반환
        // (2) 1~45 숫자를 입력하지 않았다면, 6자리 숫자 검증에서 오류
        // 중복 검사까지 실시
        try {
            Lotto lotto = new Lotto(Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .filter(n -> 1 <= n)
                    .filter(n -> n <= 45)
                    .collect(Collectors.toList()));

            this.winningLotto = lotto;

        } catch(NumberFormatException e) {
            throw new InvalidUserInputException("올바른 형식으로 입력해 주세요.");
        }
    }


}
