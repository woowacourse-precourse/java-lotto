package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private View view;
    private Exception exception;
    private List<Lotto> total_lotto;
    private List<Integer> total_bonus_lotto;

    public void run(){
        init();
        int money = view.requestMoney();
    }



    private void init(){
        final Scanner scanner = new Scanner(System.in);
        view= new View(scanner);
        total_lotto = new ArrayList<>();
        total_bonus_lotto =new ArrayList<>();
        exception = new Exception();
    }
}
