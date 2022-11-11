package lotto.Utils;

public class InputValid {
    private final static int EXCEPTED_UNIT_OF_PRICE=1000;

    public InputValid() {
    }

    public static boolean checkPriceUnit(String userPrice){
        int isValidUserGameChance;

        try{
            isValidUserGameChance=Integer.parseInt(userPrice)%EXCEPTED_UNIT_OF_PRICE;
        }catch (Exception e){
            return false;
        }

        if(isValidUserGameChance!=0){
            return false;
        }
        return true;
    }
}
