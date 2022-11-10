package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Domain {

    public boolean isValidPriceInput(String input) {
        if (!input.matches("^[0-9]+$")) {
            return false;
        }
        int inputPrice = Integer.parseInt(input);
        if (inputPrice % 1000 != 0) {
            return false;
        }
        return true;
    }

    public List<Integer> trimLottoNumberInput(String lottoNumberInput) {
        List<Integer> result = new ArrayList<>();
        for (String charNumber : lottoNumberInput.split(",")) {
            result.add(Integer.parseInt(charNumber));
        }
        return result;
    }

    public Lotto createRandomLottoNumber() {
        return new Lotto(pickUniqueNumbersInRange(1, 45, 6));
    }

    public float getYield(List<Integer> ranks, int countOfLotto) {
        float sumWinnings = 0;
        for (int rank : ranks) {
            sumWinnings += getreward(rank);
        }

        return sumWinnings / countOfLotto;
    }



//    public static void main(String[] args) {
//        Domain domain = new Domain();
//        for (int i = 0; i < 50; i++) {
//            System.out.println(domain.createRandomLottoNumber().getNumbers());
//
//        }
//    }

}
