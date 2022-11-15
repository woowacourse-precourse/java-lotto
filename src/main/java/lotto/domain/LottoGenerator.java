package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {
    private static final int MAX_LEN = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final LottoConverter converter;

    public LottoGenerator(){
        this.converter = new LottoConverter();
    }

    public List<Lotto> getLottos(long playerLottoQuantity) {
        List<Lotto> playerLotto = new ArrayList<>();
        List<Integer> randomNumbers;
        Lotto lotto;
        for(int i = 0; i < playerLottoQuantity; i++){
            randomNumbers = generateLottoNumbers(START_NUMBER, END_NUMBER);
            lotto = converter.convertRandomNumbersToLotto(randomNumbers);
            playerLotto.add(lotto);
        }
        return playerLotto ;
    }

    public List<Integer> generateLottoNumbers(final int startValue, final int endValue) {
        return getRandomNumbers(startValue, endValue);
    }

    public List<Integer> getRandomNumbers(final int startValue, final int endValue) {
        List<Integer> randomNumbers = new ArrayList<>();
        int randomNumber;

        while (randomNumbers.size() < MAX_LEN) {
            randomNumber = Randoms.pickNumberInRange(startValue, endValue);
            if(!randomNumbers.contains(randomNumber)){
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers ;
    }


}
