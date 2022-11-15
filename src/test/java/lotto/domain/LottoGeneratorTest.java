package lotto.domain;

import lotto.config.LottoConfig;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    private static LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void generateLotto_돈있는만큼_로또생성() {
        int money = 10000;
        List<Lotto> lottos = lottoGenerator.generateLotto(money);

        assertThat(lottos.size()).isEqualTo(money / LottoConfig.PRICE);
    }

    @Test
    void generateLotto_돈이_마이너스_예외() {
        assertThatThrownBy(()->{
            int money = -100;
            List<Lotto> lottos = lottoGenerator.generateLotto(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateLotto_돈이_없으면_예외() {
        assertThatThrownBy(()->{
            int money = 900;
            List<Lotto> lottos = lottoGenerator.generateLotto(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateLotto_돈이_천원단위가_아니라면_예외() {
        assertThatThrownBy(()->{
            int money = 1100;
            List<Lotto> lottos = lottoGenerator.generateLotto(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateLotto_최대치보다_많이_사면_예외() {
        assertThatThrownBy(()->{
            int money = LottoConfig.BUY_MAX_PRICE+1000;
            List<Lotto> lottos = lottoGenerator.generateLotto(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}