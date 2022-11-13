package lotto.system;

import camp.nextstep.edu.missionutils.Console;

public class IoSystemImpl implements IoSystem {
    public String input() {
        return Console.readLine();
    }


    @Override
    public void print(final Object message) {
        System.out.print(message);
    }


    @Override
    public void println(final Object message) {
        System.out.println(message);
    }

    @Override
    public void printBeforeNextLine(final Object message) {
        this.println("");
        this.print(message);
    }
}
