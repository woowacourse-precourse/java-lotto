package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import exception.IllegalAmountException;
import exception.NegativeInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Buyer {

    public List<Lotto> buyLotto(int purchaseAmount) {
        int lottoAmount = purchaseAmount / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> pickedNumber = pickNumber();
            lottos.add(new Lotto(pickedNumber));
        }

        return lottos;
    }



    public List<Integer> pickNumber() {
        HashSet<Integer> pickedNumber = new HashSet<>();
        boolean stopFlag = false;

        while (stopFlag == false) {
            pickedNumber.add(Randoms.pickNumberInRange(1, 45));
            if (pickedNumber.size() == 6) {
                stopFlag = true;
            }
        }

        return new ArrayList<>(pickedNumber);

    }
}
