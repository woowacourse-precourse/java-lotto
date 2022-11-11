package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class makeLottos {
    private int numberOfLottos;
    private List<Lotto> lottosNumber;
    makeLottos(int numberOfLottos){
        this.numberOfLottos = numberOfLottos;
        this.lottosNumber = new ArrayList<>();
        this.lottosNumber = makeLottoNumbers();
    }
    List<Lotto> makeLottoNumbers(){
        int index = numberOfLottos;
        while (index>0){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottosNumber.add(lotto);
            --index;
        }
        return lottosNumber;
    }
    void printLottoNumbers(){
        for (Lotto lotto : lottosNumber){
            System.out.println(lotto.toString());
        }
    }

}
