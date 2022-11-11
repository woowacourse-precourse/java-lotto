package lotto.infrastructure;


import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Generator;

public class GeneratorImpl implements Generator {

    @Override
    public String[] numberSeparator(String str) {
        return str.split(",");
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
