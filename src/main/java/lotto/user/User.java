package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.Lotto;

public class User {
    private final List<Lotto> lottos;

    public User() {
        lottos = new LinkedList<>();
    }

    public Integer getInput() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            UserValidator userValidator = new UserValidator();
            String input = Console.readLine();
            return userValidator.toInteger(input);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 값이 입력되지 않았습니다.");
        }
    }

    public void buyLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public void printLottos() {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
