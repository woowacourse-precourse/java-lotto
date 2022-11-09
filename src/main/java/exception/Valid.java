package exception;

public class Valid {

    public static boolean isMoneyThousandUnit(int money) {
        if (money % 1000 != 0) {
            return false;
        }
        return true;
    }

    public static boolean isMoneyOverThousand(int money){
        if (money < 1000) {
            return false;
        }
        return true;
    }
}
