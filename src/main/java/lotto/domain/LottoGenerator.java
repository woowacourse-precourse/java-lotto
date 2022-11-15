package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    static final int LOTTO_SIZE = 6;
    static final int LOTTO_PRICE = 1000;
    static final int LOTTO_NUMBER_RANGE_START = 1;
    static final int LOTTO_NUMBER_RANGE_END = 45;

    private final int numberOfLotto;
    private final List<Lotto> lottos;

    public LottoGenerator(int purchaseAmount) {
        numberOfLotto = purchaseAmount / LOTTO_PRICE;
        lottos = generate(numberOfLotto);
        printLottosInfo();
    }

    private List<Lotto> generate(int numberOfLotto){
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0;i<numberOfLotto;i++){
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END, LOTTO_SIZE));
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private void printLottosInfo(){
        System.out.println(numberOfLotto + Message.LOTTO_GENERATE_SUCCESS);
        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
