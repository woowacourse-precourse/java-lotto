package lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @Test
    @DisplayName("숫자가 아닐 경우 에러가 발생한다.")
    void 입력금액_숫자정규식_테스트(){
        assertThatThrownBy(() -> {
            command("1s00");
            Application.main(new String[]{
                    String.valueOf(new Input().getCash())
            });
        }).hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("1,000원 단위가 아닐 경우 에러가 발생한다.")
    void 입력금액단위_테스트(){
        assertThatThrownBy(() -> {
            command("1100");
            Application.main(new String[]{
                    String.valueOf(new Input().getCash())
            });
        }).hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("입력금액을 0을 넣을 시 에러가 발생한다.")
    void 입력금액_테스트(){
        assertThatThrownBy(() -> {
            command("0");
            Application.main(new String[]{
                    String.valueOf(new Input().getCash())
            });
        }).hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호 입력 시 숫자가 아닌 경우 에러가 발생한다.")
    void 당첨번호_숫자정규식_테스트(){
        assertThatThrownBy(() -> {
                command("1,2,3,4,5,j");
                Application.main(new String[]{
                        new Input().getWinningNumbers().toString()
                });
        }).hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("당첨 번호 입력 시 숫자가 범위를 벗어날 경우 에러가 발생한다.")
    void 당첨번호_숫자범위_테스트(){
        assertThatThrownBy(() -> {
            command("1,2,3,4,5,0");
            Application.main(new String[]{
                    new Input().getWinningNumbers().toString()
            });
        }).hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("보너스 입력 시 숫자가 아닌 경우 에러가 발생한다.")
    void 보너스입력_숫자정규식_테스트(){
        assertThatThrownBy(() -> {
            command("k");
            Application.main(new String[]{
                    String.valueOf(new Input().getBonusNumber(List.of(1, 2, 3, 4, 5,6)))
            });
        }).hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("보너스 입력 시 숫자가 범위를 벗어날 경우 에러가 발생한다.")
    void 보너스입력_숫자범위_테스트(){
        assertThatThrownBy(() -> {
            command("0");
            Application.main(new String[]{
                    String.valueOf(new Input().getBonusNumber(List.of(1, 2, 3, 4, 5,6)))
            });
        }).hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("보너스 입력 시 당첨 번호와 숫자가 중복될 경우 에러가 발생한다.")
    void 보너스입력_숫자중복_테스트(){
        assertThatThrownBy(() -> {
            command("1");
            Application.main(new String[]{
                    String.valueOf(new Input().getBonusNumber(List.of(1, 2, 3, 4, 5,6)))
            });
        }).hasMessageContaining("[ERROR]");
    }
    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
