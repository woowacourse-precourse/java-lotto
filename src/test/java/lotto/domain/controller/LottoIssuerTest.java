package lotto.domain.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoIssuerTest {

    LottoIssuer lottoIssuer = new LottoIssuer();
    int numberOfLottos = 8;
    List<Lotto> lottos;

    @BeforeEach
    void setLottos() {
        lottos = lottoIssuer.issueLottos(numberOfLottos);
    }

    @Test
    @DisplayName("로또발행 - 입력된 개수만큼 발행된다.")
    void issueLottosLottosCountTest() {
        assertThat(lottos.size()).isEqualTo(numberOfLottos);
    }

    @Test
    @DisplayName("로또발행 - 각각 6개의 숫자가 발행된다.")
    void issueLottosNumbersCountTest() {
        int a = 1;
        assertThat(a).isEqualTo(1);
        int lottoNumberCount = 6;

        lottos.forEach(l -> assertThat(l.getNumbers().size()).isEqualTo(lottoNumberCount));
    }


    @Test
    @DisplayName("로또발행 - 각 숫자는 1~45 범위에 해당한다.")
    void issueLottosRangeTest() {
        for (Lotto oneLotto : lottos) {
            List<Integer> numbers = oneLotto.getNumbers();
            numbers.forEach(n -> assertThat(checkRange(n)).isTrue());
        }
    }

    boolean checkRange(int number) {
        if (1 <= number && number <= 45) {
            return true;
        }

        return false;
    }

    @Test
    @DisplayName("로또발행 - 각 숫자는 중복되지 않는다.")
    void issueLottosDuplicatedTest() {
        for (Lotto oneLotto : lottos) {
            Set<Integer> checkDuplicate = new HashSet<>();

            List<Integer> numbers = oneLotto.getNumbers();
            numbers.forEach(n -> assertThat(checkDuplicate.add(n)).isTrue());
        }
    }
}
