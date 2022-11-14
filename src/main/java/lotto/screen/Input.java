package lotto.screen;

import java.util.function.Function;

public interface Input {
    public String inputValue();

    public Object input(String prompt, Function<String , Object> function);
}
