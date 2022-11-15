package lotto;

import lotto.exception.MyIllegalArgumentException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함되었을 때 예외 처리하는지 확인한다.")
    void createBankByDuplicateNumber() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThatThrownBy(() -> new Bank(winLotto, 6))
                .isInstanceOf(MyIllegalArgumentException.class);
    }
}
