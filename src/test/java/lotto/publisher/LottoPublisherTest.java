package lotto.publisher;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPublisherTest {

    @DisplayName("발행된 로또는 저장소에 저장된다.")
    @Test
    void lottoStorageTest() {
        Lotto lotto = new LottoPublisher().publishLotto();

        int count = 0;

        for (Lotto i : LottoStorage.getAllLottos()) {
            if (i == lotto) {
                count++;
            }
        }

        assertThat(count).isEqualTo(1);
    }

    @DisplayName("발행된 로또는 오름차순으로 번호가 정렬된다.")
    @Test
    void lottoNaturalOrderTest() {
        Lotto lotto = new LottoPublisher().publishLotto();

        assertThat(lotto.getNumbers()).isSortedAccordingTo(Comparator.naturalOrder());

    }
}