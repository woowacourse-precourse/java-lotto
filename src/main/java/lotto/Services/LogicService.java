package lotto.Services;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Dto.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogicService {
    public List<Lotto> makeLotto(int lottoSize) {
        List<Lotto> lottos = new ArrayList<>(lottoSize);
        for(int i = 0; i < lottoSize; i++){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public Map<String,Integer> checkLottoNumber(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        Map<String,Integer> winningSize = init();
        for(Lotto lotto : lottos){
            // count가 5이고, bonusNumber도 포함되어있는 경우
            int count = checkWinningNumber(lotto,winningNumbers.getNumbers());
            if(count >=3){
                if(count == 5 && lotto.contains(bonusNumber)){
                    winningSize.put("5BonusNumber",winningSize.get("5BonusNumber")+1);
                    continue;
                }
                winningSize.put(String.valueOf(count),winningSize.get(String.valueOf(count))+1);
            }
        }
        return winningSize;
    }

    public int checkWinningNumber(Lotto lotto, List<Integer> winningNumbers){
        int count = 0;
        for(int winningNumber : winningNumbers){
            if(lotto.contains(winningNumber)){
                count++;
            }

        }
        return count;
    }

    public Map<String,Integer> init(){
        return new HashMap<>(){{
            put(String.valueOf(3),0);
            put(String.valueOf(4),0);
            put(String.valueOf(5),0);
            put("5BonusNumber",0);
            put(String.valueOf(6),0);
        }
        };
    }
}
