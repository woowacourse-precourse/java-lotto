package lotto;

import lotto.exception.MyIllegalArgumentException;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BankTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함되었을 때 예외 처리하는지 확인한다.")
    void createBankByDuplicateNumber() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThatThrownBy(() -> new Bank(winLotto, 6))
                .isInstanceOf(MyIllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨자들의 수를 올바르게 계산하는지 확인한다.")
    void getPayResult() {
        List<Lotto> lottos = new ArrayList<Lotto>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7)); // 2등
        Lotto lotto3 = new Lotto(List.of(2, 3, 4, 5, 6, 7)); // 2등
        Lotto lotto4 = new Lotto(List.of(2, 3, 4, 5, 6, 8)); // 3등
        Lotto lotto5 = new Lotto(List.of(3, 4, 5, 6, 7, 8)); // 4등
        Lotto lotto6 = new Lotto(List.of(4, 5, 6, 7, 8, 9)); // 5등
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);
        lottos.add(lotto5);
        lottos.add(lotto6);

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bank bank = new Bank(winLotto, 7);
        long payResult = bank.getTotalMoney(lottos);
        Assertions.assertThat(payResult).isEqualTo(2061555000L);
    }
}
