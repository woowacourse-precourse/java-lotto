package lotto;

import java.util.Map;

public class LottoMetadata {
    private final Integer startNumber;
    private final Integer endNumber;
    private final Integer priceOfLotto;
    private final Map<Map.Entry<Integer, Boolean>, Prize> prizeTable;
    private final String delimeter;
    private final Map<Prize, Integer> prizeMoney;
    private final Map<Prize, Map.Entry<Integer, Boolean>> prizeInfo;

    public static class Builder {
        private Integer startNumber = 1;
        private Integer endNumber = 45;
        private Integer priceOfLotto = 1000;
        private Map<Map.Entry<Integer, Boolean>, Prize> prizeTable = Map.of(
                Map.entry(6, false), Prize.FIRST,
                Map.entry(5, true), Prize.SECOND,
                Map.entry(5, false), Prize.THIRD,
                Map.entry(4, false), Prize.FOURTH,
                Map.entry(4, true), Prize.FOURTH,
                Map.entry(3, false), Prize.FIFTH,
                Map.entry(3, true), Prize.FIFTH
        );
        private String delimeter = ",";
        private Map<Prize, Integer> prizeMoney = Map.of(
                Prize.FIRST, 2000000000,
                Prize.SECOND, 30000000,
                Prize.THIRD, 1500000,
                Prize.FOURTH, 50000,
                Prize.FIFTH, 5000
        );
        private Map<Prize, Map.Entry<Integer, Boolean>> prizeInfo = Map.of(
                Prize.FIRST, Map.entry(6, false),
                Prize.SECOND, Map.entry(5, true),
                Prize.THIRD, Map.entry(5, false),
                Prize.FOURTH, Map.entry(4, false),
                Prize.FIFTH, Map.entry(3, false)
        );

        public Builder() {}

        public Builder startNum(Integer number) {
            startNumber = number;
            return this;
        }

        public Builder endNum(Integer number) {
            endNumber = number;
            return this;
        }

        public Builder priceOfLotto(Integer price) {
            priceOfLotto = price;
            return this;
        }

        public Builder equalNumberToPrize(Map<Map.Entry<Integer, Boolean>, Prize> table) {
            prizeTable = table;
            return this;
        }

        public Builder delim(String delim) {
            delimeter = delim;
            return this;
        }

        public Builder prizeMoney(Map<Prize, Integer> money) {
            prizeMoney = money;
            return this;
        }

        public Builder prizeInfo(Map<Prize, Map.Entry<Integer, Boolean>> info) {
            prizeInfo = info;
            return this;
        }

        public LottoMetadata build() {
            return new LottoMetadata(this);
        }
    }

    public LottoMetadata(Builder builder) {
        this.startNumber = builder.startNumber;
        this.endNumber = builder.endNumber;
        this.priceOfLotto = builder.priceOfLotto;
        this.prizeTable = builder.prizeTable;
        this.delimeter = builder.delimeter;
        this.prizeMoney = builder.prizeMoney;
        this.prizeInfo = builder.prizeInfo;
    }

    public Integer getStartNumber() {
        return startNumber;
    }

    public Integer getEndNumber() {
        return endNumber;
    }

    public Integer getPriceOfLotto() {
        return priceOfLotto;
    }

    public Map<Map.Entry<Integer, Boolean>, Prize> getPrizeTable() {
        return prizeTable;
    }

    public String getDelimeter() {
        return delimeter;
    }

    public Map<Prize, Integer> getPrizeMoney() {
        return prizeMoney;
    }

    public Map<Prize, Map.Entry<Integer, Boolean>> getPrizeInfo() {
        return prizeInfo;
    }
}
