package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GeneratingLottoNumbers {

    public List<Lotto> generatingAllLottoPapers(int amountOfLotto){
        List<Lotto> lottoPapers = new ArrayList<>();
        for(int i = 0; i < amountOfLotto; i++){
            lottoPapers.add(generateOneLottoPaper());
        }
        return lottoPapers;
    }

    public Lotto generateOneLottoPaper(){
        List<Integer> generateRandomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(generateRandomNumbers);
    }
}
