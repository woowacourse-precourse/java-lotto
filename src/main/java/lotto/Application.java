package lotto;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Game.playGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}