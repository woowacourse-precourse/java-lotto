package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    public void 로또_발행_오름차순_테스트(){
        Lotto lotto = lottoMachine.createLotto();
        List<Integer> numbers = lotto.getNumbers();

        Assertions.assertThat(numbers.get(0))
                .isLessThan(numbers.get(1));
        Assertions.assertThat(numbers.get(4))
                .isLessThan(numbers.get(5));
    }

    @Test
    public void 당첨번호_입력_테스트() {
        String input = "1,2,3,4,5,6";

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Assertions.assertThat(lottoMachine.checkWiningNumber(input))
                .isEqualTo(list);

        String wrongInput1 = "1,2,3,4,1,6";
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->
                        lottoMachine.checkWiningNumber(wrongInput1))
                .withMessage("[ERROR] 중복된 수를 입력하면 안됩니다.");

        String wrongInput2 = "1,2,3";
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->
                        lottoMachine.checkWiningNumber(wrongInput2))
                .withMessage("[ERROR] 6개의 수를 입력해야 합니다.");

        String wrongInput3 = "wrong,2,3,4,5,6";
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->
                        lottoMachine.checkWiningNumber(wrongInput3))
                .withMessage("[ERROR] 수를 입력해야 합니다.");

        String wrongInput4 = "1,2,3,4,5,1234";
        Assertions.assertThatIllegalArgumentException().isThrownBy(() ->
                        lottoMachine.checkWiningNumber(wrongInput4))
                .withMessage("[ERROR] 1 ~ 45 사이의 수를 입력해야 합니다.");
    }

}