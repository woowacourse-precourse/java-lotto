package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoPurchaseServiceTest {

  private LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();

  @Test
  void 로또구매시_입력한금액이2030일경우_단위가맞지않아_실패() throws Exception {
    int givenMoney = 2030;

    assertThatThrownBy(() -> lottoPurchaseService.purchase(givenMoney))
        .isInstanceOf(IllegalArgumentException.class);
  }


  @Test
  void 정상적으로_구매시_로또_리스트가_리턴된다(){
    int givenMoney = 2000;

    List<Lotto> result = lottoPurchaseService.purchase(givenMoney);

    assertThat(result.size()).isEqualTo(2);
  }
}