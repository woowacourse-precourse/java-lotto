package lotto;

import lotto.domain.Lotto;
import lotto.message.ErrorMessage;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {

    private LottoService lottoService;
    private LottoRepository lottoRepository;

    @BeforeEach
    void init() {
        this.lottoService = new LottoService();
        this.lottoRepository = new LottoRepository();
    }

    @Test
    @DisplayName("로또 구매 횟수에 따라 로또 저장소에 해당 갯수 만큼 저장된다.")
    void pickAndSaveLottoTest() {
        lottoService.pickAndSaveLotto(5);
        List<Lotto> lottos = lottoRepository.findAll();
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("String이 콤마 단위로 구분되어 HashSet에 담긴다.")
    void changeStringToHashSetTest() {
        String winningNumberInput = "1,2,3,4,5,6";
        HashSet<Integer> winningNumber = lottoService.changeStringToHashSet(winningNumberInput);
        assertThat(winningNumber.size()).isEqualTo(6);
    }
}
