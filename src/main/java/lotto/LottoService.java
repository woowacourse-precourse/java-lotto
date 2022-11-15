package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {

    public List<Integer> createRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> makeLotto(int count){
        List <Lotto> lottos = new ArrayList<>();
        for (int i=0;i<count;i++){
            Lotto lotto = new Lotto(createRandomNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public int matchNumbers(List<Integer> lotto, List<Integer> userLotto){
        int result = 0;
        for (int i=0;i<6;i++){
            if (lotto.contains(userLotto.get(i))){
                result += 1;
            }
        }
        return result;
    }

    public boolean matchBonus(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public List<Integer> calculateLotto(List<Lotto> lottos, Lotto userLotto, int bonusNum) {
        LottoService lottoService = new LottoService();
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<lottos.size();i++){
            int count = lottoService.matchNumbers(lottos.get(i).getNumbers(), userLotto.getNumbers());
            boolean isBonusMatch = lottoService.matchBonus(lottos.get(i).getNumbers(), bonusNum);
            if (count == 5 && isBonusMatch) {
                count = 7;
            }
            result.add(count);
        }
        return result;
    }

    public List<Integer> winningResult(List<Integer> result){
        List<Integer> answer = Arrays.asList(0, 0, 0, 0, 0);
        for (Integer number:result){
            if (number == 3) {
                Integer tmp = answer.get(0);
                answer.set(0, tmp + 1);
            }
            if (number == 4) {
                Integer tmp = answer.get(1);
                answer.set(1, tmp + 1);
            }
            if (number == 5) {
                Integer tmp = answer.get(2);
                answer.set(2, tmp + 1);
            }
            if (number == 7){
                Integer tmp = answer.get(3);
                answer.set(3, tmp + 1);
            }
            if (number == 6) {
                Integer tmp = answer.get(4);
                answer.set(4, tmp + 1);
            }
        }
        return answer;
    }
}
