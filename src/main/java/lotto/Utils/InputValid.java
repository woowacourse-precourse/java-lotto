package lotto.Utils;

public class InputValid {
    private final static int EXCEPTED_UNIT_OF_PRICE=1000;

    public InputValid() {
    }

    public static boolean checkPriceUnit(int userPrice){
        int isValidUserGameChance=userPrice%EXCEPTED_UNIT_OF_PRICE;

        if(isValidUserGameChance!=0){
            throw new IllegalArgumentException("1000 단위만 입력 가능합니다");
        }

        return true;
    }
}
