package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;



public class Lotto {
    private final List<Integer> Lotto_Numbers;

    public Lotto(List<Integer> Lotto_Numbers) {

        this.Lotto_Numbers = Lotto_Numbers;
        size_validate(Lotto_Numbers);

    }

    private void size_validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자 6개이어야 합니다.");
        }
        Set<Integer> numbers_to_set = new HashSet<Integer>(numbers);
        List<Integer> Deduplicated_Numbers = new ArrayList<Integer>(numbers_to_set);
        if (Deduplicated_Numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다른 숫자 6개이어야 합니다.");
        }

    }


    // TODO: 추가 기능 구현
}
