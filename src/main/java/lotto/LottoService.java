package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Lotto> lottoRepository;
    private WinningNumbers winningNumbers;

    public LottoService() {
        lottoRepository = new ArrayList<>();
    }

    public void init() {
        long lottoQuantity = purchaseLotto();

        publishLottos(lottoQuantity);
        showLottos();
    }
    
    public long purchaseLotto() {
        Long purchaseMoney = UserInput.getPurchaseMoney();
        return purchaseMoney / LOTTO_PRICE;
    }

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER_SIZE);
    }

    public void publishLottos(long lottoQuantity) {
        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = new Lotto(generateLottoNumbers());
            lottoRepository.add(lotto);
        }
    }

    public void showLottos() {
        System.out.println(lottoRepository.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoRepository) {
            lotto.printNumbers();
        }
    }
}
