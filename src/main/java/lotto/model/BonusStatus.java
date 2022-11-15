package lotto.model;

public enum BonusStatus {

    REQUIRED {
        boolean isBonus(boolean status) {
            return status;
        }
    },
    NOT_REQUIRED {
        boolean isBonus(boolean status) {
            return !status;
        }
    },
    NO_MATTER {
        boolean isBonus(boolean status) {
            return true;
        }
    };

    abstract boolean isBonus(boolean status);


}
