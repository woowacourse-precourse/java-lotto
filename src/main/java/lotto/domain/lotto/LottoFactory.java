package lotto.domain.lotto;

import lotto.domain.generator.NumsGenerator;
import lotto.domain.result.TicketCount;
import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public static WinningLotto createWinNums(final List<Integer> rawLottoNumbers, final int bonusNumber) {
        LottoNumber bonus = LottoNumber.getInstance(bonusNumber);
        return WinningLotto.of(Lotto.from(NumsGenerator.generate(rawLottoNumbers)), bonus);
    }

    public static LottoGroup createLottos(final TicketCount count, final List<List<Integer>> rawLottoNumsGroup) {
        final List<Lotto> lottos = new ArrayList<>(List.copyOf(createManualLottos(rawLottoNumsGroup)));
        lottos.addAll(createAutoLottos(count.ofAuto()));
        return LottoGroup.of(lottos);
    }

    private static List<Lotto> createManualLottos(final List<List<Integer>> rawLottoNumsGroup) {
        final List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> nums : rawLottoNumsGroup) {
            lottos.add(Lotto.from(NumsGenerator.generate(nums)));
        }
        return lottos;
    }

    private static List<Lotto> createAutoLottos(final int count) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.from(NumsGenerator.RandomNumber()));
        }
        return lottos;
    }
}
