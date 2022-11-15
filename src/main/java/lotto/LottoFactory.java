package lotto;

import java.util.List;

public class LottoFactory {
    public static Lotto createLotto(final List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static WinNumbers createWinNums(final List<LottoNumber> lottoNumbers, LottoNumber bonus) {
        return new WinNumbers(createLotto(lottoNumbers), bonus);
    }
}