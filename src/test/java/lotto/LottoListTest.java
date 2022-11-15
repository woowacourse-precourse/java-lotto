package lotto;

import Info.PrintGameInfo;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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

    @Test
    void 로또랜덤갯수생성_테스트() {
        assertThat(lottos.getLottoCount()).isEqualTo(BigInteger.valueOf(8L));
    }

    @Test
    void 로또리스트출력_테스트() {
        PrintGameInfo.lottoInfoList(lottos);
        assertThat(output()).contains(
                "[", "]"
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {7,9})
    void 보너스번호중복_테스트(int bonnus) {

        lottos.setWinningNumber(new ArrayList<>(List.of(1,2,3,4,5,6)));
        lottos.setBonnusNumber(bonnus);
        lottos.checkAllLotto();
        assertThat(lottos.getTotalMoney()).isEqualTo(0);

    }

    @ParameterizedTest
    @ValueSource(ints = {5000,6000,7000,8000,9000})
    void 이익률계산_테스트(int totalMoney) {
        lottos.setTotalMoney(totalMoney);
        assertThat(lottos.getProfit()).isLessThan(70).isGreaterThan(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
