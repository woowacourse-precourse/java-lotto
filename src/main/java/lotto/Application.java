package lotto;



import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = inputMoney();


    }


    public static int inputMoney() {
        String inputMoneyString = Console.readLine();
        int money;
        boolean inputMoneyError = false;

        try {
            money = checkInput(inputMoneyString);
        } catch (Exception e) {
            inputMoneyError = true;
            throw new IllegalArgumentException();
        } finally {
            if (inputMoneyError) {
                String errorMessage = "[ERROR] 잘못된 입력이 들어왔습니다.";
                System.out.println(errorMessage);
            }
        }

        return money;
    }


    public static int checkInput(String input) {

        int inputInteger = Integer.parseInt(input);
        if (inputInteger % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }




}
