package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    void sort() {
        //given
        Lotto lotto = new Lotto(new ArrayList<>(List.of(4, 23, 5, 43, 1, 35)));

        //when
        lotto.sort();

        //then
        assertThat(lotto.getList()).isEqualTo(List.of(1, 4, 5, 23, 35, 43));
    }

    @Test
    void getList() {
        //given
        Lotto lotto = new Lotto(new ArrayList<>(List.of(4, 23, 5, 43, 1, 35)));

        //when
        List<Integer> list = lotto.getList();

        //then
        assertThat(list).isEqualTo(List.of(4, 23, 5, 43, 1, 35));
    }

    @Test
    void check_bonus() {
        //given
        int bonus = 3;
        Lotto buy_numbers = new Lotto(new ArrayList<>(List.of(4, 23, 5, 43, 1, 35)));

        //when
        boolean haveBonus = Lotto.check_bonus(buy_numbers, bonus);

        //then
        assertThat(haveBonus).isEqualTo(false);
    }

    @Test
    void check_win() {
        //given
        List<Integer> win_numbers = new ArrayList<>(List.of(1, 3, 5, 8, 9, 10));
        Lotto buy_numbers = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));

        //when
        int cnt = Lotto.check_win(win_numbers, buy_numbers);

        //then
        assertThat(cnt).isEqualTo(3);
    }

    @Test
    void check_profit() {
        //given
        int[] statistics = {1, 2, 3, 0, 0};
        int[] statistics2 = {0, 0, 0, 0, 1};

        //when
        double total = Lotto.check_profit(statistics, 0);
        double total2 = Lotto.check_profit(statistics2, 0);

        //then
        assertThat(total).isEqualTo(4_605_000.0);
        assertThat(total2).isEqualTo(2_000_000_000);
    }

    @Test
    void check_input_validate() {
        assertThatThrownBy(() -> Lotto.check_input_validate("woowacourse"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void set_statistics() {
        //given
        int[] statistics = {0, 0, 0, 0, 0};
        int bonus = 8;
        List<Integer> win_numbers = new ArrayList<>(List.of(1, 2, 3, 4, 6, 10));

        List<Lotto> buy_lists = new ArrayList<>();
        buy_lists.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 6, 7))));
        buy_lists.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 7, 8))));
        buy_lists.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 6, 10))));
        buy_lists.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 6, 8))));
        buy_lists.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 6, 7))));

        //when
        int[] statistics2 = Lotto.set_statistics(buy_lists, bonus, win_numbers, statistics);

        //then
        assertThat(statistics2).isEqualTo(new int[]{0, 1, 2, 1, 1});
    }

    @Test
    void 예외_테스트_구입금액이_숫자가_아닐때() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 예외_테스트_구입금액이_1000원_단위가_아닐때() {
        assertSimpleTest(() -> {
            runException("11100");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @Test
    void 당첨번호를_중복해서_입력했을때() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,6,6", "7");
                    assertThat(output()).contains("[ERROR]");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 당첨번호의_범위를_넘은_숫자를_입력했을때() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,48", "7");
                    assertThat(output()).contains("[ERROR]");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 당첨번호에_문자를_입력했을때() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "afdghdhhsdga", "7");
                    assertThat(output()).contains("[ERROR]");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 보너스번호에_문자를_입력했을때() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "ewrge");
                    assertThat(output()).contains("[ERROR]");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 보너스번호에_범위를_넘은_숫자를_입력했을때() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "157");
                    assertThat(output()).contains("[ERROR]");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}