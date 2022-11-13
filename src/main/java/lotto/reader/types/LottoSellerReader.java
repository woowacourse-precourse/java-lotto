package lotto.reader.types;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.filter.Filter;
import lotto.reader.Reader;

public class LottoSellerReader implements Reader {
    private final List<Filter> filters;

    public LottoSellerReader(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public String read() {
        String cash = Console.readLine();
        checkValidationOrThrowException(cash);

        return cash;
    }


    private void checkValidationOrThrowException(String cash) {
        for (Filter i : filters) {
            i.doFilter(cash);
        }
    }
}
