package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBot;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    LottoBot lottoBot = new LottoBot();
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

    @Test
    @DisplayName("로또 번호가 정렬되는지 확인하는 테스트")
    void checkSortedLottoNumber() throws NoSuchFieldException, IllegalAccessException {
        Lotto lotto = lottoBot.createLotto();

        List<Integer> numbers = getLottoNumbers(lotto);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        Assertions.assertThat(numbers).isEqualTo(sortedNumbers);
    }

    @Test
    @DisplayName("로또 1등을 제대로 판별하는지 확인하는 테스트")
    void check1stRankLottoTest() throws NoSuchFieldException, IllegalAccessException {
        Lotto lotto = lottoBot.createLotto();
        List<Integer> numbers = getLottoNumbers(lotto);
        List<String> lottoNumbers = changeToStrList(numbers);
        Assertions.assertThat(lotto.getRank(lottoNumbers, "0")).isEqualTo(0);
    }

    @Test
    @DisplayName("로또 2등을 제대로 판별하는지 확인하는 테스트")
    void check2ndRankLottoTest() throws NoSuchFieldException, IllegalAccessException {
        Lotto lotto = lottoBot.createLotto();
        List<Integer> numbers = getLottoNumbers(lotto);
        List<String> lottoNumbers = changeToStrList(numbers);

        //2등이 되기 위해 로또 번호를 1개 틀리게 하고 보너스 번호가 맞도록 하기 위한 처리
        String storedNumber = lottoNumbers.get(5);
        lottoNumbers.set(5, "0");

        Assertions.assertThat(lotto.getRank(lottoNumbers, storedNumber)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 3등을 제대로 판별하는지 확인하는 테스트")
    void check3rdRankLottoTest() throws NoSuchFieldException, IllegalAccessException {
        Lotto lotto = lottoBot.createLotto();
        List<Integer> numbers = getLottoNumbers(lotto);
        List<String> lottoNumbers = changeToStrList(numbers);

        //3등이 되기 위해 로또 번호를 1개 틀리게 하기 위한 처리
        lottoNumbers.set(5, "0");

        Assertions.assertThat(lotto.getRank(lottoNumbers, "0")).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 4등을 제대로 판별하는지 확인하는 테스트")
    void check4thRankLottoTest() throws NoSuchFieldException, IllegalAccessException {
        Lotto lotto = lottoBot.createLotto();
        List<Integer> numbers = getLottoNumbers(lotto);
        List<String> lottoNumbers = changeToStrList(numbers);

        //4등이 되기 위해 로또 번호를 2개 틀리게 하기 위한 처리
        lottoNumbers.set(4, "0");
        lottoNumbers.set(5, "0");

        Assertions.assertThat(lotto.getRank(lottoNumbers, "0")).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 5등을 제대로 판별하는지 확인하는 테스트")
    void check5thRankLottoTest() throws NoSuchFieldException, IllegalAccessException {
        Lotto lotto = lottoBot.createLotto();
        List<Integer> numbers = getLottoNumbers(lotto);
        List<String> lottoNumbers = changeToStrList(numbers);

        //5등이 되기 위해 로또 번호를 3개 틀리게 하기 위한 처리
        lottoNumbers.set(3, "0");
        lottoNumbers.set(4, "0");
        lottoNumbers.set(5, "0");

        Assertions.assertThat(lotto.getRank(lottoNumbers, "0")).isEqualTo(4);
    }

    private static List<Integer> getLottoNumbers(Lotto lotto) throws NoSuchFieldException, IllegalAccessException {
        Field field = lotto.getClass().getDeclaredField("numbers");
        field.setAccessible(true);
        return (List<Integer>) field.get(lotto);
    }

    private static List<String> changeToStrList(List<Integer> numbers) {
        List<String> strNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            strNumbers.add(String.valueOf(number));
        }

        return strNumbers;
    }

}
