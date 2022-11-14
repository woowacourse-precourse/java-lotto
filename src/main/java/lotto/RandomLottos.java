package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class RandomLottos {
    private List<Lotto> lottosNumber;
    RandomLottos(int numberOfLottos){
        this.lottosNumber = makeLottosNumber(numberOfLottos);
    }
    private List<Lotto> makeLottosNumber(int numberOfLottos){
        List<Lotto> lottos = new ArrayList<>();
        int index = numberOfLottos;
        while (index>0){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(sortLottos(numbers));
            lottos.add(lotto);
            index--;
        }
        return lottos;
    }

    private List<Integer> sortLottos(List<Integer> randomNumbers){
        for (int i = 0; i < randomNumbers.size() - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < randomNumbers.size(); j++) {
                if (randomNumbers.get(idx) > randomNumbers.get(j)) {
                    idx = j;
                }
            }
            if (i != idx) {
                int tmp = randomNumbers.get(idx);
                randomNumbers.set(idx, randomNumbers.get(i));
                randomNumbers.set(i, tmp);
            }
        }
        return randomNumbers;
    }
    public List<Lotto> getLottosNumber() {
        return lottosNumber;
    }

    void printLottoNumbers(){
        for (Lotto lotto : lottosNumber){
            System.out.println(lotto.toString());
        }
    }
}