package lotto.service;

import lotto.domain.Rank;

public enum Calculator implements Operation {

    MULTIPLICATION("*") {
        @Override
        public double apply(int count, Rank rank) {
            return (count * rank.getWinningMoney());
        }

        @Override
        public double sum(double count1, double count2, double count3, double count4, double count5) {
            return 0;
        }
    },

    PLUS("+") {
        @Override
        public double apply(int count, Rank rank) {
            return 0;
        }

        @Override
        public double sum(double count1, double count2, double count3, double count4, double count5) {
            return count1 + count2 + count3 + count4 + count5;
        }
    };

    private final String symbol;

    Calculator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
