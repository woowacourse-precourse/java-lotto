package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 사용자_랜덤_로또_숫자_6개() {
        final Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 사용자_랜덤_로또_중복_확인() {
        final Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers().stream().distinct().count()).isEqualTo(6);
    }

    @Test
    void 당첨번호로또_6개_숫자() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호로또_중복_숫자() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호로또_범위밖_넘는숫자() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 46, 5);
        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호로또_범위밖_작은숫자() {
        List<Integer> numbers = Arrays.asList(1, -1, 3, 4, 46, 5);
        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_숫자_오름차순_정렬() {
        List<Integer> numbers = Arrays.asList(6, 5, 2, 1, 3, 4);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}