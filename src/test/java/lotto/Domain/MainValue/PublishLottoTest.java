package lotto.Domain.MainValue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PublishLottoTest {
    PublishLotto publishLotto = new PublishLotto(5);
    List<Set<Integer>> lottos = publishLotto.getPublishedLotto();

    @DisplayName("로또 발행 개수가 정확한지 테스트")
    @Test
    void createLottosSize() {
        assertThat(lottos.size())
                .as("로또 발행 개수")
                .isEqualTo(5);

    }

    @DisplayName("로또안의 숫자 개수가 정확한지 테스트")
    @Test
    void createLottoNumSize() {
        for(Set<Integer> lotto : lottos) {
        assertThat(lotto.size())
                .as("로또 안 숫자 개수")
                .isEqualTo(6);
        }

    }
}
