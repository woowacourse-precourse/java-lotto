package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoListTest extends NsTest{
    static LottoList lottos;
    @BeforeAll
    static void createLottoList() {
        lottos = new LottoList(new BigInteger("8000"));
    }

    @ParameterizedTest
    @ValueSource(ints = {7,9})
    void 보너스번호중복_테스트(int bonnus) {
        lottos.setWinningLotto(new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6))));
        lottos.setBonnusNumber(bonnus);
        lottos.checkAllLotto();
        assertThat(lottos.getTotalMoney()).isEqualTo(0);

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
