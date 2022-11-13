package lotto.system;


import camp.nextstep.edu.missionutils.Console;

public class IoSystem {

    public String input() {
        return Console.readLine();
    }

    public void print(final Object message) {
        System.out.print(message);
    }

    public void println(final Object message) {
        System.out.println(message);
    }
}