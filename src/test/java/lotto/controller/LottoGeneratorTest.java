package lotto.controller;

import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또 생성하기")
    void generateLotto() {
        List<Integer> lottoNumber = LottoGenerator.generateLottoNumber();
        System.out.println("lottoNumber = " + lottoNumber);
        assertThat(lottoNumber.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 여러개 생성하기")
    void generateManyLotto() {
        List<Lotto> lottos = LottoGenerator.generateUserLottoNumbers(6);
        for (Lotto lotto : lottos) {
            System.out.println("lotto.getLotto() = " + lotto.getLotto());
        }
        assertThat(lottos.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("구입 금액만큼 로또 생성")
    void generateLottoByPrice() {
        List<Lotto> lottos = LottoGenerator.startLottoGenerate("5000");
        for (Lotto lotto : lottos) {
            System.out.println("lotto.getLotto() = " + lotto.getLotto());
        }
        assertThat(lottos.size()).isEqualTo(Integer.parseInt("5000") / 1000);
    }

    @Test
    @DisplayName("당첨 로또 스플릿")
    void splitLotto() {
        Assertions.assertThat(LottoGenerator.splitTargetLotto("1,2,3,4,5,6"))
                .isEqualTo(new ArrayList<>(List.of(1,2,3,4,5,6)));
    }
}