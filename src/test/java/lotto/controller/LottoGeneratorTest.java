package lotto.controller;

import lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
}