package lotto.controller;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoMachineTest {
    @DisplayName("6자리 로또가 발행된다.")
    @Test
    void lottoPublish1() {
        Lotto lotto = LottoMachine.publishLotto();

        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("1~45 사이의 로또 번호가 발행된다.")
    @Test
    void lottoPublish2() {
        List<Integer> numbers = LottoMachine.publishLotto().getNumbers();

        for (Integer number : numbers) {
            assertThat(number >= 1 || number <= 45).isTrue();
        }
    }

    @RepeatedTest(value = 20, name = "중복된 번호가 발행되지 않는다.")
    void lottoPublish3() {
        Lotto lotto = LottoMachine.publishLotto();
        HashSet<Integer> integers = new HashSet<>(lotto.getNumbers());

        assertThat(integers.size()).isEqualTo(6);
    }


    @RepeatedTest(value = 20, name = "번호가 오름차순으로 정렬된다.")
    void lottoPublish4() {
        List<Integer> numbers = LottoMachine.publishLotto().getNumbers();

        int num = 0;
        for (Integer number : numbers) {
            assertThat(number > num).isTrue();
            num = number;
        }
    }
}