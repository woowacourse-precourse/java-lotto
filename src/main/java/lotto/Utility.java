package lotto;

import camp.nextstep.edu.missionutils.Console;

public abstract class Utility {

    public void printMessage(String message){
        System.out.println(message);
    }

    public String receiveInput(){
        String input = Console.readLine();
        return input;
    }
}
