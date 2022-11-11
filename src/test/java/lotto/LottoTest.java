package lotto;

import exception.LottoExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomNumberLottoGenerator;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<Integer> list = List.of(1,2,3,4,5,6,7);

        assertThatThrownBy(() -> new Lotto(list).validateSize(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionType.NOT_MATCH_CNT.getErrorMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        List<Integer> list = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> new Lotto(list).validateDuplicate(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionType.NOT_UNIQUE_NUMBER.getErrorMessage());
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 1~45 범위 안에 없으면 예외가 발생한다.")
    @Test
    public void createLottoByRangeNumber() throws Exception{
        //given
        List<Integer> list1 = List.of(1, 2, 3, 4, 50, 5);
        List<Integer> list2 = List.of(-1, 0 ,4, 5, 6, 7);
        //when

        //then
        assertThatThrownBy(() -> new Lotto(list1).validateRange(list1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionType.NOT_MATCH_RANGE.getErrorMessage());

        assertThatThrownBy(() -> new Lotto(list2).validateRange(list2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionType.NOT_MATCH_RANGE.getErrorMessage());
    }

    @Test
    public void 로또생성() throws Exception{
        //given
        RandomNumberLottoGenerator generator = new RandomNumberLottoGenerator();
        Set<Integer> generate = generator.generate();
        List<Integer> lottoList = generator.convertSetToList(generate);

        Lotto lotto = new Lotto(lottoList);
        //when
        List<Integer> finalLotto = lotto.numbersAscending(lottoList);
        //then

        for(int num : finalLotto){
            System.out.printf(num + " ");
        }
    }
}
