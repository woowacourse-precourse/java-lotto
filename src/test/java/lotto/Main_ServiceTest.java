package lotto;

import lotto.domain.Lotto;
import lotto.model.Main_Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Main_ServiceTest {

    @DisplayName("정해진 로또가격에 맞는 로또 개수가 반환이 안되면 예외 발생")
    @Test
    void 반환되는_로또개수_체크() {
        int a = new Main_Service().get_NumberOfLotto(14500);
        assertThat(a).isEqualTo(14);
    }

    @DisplayName("당첨번호와 랜덤로또번호가 겹쳐지는 것과 겹쳐지는 개수가 안맞으면 예외 발생")
    @Test
    void 당첨번호와_랜덤로또번호가_몇개가_겹치는지_확인() {
        List<Integer> eachLottoNumbers = List.of(1, 2, 3, 4);
        List<Integer> winNumbers = List.of(2, 3, 4, 5);
        int a = new Main_Service().count_MatchingNumbers(eachLottoNumbers, winNumbers);
        assertThat(a).isEqualTo(3);
    }

    @DisplayName("당첨 번호와 로또번호가 겹치 규칙에 따라 등수에 잘못된 개수가 입력시 예외 발생")
    @Test
    void 당첨번호와_랜덤로또번호들과_겹치는_몇등에_몇개씩_있는지_확인() {
        List<Lotto> all_Lotto = List.of(new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int[] result = new Main_Service().organize_Details(all_Lotto, winNumbers, bonusNumber);
        assertThat(result).isEqualTo(new int[]{1, 0, 0, 0, 0});
    }

    @DisplayName("당첨 번호와 로또번호가 겹치 규칙에 따라 등수에 잘못된 개수가 입력시 예외 발생")
    @Test
    void 당첨번호와_랜덤로또번호들과_겹치는_몇등에_몇개씩_있는지_확인2() {
        List<Lotto> all_Lotto = List.of(new Lotto(List.of(6, 5, 4, 3, 2, 1)),
                new Lotto(List.of(1, 2, 3, 16, 32, 38)),
                new Lotto(List.of(7, 11, 4, 5, 6, 44)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(6, 5, 4, 3, 2, 9)),
                new Lotto(List.of(6, 5, 7, 8, 9, 10)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int[] result = new Main_Service().organize_Details(all_Lotto, winNumbers, bonusNumber);
        assertThat(result).isEqualTo(new int[]{3, 0, 1, 2, 1});
    }

    @DisplayName("수익율이 정확하지 않을 시 예외 발생")
    @Test
    void 수익률_확인() {
        List<Lotto> all_Lotto = List.of(new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int[] numberOfWins = new Main_Service().organize_Details(all_Lotto, winNumbers, bonusNumber);
        String result = new Main_Service().get_Yield(numberOfWins, 8000);
        assertThat(result).isEqualTo("62.5%");
    }

    @DisplayName("수익율이 정확하지 않을 시 예외 발생")
    @Test
    void 수익률_확인2() {
        List<Lotto> all_Lotto = List.of(new Lotto(List.of(6, 5, 4, 3, 2, 1)),
                new Lotto(List.of(1, 2, 3, 16, 32, 38)),
                new Lotto(List.of(7, 11, 4, 5, 6, 44)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(6, 5, 4, 3, 2, 9)),
                new Lotto(List.of(6, 5, 7, 8, 9, 10)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int[] numberOfWins = new Main_Service().organize_Details(all_Lotto, winNumbers, bonusNumber);
        String result = new Main_Service().get_Yield(numberOfWins, 8000);
        assertThat(result).isEqualTo("25,768,937.5%");
    }
}
