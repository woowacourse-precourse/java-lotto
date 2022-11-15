package lotto.view;

public enum InputString {
    PURCHASE_MONEY_MESSAGE {
        @Override
        public String toString(){
            return "구입금액을 입력해 주세요.";
        }
    },

    WINNING_NUMBER_MESSAGE {
        @Override
        public String toString(){
            return "당첨 번호를 입력해 주세요.";
        }
    },

    BONUS_NUMBER_MESSAGE {
        @Override
        public String toString(){
            return "보너스 번호를 입력해 주세요.";
        }
    },

    NO_NUMBER_INPUT {
        @Override
        public String toString(){
            return "[ERROR] 숫자만 입력해주세요.";
        }
    },

    NO_NUMBER_AND_COMMA_INPUT {
        @Override
        public String toString(){
            return "[ERROR] 숫자와 콤마만 입력해주세요.";
        }
    }
}
