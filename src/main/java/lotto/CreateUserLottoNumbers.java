package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateUserLottoNumbers {

    public List<List<Integer>> userLottosGroup;

    public CreateUserLottoNumbers(){
        userLottosGroup = new ArrayList<>();
    }

    public List<List<Integer>> randomLottoNumbers(int amount){
        List<List<Integer>> numberSave = new ArrayList<>();
        for(int i = 0; i< amount; i++){
            numberSave.add(Randoms.pickUniqueNumbersInRange(1,45,6));
        }
        userLottosGroup = numberSave;
        return userLottosGroup;
    }
}
