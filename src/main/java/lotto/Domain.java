package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Domain {

    List<Lotto> userLottos;
    Lotto winningNumber;

    public Domain() {
        userLottos = new ArrayList<>();
    }
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

    public void createRandomLottoNumber() {
        userLottos.add(new Lotto(pickUniqueNumbersInRange(1, 45, 6)));
    }

//    public static void main(String[] args) {
//        Domain domain = new Domain();
//        for (int i = 0; i < 50; i++) {
//            System.out.println(domain.createRandomLottoNumber().getNumbers());
//
//        }
//    }

}
