package service;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import repository.LottoRepository;
import view.OutputView;

import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoServiceTest {
    LottoService lottoService = new LottoService(new LottoRepository());

    @DisplayName("로또 발행 검사")
    @ParameterizedTest
    @CsvSource(value = {"11000,11", "5000,5", "1000,1"})
    public void 로또_발행_수량_확인(int purchaseAmount, int count) {
        lottoService.publishLotto(purchaseAmount);
        List<Lotto> publishedLotto = lottoService.getPublishedLotto();

        OutputView.noticePublishedLotto(publishedLotto);

        assertThat(publishedLotto.size()).isEqualTo(count);
    }

    @DisplayName("당첨 번호 입력 형식 검사")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "0,1,2,3,4,5", "1,45,32,", "1.2.3.7.4.9", "1,2,3,4,5,46", "1, 2, 3, 4, 5, 6"})
    public void 당첨_번호_입력_형식_예외(String numbers) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lottoService.saveWinningNumbers(numbers));
        assertThat(e.getMessage()).isEqualTo(Error.WINNING_NUMBERS_FORMAT.getText());
    }

    @DisplayName("당첨 번호 입력 중복 검사")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "13,12,17,23,45,12"})
    public void 당첨_번호_입력_중복_예외(String numbers) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lottoService.saveWinningNumbers(numbers));
        assertThat(e.getMessage()).isEqualTo(Error.WINNING_NUMBERS_INCLUDE_SAME_NUMBER.getText());
    }

    @DisplayName("보너스 번호 입력 형식 검사")
    @ParameterizedTest
    @ValueSource(strings = {"", "0", "46", "50", "1-5"})
    public void 보너스_번호_입력_형식_예외(String number) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lottoService.saveBonusNumber(number));
        assertThat(e.getMessage()).isEqualTo(Error.BONUS_NUMBER_FORMAT.getText());
    }

    @DisplayName("보너스 번호 입력 중복 검사")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10"})
    public void 보너스_번호_입력_중복_예외(String number) {
        String winningNumbers = "1,2,10,6,9,14";
        lottoService.saveWinningNumbers(winningNumbers);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lottoService.saveBonusNumber(number));
        assertThat(e.getMessage()).isEqualTo(Error.BONUS_NUMBER_IN_WINNING_NUMBER.getText());
    }

    @DisplayName("1등 당첨 검사")
    @Test
    public void 모두_일치_확인() {
        LottoRepository lottoRepository = new LottoRepository();
        lottoService = new LottoService(lottoRepository);

        Lotto publishedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoRepository.save(publishedLotto);
        lottoRepository.saveWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoRepository.saveBonusNumber(45);

        lottoService.saveWinners();
        EnumMap<Winner, Integer> winners = lottoService.getWinners();

        assertThat(winners.get(Winner.FIRST_PLACE)).isEqualTo(1);
    }

    @DisplayName("보너스 당첨 검사")
    @Test
    public void 보너스_당첨_확인() {
        LottoRepository lottoRepository = new LottoRepository();
        lottoService = new LottoService(lottoRepository);

        Lotto publishedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottoRepository.save(publishedLotto);
        lottoRepository.saveWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoRepository.saveBonusNumber(7);

        lottoService.saveWinners();
        EnumMap<Winner, Integer> winners = lottoService.getWinners();

        assertThat(winners.get(Winner.SECOND_PLACE)).isEqualTo(1);
    }
}
