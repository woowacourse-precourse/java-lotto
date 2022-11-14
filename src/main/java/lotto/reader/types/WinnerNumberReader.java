package lotto.reader.types;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.filter.Filter;
import lotto.reader.Reader;

public class WinnerNumberReader implements Reader {


    private final List<Filter> filters;

    public WinnerNumberReader(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public String read() {
        String number = Console.readLine();
        checkValidationOrThrowException(number);

        return number;
    }

    private void checkValidationOrThrowException(String number) {
        for (Filter i : filters) {
            i.doFilter(number);
        }

    }
}
