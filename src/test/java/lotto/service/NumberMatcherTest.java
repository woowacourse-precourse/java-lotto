package lotto.service;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class NumberMatcherTest {
    private NumberMatcher numberMatcher;

    @BeforeEach
    void setUp() {
        numberMatcher = new NumberMatcher();
    }

    @DisplayName("모든 로또에 대하여 각각의 로또에서 당첨번호와 일치하는 숫자의 개수를 리스트로 반환하는 기능 테스트")
    @Test
    void numberMatchTest() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        List<Lotto> allLotto = new ArrayList<>();
        allLotto.add(lotto1);
        allLotto.add(lotto2);

        List<Integer> winningNum = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> resultList = List.of(6, 0); // lotto1 에서 일치하는 숫자의 개수가 6개, lotto2에서는 0개 이다.

        Assertions.assertThat(numberMatcher.matchedNums(allLotto, winningNum)).isEqualTo(resultList);
    }
}