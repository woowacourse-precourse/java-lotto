package domain;

public class UserMoneyValidate {

    private final int THOUSAND = 1000;
    private String input;

    public int validateGetMoney(String input) throws IllegalArgumentException{
        number_validate(input);
        int user_money = convertStringToInt(input);
        negativeNumber(user_money);
        isDivideThousand(user_money);

        return user_money;
    }

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
