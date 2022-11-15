package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateRandomLottoTest {
    CreateRandomLotto createRandomLotto = new CreateRandomLotto();
    @DisplayName("로또 횟수에 맞게 랜던 번호를 잘 설정하는지에 대한 경우")
    @Test
    void randomLotto() {
        long count = 4;
        List<LottoPaper> test = createRandomLotto.randomLotto(count);
        assertThat(test.size()).isEqualTo(4);
    }
    @DisplayName("LottoPaper 안에 랜덤 번호가 로또 갯수 만큼, 오름차순으로 잘 설정되어있는지에 대한 경우")
    @Test
    void setRandomLotto(){
        long count = 4;
        List<LottoPaper> test = createRandomLotto.randomLotto(count);
        for (LottoPaper lottoPaper : test) {
            System.out.println(lottoPaper.lottoNumber);
        }
    }
    @DisplayName("LottoPaper가 오름차순으로 잘 설정되어있는지에 대한 경우")
    @Test
    void sortRandomLotto(){
        List<LottoPaper> test = createRandomLotto.randomLotto(1);
        for (LottoPaper lottoPaper : test) {
            for(int i = 0; i < lottoPaper.lottoNumber.size() - 1; i++) {
                if(lottoPaper.lottoNumber.get(i) > lottoPaper.lottoNumber.get(i + 1))
                    throw new IllegalArgumentException("오름차순 실행 안됌");
            }
        }
    }
}