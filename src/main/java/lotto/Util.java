package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

    final static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int inputUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        int userMoney = 0;

        try {
            String userInput = br.readLine();

            if(isNumber(userInput)) userMoney = Integer.parseInt(userInput);

        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        return userMoney;
    }

    public static boolean isNumber(String str){

        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
