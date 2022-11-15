package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public int getMoneyInput() {
        try {
            int input = Integer.parseInt(Console.readLine());
            if (!(input % 1000 == 0)) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            }
            return input;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public List<List<Integer>> createNumber(int moneyInput) {
        int numberOfCreate = moneyInput / 1000;
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfCreate; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }
}
