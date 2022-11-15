package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> generatLottos(String userInput) {
        validate(userInput);
        return createLottos(StringToIntegerMapper.toInt(userInput));
    }

    private static List<Lotto> createLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < getCount(amount); i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            sortNumbers(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void validate(String userInput) {
        try {
            int amount = StringToIntegerMapper.toInt(userInput);
            if (amount % 1000 != 0) throw new IllegalArgumentException("1000원 단위 숫자를 입력해주세요");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private static int getCount(Integer amount) {
        int count = amount / 1000;
        return count;
    }

    private static void sortNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }
}
