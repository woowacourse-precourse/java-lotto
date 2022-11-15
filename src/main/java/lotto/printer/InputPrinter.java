package lotto.printer;

public enum InputPrinter {
    INPUT_BUYING_MONEY {
        @Override
        public void print() {
            System.out.println("구입금액을 입력해 주세요.");
        }
    },

    INPUT_WINNING_NUMBERS {
        @Override
        public void print() {
            System.out.println("\n당첨 번호를 입력해 주세요.");
        }
    },

    INPUT_BONUS_NUMBER {
        @Override
        public void print() {
            System.out.println("\n보너스 번호를 입력해 주세요.");
        }
    },

    WINNING_STATISTICS {
        @Override
        public void print() {
            System.out.println("\n당첨통계\n---");
        }
    };

    public abstract void print();

}
