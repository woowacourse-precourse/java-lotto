package lotto.IO;

import camp.nextstep.edu.missionutils.Console;

public class IOTopClass implements Input, Output {

    @Override
    public String readInput() {
        return Console.readLine();
    }
}
