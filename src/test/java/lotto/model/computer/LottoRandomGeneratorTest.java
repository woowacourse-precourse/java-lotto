package lotto.model.computer;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoRandomGeneratorTest {

    @Test
    void 난수가_생성되는지_100번_확인() {
        LottoRandomGenerator lottoRandomGenerator = new LottoRandomGenerator();
        long count;
        for (int i = 0; i < 100; i++) {
            count = lottoRandomGenerator.generateNumber(6).getNumbers().stream().distinct().count();
            Assertions.assertThat(count).isEqualTo(6);
        }
    }

}