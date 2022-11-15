package lotto.application.output.lottoprinter;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoPrinter {

    void showGeneratedLottoNumber(List<Lotto> generatedLottoNumber);
}
