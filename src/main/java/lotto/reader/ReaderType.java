package lotto.reader;

import java.util.List;
import lotto.filter.BonusDuplicationFilter;
import lotto.filter.CashUnitFilter;
import lotto.filter.Filter;
import lotto.filter.LottoDuplicationFilter;
import lotto.filter.LottoRangeFilter;
import lotto.filter.NumberFilter;
import lotto.filter.NumberWithDotFilter;
import lotto.reader.types.BonusNumberReader;
import lotto.reader.types.LottoSellerReader;
import lotto.reader.types.WinnerNumberReader;

public enum ReaderType {

    STORE {
        @Override
        public Reader getReader() {
            List<Filter> filters = List.of(new NumberFilter(), new CashUnitFilter());

            return new LottoSellerReader(filters);
        }
    },

    WINNER {
        @Override
        public Reader getReader() {
            List<Filter> filters = List.of(
                    new NumberWithDotFilter(),
                    new LottoRangeFilter(),
                    new LottoDuplicationFilter());

            return new WinnerNumberReader(filters);
        }
    },

    BONUS {
        @Override
        public Reader getReader() {
            List<Filter> filters = List.of(new NumberFilter(),
                    new LottoRangeFilter(),
                    new BonusDuplicationFilter());

            return new BonusNumberReader(filters);
        }
    };


    public abstract Reader getReader();


}
