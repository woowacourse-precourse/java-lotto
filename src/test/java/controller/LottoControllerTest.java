package controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.BonusNumber;
import domain.Lotto;
import domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vo.LottoRanking;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest extends NsTest {

    LottoController lottoController = new LottoController();

    @DisplayName("사용자 입력 금액에 따른 로또 구입 갯수 출력 테스트")
    @Test
    public void createLottoCount() {
        //given
        String userInput = "8000";

        //when
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        int lottoCount = lottoController.buyLotto();

        //then
        assertThat(lottoCount).isEqualTo(8);
    }

    @DisplayName("로또 구입 갯수에 따른 로또 발행 갯수 테스트 ")
    @Test
    public void createLottoPublish() {
        //given
        int count = 8;

        //when
        ArrayList<Lotto> lottos = lottoController.publishLotto(count);

        //then
        assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("당첨 번호와 로또 번호 중 일치하는 숫자를 출력하는 테스트")
    @Test
    public void compareWinningNumberAndLottoNumber() {
        //given
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 3, 5, 7, 9, 11));

        //when
        int matchLottoNumber = lottoController.getWinningNumberScore(lottoNumbers, winningNumbers);

        //then
        assertThat(matchLottoNumber).isEqualTo(3);

    }

    @DisplayName("보너스 번호가 로또 번호 중 일치하는지 여부를 확인하는 테스트")
    @Test
    public void compareBonusNumberAndLottoNumber() {
        //given
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("6");

        //when
        boolean matchBonusNumber = lottoController.getBonusNumberScore(lottoNumbers, bonusNumber);

        //then
        assertThat(matchBonusNumber).isEqualTo(true);
    }

    @DisplayName("로또 발행 번호와 당첨번호, 보너스 번호를 비교하여 당첨 내역을 확인하는 테스트")
    @Test
    public void createLottoWinningList() {
        //given
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto lotto4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
        Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));

        ArrayList<Lotto> lottos = new ArrayList<>(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("7");

        //when
        HashMap<LottoRanking, Integer> winningList = lottoController.makeWinningList(lottos, winningNumbers, bonusNumber);

        //then
        assertThat(winningList.get(LottoRanking.FIRST)).isEqualTo(0);
        assertThat(winningList.get(LottoRanking.SECOND)).isEqualTo(0);
        assertThat(winningList.get(LottoRanking.THIRD)).isEqualTo(0);
        assertThat(winningList.get(LottoRanking.FOURTH)).isEqualTo(0);
        assertThat(winningList.get(LottoRanking.FIFTH)).isEqualTo(1);

    }
    @DisplayName("당첨 내역에 따른 상금 수익률 확인 테스트")
    @Test
    public void checkWinningMoney(){
        //given
        int lottoCount = 10;
        HashMap<LottoRanking, Integer> winningList = new HashMap<>();
        winningList.put(LottoRanking.FIRST,0);
        winningList.put(LottoRanking.SECOND,0);
        winningList.put(LottoRanking.THIRD,0);
        winningList.put(LottoRanking.FOURTH,1);
        winningList.put(LottoRanking.FIFTH,0);

        //when
        lottoController.printYield(lottoCount,winningList);

        //then
        assertThat(output()).contains("총 수익률은 500.0%입니다.");
    }

    @Override
    protected void runMain() {}
}