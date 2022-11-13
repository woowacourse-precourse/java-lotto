package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class makeLottos {
    private List<Lotto> lottosNumber;
    makeLottos(int numberOfLottos){
        this.lottosNumber = makeLottosNumber(numberOfLottos);
    }
    private List<Lotto> makeLottosNumber(int numberOfLottos){
        List<Lotto> lottos = new ArrayList<>();
        int index = numberOfLottos;
        while (index>0){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            index--;
        }
        return lottos;
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
