package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BankTest {
    @Test
    void 보너스번호_2등() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto targetLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Bank bank = new Bank(lottoList, targetLotto, 1);
    }
}