package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }


    public int userInput(String s) {
        int number=0;
        try{
            number=Integer.parseInt(s);
            if(number<1000 || number%1000!=0){
                throw new IllegalArgumentException();
            }
            return number/1000;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
