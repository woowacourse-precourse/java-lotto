package lotto.Domain.MainValue;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class PublishLottoTest {
    SoftAssertions softAssertions = new SoftAssertions();
    PublishLotto publishLotto = new PublishLotto(5);
    List<Set<Integer>> lottos = publishLotto.getPublishedLotto();

    @DisplayName("로또 발행 개수가 정확한지 테스트")
    @Test
    void createLottosSize() {
        softAssertions.assertThat(lottos.size())
                .as("로또 발행 개수")
                .isEqualTo(5);
        softAssertions.assertAll();
    }

    @DisplayName("로또안의 숫자 개수가 정확한지 테스트")
    @Test
    void createLottoNumSize() {
        for(Set<Integer> lotto : lottos) {
        softAssertions.assertThat(lotto.size())
                .as("로또 안 숫자 개수")
                .isEqualTo(6);
        }
        softAssertions.assertAll();
    }
}
