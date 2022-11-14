package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public static  String input() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
    public static int checkInput(String user) {
        if (checkNum(user) == 0) {
            try {
                throw new IllegalArgumentException("[ERROR] 1부터 45사이 숫자를 입력해주세요.");
            } catch (Exception e) {
                System.out.println(e);
            }
            return 0;
         }
        if (checkDevide(user) == 0) {
            try {
                throw new IllegalArgumentException("[ERROR] 천원단위로 입력해주세요");
            }catch (Exception e){
                System.out.println(e);
            }
            return 0;
        }
        return Integer.valueOf(user)/1000;
        }
        public static int checkDevide(String user) {
        //1000으로 나누어 떨어지는지 검사
            if(Integer.valueOf(user)%1000!=0){
                return 0;
                }
            return 1;
        }
        public static int checkNum (String num){  //숫자인지 판단
            for (int idx = 0; idx < num.length(); idx++) {
                if (Character.isDigit(num.charAt(idx)) == false) {
                    return 0;
                }
            }
            return 1;
        }
}