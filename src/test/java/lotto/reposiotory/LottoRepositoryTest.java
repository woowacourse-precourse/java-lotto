package lotto.reposiotory;

import lotto.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

class RepositoryTest {

    private static final Repository repo = Repository.createRepository();

    @AfterEach
    void remove(){
        repo.removeAll();
    }

    @Test
    void save() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        repo.save(lotto);
        assertThat(repo.findAll().get(0)).isEqualTo(lotto);
    }

    @Test
    void saveAll() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>(List.of(lotto));
        repo.saveAll(lottos);
        assertThat(repo.findAll().get(0)).isEqualTo(lotto);
    }

}