package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInputGeneratorImpl implements NumberGenerator {
    @Override
    public String generate() {
        return Console.readLine();
    }
}
