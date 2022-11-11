package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.Lotto;

import java.util.List;

public class GeneratingLottoNumbers {

    public Lotto[] generatingAllLottoPapers(int amountOfLotto){
        Lotto[] lottoPapers = new Lotto[amountOfLotto];
        for(int i = 0; i < amountOfLotto; i++){
            lottoPapers[i] = generateOneLottoPaper();
        }
        return lottoPapers;
    }

    public Lotto generateOneLottoPaper(){
        List<Integer> generateRandomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(generateRandomNumbers);
    }
}
