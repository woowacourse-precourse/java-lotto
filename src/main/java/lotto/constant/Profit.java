package lotto.constant;

import java.util.function.Function;

public enum Profit {

    PROFIT{
        @Override
        public String profitRate(String x) {
            return "총 수익률은 "+x+"%입니다.";
        }
    };

    public abstract String profitRate(String x);

}
