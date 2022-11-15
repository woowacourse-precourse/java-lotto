package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ManagerTest {

    @DisplayName("1000원 이하가 입력될 떄")
    @Test
    void priceUnder1000() throws Exception {
        //Given
        Manager manager = new Manager();

        //When
        assertThatThrownBy(() -> manager.setPurchasePrice(950))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 안 나눠 떨어질 때")
    @Test
    void priceDoesNotDivided1000() throws Exception {
        //Given
        Manager manager = new Manager();

        //When
        assertThatThrownBy(() -> manager.setPurchasePrice(21312))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 발급")
    @Test
    void publishLottos() throws Exception {
        //Given
        Manager manager = new Manager();
        manager.setPurchasePrice(5000);

        //When
        List<List<Integer>> lottos = manager.publishPurchaseLottos();

        //Then
        assertThat(lottos.size()).isEqualTo(5);
        lottos.stream()
                .forEach(lotto -> {
                    System.out.println(lotto);
                    assertThat(lotto.size()).isEqualTo(6);
                });
    }

    @DisplayName("1~6개가 일치하는 입력의 경우")
    @Test
    void matchEachCount() throws Exception {
        //Given
        Manager manager = new Manager();
        manager.setPurchasePrice(6000);
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        lotto.setLottoBonusNumber(7);

        //When
        List<List<Integer>> purchased = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 7, 10),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 8, 9, 10, 11),
                List.of(1, 8, 9, 10, 11, 12),
                List.of(8, 9, 10, 11, 12, 13)
        );

        int[] matchCount = manager.findMatchCount(lotto, purchased);

        //Then
        assertThat(matchCount).isEqualTo(new int[]{1, 1, 1, 1, 1});
    }

    @DisplayName("3개 일치가 3 6개 일치가 3")
    @Test
    void matchDifferently() throws Exception {
        //Given
        Manager manager = new Manager();
        manager.setPurchasePrice(6000);
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        lotto.setLottoBonusNumber(7);

        //When
        List<List<Integer>> purchased = List.of(
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 8, 9, 10, 6),
                List.of(1, 8, 9, 10, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 7, 3, 4, 5, 6),
                List.of(7, 2, 3, 4, 5, 6)
        );

        int[] matchCount = manager.findMatchCount(lotto, purchased);

        //Then
        assertThat(matchCount).isEqualTo(new int[]{3, 0, 0, 0, 3});
    }

    @DisplayName("예시에 나온 수익율에 대한 테스트")
    @Test
    void calcWinningPrice() throws Exception {
        //Given
        Manager manager = new Manager();
        manager.setPurchasePrice(8000);

        //When
        double rate = manager.calculateYield(new int[]{1, 0, 0, 0, 0});

        //Then
        assertThat(rate).isEqualTo(62.5);
    }
}