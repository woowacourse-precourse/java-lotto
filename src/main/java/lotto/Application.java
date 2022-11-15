package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) { 	
    	Game game = new Game();
    	String input = purchase();
    	game.start(input);
    	game.purchaseRandomNumbers(input);
    	game.printLottoNumbers();
    	outputPurchase(game, input);
    }
    
    public static String purchase(){
    	System.out.println(Game.START_MESSAGE);
    	return Console.readLine();
    }
    
    public static void outputPurchase(Game game, String input) {
    	List<Lotto> numbers = game.printLottoNumbers();
    	System.out.println(game.purchaseLottoAmount(input) + Game.PURCHASE_MESSAGE);
    	for (Lotto number : numbers) {
    		System.out.println(number.getLottoNumbers());
    	}
    }
    
    public static String[] inputWinningNumber() {
    	System.out.println(Game.INPUTNUMBER_MESSAGE);
    	return Console.readLine().split(", ");
    }

}