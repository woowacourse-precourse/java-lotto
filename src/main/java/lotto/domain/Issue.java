package lotto.domain;

import lotto.Lotto;

import java.util.List;

public interface Issue {

    List<Lotto> createLotto(int amount);
}
