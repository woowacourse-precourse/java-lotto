package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoRandomPeek {
    private static final int LOTTO_SIZE =6;
    private static final int START_NUMBER = 1; // 나중에 enum으로 lottoValidate와 같이 빼기
    private static final int LAST_NUMBER = 45;
    private final List<Lotto> randomLottos;

    public LottoRandomPeek(int countLotto) {
        randomLottos = new ArrayList<>();
        for(int peekIndex = 0;peekIndex<countLotto;peekIndex++){
            drawLotto();
        }
    }

    public void drawLotto() {
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size()<LOTTO_SIZE){
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, LAST_NUMBER);
            if(!randomNumbers.contains(randomNumber)){
                randomNumbers.add(randomNumber);
            }
        }
        randomLottos.add(new Lotto(randomNumbers));
    }
    public List<Lotto> getRandomLottos(){
        return randomLottos;
    }

}
