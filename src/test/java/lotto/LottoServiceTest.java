package lotto;

import lotto.domain.Lotto;
import lotto.domain.LuckyNumber;
import lotto.message.ErrorMessage;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {

    private LottoService lottoService;
    private LottoRepository lottoRepository;

    void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @BeforeEach
    void init() {
        this.lottoService = new LottoService();
        this.lottoRepository = new LottoRepository();
    }

    @Test
    @DisplayName("로또 구매 횟수에 따라 로또 저장소에 해당 갯수 만큼 저장된다.")
    void pickAndSaveLottoTest() {
        lottoService.pickAndSaveLotto(5);
        List<Lotto> lottos = lottoRepository.findAll();
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("String이 콤마 단위로 구분되어 HashSet에 담긴다.")
    void changeStringToHashSetTest() {
        String winningNumberInput = "1,2,3,4,5,6";
        HashSet<Integer> winningNumber = lottoService.changeStringToHashSet(winningNumberInput);
        assertThat(winningNumber.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호와 보너스 번호를 입력받으면 LuckyNumber 객체에 정상적으로 담긴다.")
    void pickLuckyNumberTest() {
        //given
        provideInput("1,2,3,4,5,6\n7");
        //when
        LuckyNumber luckyNumber = lottoService.pickLuckyNumber();
        HashSet<Integer> winningNumbers = luckyNumber.getWinningNumbers();
        int bonusNumber = luckyNumber.getBonusNumber();
        //then
        assertThat(winningNumbers).containsExactly(1,2,3,4,5,6);
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("당첨번호 및 보너스 번호와 로또가 일치하는 갯수가 정상적으로 반환된다.")
    void calculate_Winning_And_Bonus_Count_Test() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        LuckyNumber luckyNumber = new LuckyNumber(new HashSet<>(List.of(1,2,3,4,5,45)), 6);
        //when
        int winningCount = lottoService.calculateWinningCount(lotto.getLottoNumbers(), luckyNumber);
        int bonusCount = lottoService.calculateBonusCount(lotto.getLottoNumbers(), luckyNumber);
        //then
        assertThat(winningCount).isEqualTo(5);
        assertThat(bonusCount).isEqualTo(1);
    }




}
