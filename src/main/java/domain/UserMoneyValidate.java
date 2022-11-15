package domain;

public class UserMoneyValidate {

    private final int THOUSAND = 1000;

    public static int convertStringToInt(String input) throws NumberFormatException{
        int convert_num = Integer.parseInt(input);
        return convert_num;
    }

    public void isDivideThousand(int money){
        if(money % THOUSAND != 0){
            throw new IllegalArgumentException();
        }
    }

    public static void notNumber(String input) throws IllegalArgumentException{
        Integer.parseInt(input);
    }

    public static void number_validate(String input){
        try {
            convertStringToInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public void negativeNumber(int money){
        if(money < 0){
            throw new IllegalArgumentException();
        }
    }
}
