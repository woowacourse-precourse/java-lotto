package lotto;

import Controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try{
            controller.run();
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
