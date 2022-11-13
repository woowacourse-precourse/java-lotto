package lotto.reader;

import java.util.List;
import lotto.filter.CashUnitFilter;
import lotto.filter.Filter;
import lotto.filter.NumberFilter;
import lotto.reader.types.LottoSellerReader;

public enum ReaderType {

    STORE {
        @Override
        public Reader getReader() {
            List<Filter> filters = List.of(new NumberFilter(), new CashUnitFilter());

            return new LottoSellerReader(filters);
        }
    };


    public abstract Reader getReader();


}
