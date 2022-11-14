package lotto;

import lotto.domain.Lotto;
import lotto.message.ErrorMessage;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {

    private LottoService lottoService;
    private LottoRepository lottoRepository;

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
    @DisplayName("당첨번호가 6자리가 아닐 시 관련된 메세지를 담은 예외를 발생시킨다.")
    void checkWinningNumber_About_Digit_Test() {
        String winningNumberInput = "1,3,5,6,7";
        assertThatThrownBy(() -> lottoService.checkWinningNumberInput(winningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_DIGIT_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("당첨번호가 숫자가 아닐 시 관련된 메세지를 담은 예외를 발생시킨다.")
    void checkWinningNumber_About_Numeric_Test() {
        String winningNumberInput = "a,b,c,d,e,f";
        assertThatThrownBy(() -> lottoService.checkWinningNumberInput(winningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_TYPE_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("당첨번호들 가운데 1~45 숫자가 아닌 경우가 존재할 때 관련된 메세지를 담은 예외를 발생시킨다.")
    void checkWinningNumber_About_Boundary_Test() {
        String winningNumberInput = "47,1,2,3,4,5";
        assertThatThrownBy(() -> lottoService.checkWinningNumberInput(winningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_BOUNDARY_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("당첨번호들 가운데 서로 중복된 숫자가 있을 시 관련된 메세지를 담은 예외를 발생시킨다.")
    void checkWinningNumber_About_Duplicated_Test() {
        String winningNumberInput = "3,3,1,2,4,5";
        assertThatThrownBy(() -> lottoService.checkWinningNumberInput(winningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_DUPLICATED_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닐 시 관련된 메세지를 담은 예외를 발생시킨다.")
    void check_BonusNumber_About_Numeric_Test() {
        String bonusNumber = "a";
        HashSet<Integer> winningNumbers = new HashSet<>();
        assertThatThrownBy(() -> lottoService.checkBonusNumberInput(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_TYPE_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아닐 시 관련된 메세지를 담은 예외를 발생시킨다.")
    void check_BonusNumber_About_Boundary_Test() {
        String bonusNumber = "47";
        HashSet<Integer> winningNumbers = new HashSet<>();
        assertThatThrownBy(() -> lottoService.checkBonusNumberInput(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_BOUNDARY_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호와 중복될 시 관련된 메세지를 담은 예외를 발생시킨다.")
    void check_BonusNumber_About_Duplicated_Test() {
        String bonusNumber = "1";
        HashSet<Integer> winningNumbers = new HashSet<>(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> lottoService.checkBonusNumberInput(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATED_ERROR.getErrorMessage());
    }
}
