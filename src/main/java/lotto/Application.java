package lotto;

import lotto.function.Start;

import java.util.List;

import static lotto.function.Start.*;

public class Application {
    public static void main(String[] args) {
        try{
            Start start = new Start();
            start.run();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
