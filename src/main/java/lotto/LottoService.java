package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Score;
import lotto.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Lotto> lottoRepository;
    private WinningNumbers winningNumbers;
    private List<Integer> perScoreCounts;      // 각 인덱스에 NOTHING을 포함한 6개의 Score에 대한 count를 저장한다.

    public LottoService() {
        lottoRepository = new ArrayList<>();
        perScoreCounts = new ArrayList<>(Collections.nCopies(6, 0));
    }

    public void init() {
        long lottoQuantity = purchaseLotto();
        publishLottos(lottoQuantity);
        showLottos();

        winningNumbers = UserInput.getWinningNumbers();

        checkLottos();

        showResults();
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

    public void checkLottos(){
        for (Lotto lotto : lottoRepository) {
            Score score = lotto.compareWithWinningNumbers(winningNumbers);

            int index = mappingScoreToIndex(score);
            Integer prevValue = perScoreCounts.get(index);
            perScoreCounts.set(index, prevValue + 1);
        }
    }

    public void showResults(){
        System.out.println("3개 일치 (5,000원) - " + perScoreCounts.get(1) + "개");
        System.out.println("4개 일치 (50,000원) - " + perScoreCounts.get(2) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + perScoreCounts.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + perScoreCounts.get(4) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + perScoreCounts.get(5) + "개");
    }

    private int mappingScoreToIndex(Score score){
        return score.ordinal();
    }
}
