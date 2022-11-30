package lotto.dto.input;

public class ReadWinningLottoDto {

    private final String winningLotto;

    public ReadWinningLottoDto(String winningLotto) {
        this.winningLotto = winningLotto;
    }

    public String getWinningLotto() {
        return winningLotto;
    }
}
