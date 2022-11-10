package lotto.infrastructure;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Generator;

public class GeneratorImpl implements Generator {


    @Override
    public String[] numberSeparator(String str) {
        return str.split(",");
    }

    @Override
    public List<Integer> lottoNumbersGenerator() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    @Override
    public int generateMoney() {
        return Integer.parseInt(Console.readLine());
    }

    @Override
    public String generateLotto() {
        return Console.readLine();
    }

    @Override
    public String generateBonusLottoNumber() {
        return Console.readLine();
    }
}
