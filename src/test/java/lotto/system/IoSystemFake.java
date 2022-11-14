package lotto.system;

import java.util.ArrayList;
import java.util.List;

public class IoSystemFake implements IoSystem {
    private final List<String> inputs = new ArrayList<>();
    private Integer index;

    public IoSystemFake(String... input) {
        this.inputs.addAll(List.of(input));
    }

    @Override
    public String input() {
        this.index = 0;
        return inputs.get(index++);
    }

    @Override
    public void print(Object message) {
        System.out.print(message);
    }

    @Override
    public void println(Object message) {
        System.out.println(message);
    }

    @Override
    public void printBeforeNextLine(Object message) {
        this.println("");
        this.print(message);
    }
}
