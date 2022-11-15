package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private int money;
    private List<Integer> lotto;
    private int bonus;

    public User(int money, List<Integer> lotto, int bonus) {
        validateMoney(money);
        validateLottoLength(lotto);
        validateRange(lotto);
        validateRange(bonus);
        validateDuplicate(lotto, bonus);

        this.money = money;
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 돈이 1000원 단위가 아닙니다.");
        }
    }

    private void validateLottoLength(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해주세요.");
        }
    }

    private void validateRange(List<Integer> lotto) {
        for (Integer integer : lotto) {
            if (integer > 45 || integer < 1) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이 숫자를 입력해주세요.");
            }
        }
    }

    private void validateRange(int bonus) {
        if (bonus > 45 || bonus < 1) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이 숫자를 입력해주세요.");
        }
    }

    private void validateDuplicate(List<Integer> lotto, int bonus) {
        for (Integer integer : lotto) {
            if (integer.equals(bonus)) {
                throw new IllegalArgumentException("[ERROR] 사용자 로또 번호와 겹치지 않는 숫자를 입력해주세요.");
            }
        }
    }
}