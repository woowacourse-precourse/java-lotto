package lotto.reposiotory;

import lotto.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRepositoryTest {

    private static final LottoRepository lottoRepo = LottoRepository.createRepository();
    private Lotto lotto;

    @AfterEach
    void remove(){
        lottoRepo.removeAll();
    }

    @BeforeEach
    private void saveLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        this.lotto=lotto;
        lottoRepo.save(lotto);
    }

    @Test
    void save() {
        assertThat(lottoRepo.findAll().get(0)).isEqualTo(lotto);
    }

    @Test
    void saveAll() {
        lottoRepo.removeAll();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>(List.of(lotto));
        lottoRepo.saveAll(lottos);
        assertThat(lottoRepo.findAll().get(0)).isEqualTo(lotto);
    }

    @Test
    void removeAll() {
        lottoRepo.removeAll();
        assertThat(lottoRepo.getSize()).isEqualTo(0);
    }

    @Test
    void findAll() {
        List<Lotto> lottos = lottoRepo.findAll();
        assertThat(lottos.get(0)).isEqualTo(lotto);
    }

    @Test
    void getSize() {
        assertThat(lottoRepo.getSize()).isEqualTo(1);
    }
}