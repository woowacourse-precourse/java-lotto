package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class makeLottos {
    private List<Lotto> lottosNumber;
    makeLottos(int numberOfLottos){
        int index = numberOfLottos;
        while (index>0){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            this.lottosNumber.add(lotto);
            index--;
        }
    }
    void printLottoNumbers(){
        for (Lotto lotto : lottosNumber){
            System.out.println(lotto.toString());
        }
    }
}
