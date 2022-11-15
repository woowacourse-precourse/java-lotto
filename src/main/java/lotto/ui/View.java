package lotto.ui;

import java.util.List;
import lotto.Lotto;
import lotto.User;

public class View {

	public static void printInputMoney(){
		System.out.println(Display.INPUT_PURCHASE.getDisplay());
	}

	public static void printEachLotto(Lotto lottoNum) {
		for(int i = 0; i<Constants.COUNT; i++) {
			if(i == lottoNum.getNumbers().get(i) - 1) {
				System.out.print(lottoNum.getNumbers().get(i));
				return;
			}
			System.out.print(lottoNum.getNumbers().get(i) + ", ");
		}
	}

	public static void printCount(int count) {
		System.out.println(count + Display.BUY_LOTTO.getDisplay());
	}
	public static void printGeneratedLotto(List<Lotto> lottoNums){
		for(Lotto lottoNum : lottoNums) {
			printEachLotto(lottoNum);
		}
	}

	public static void printInputWinning(){
		System.out.println(Display.INPUT_WINNING.getDisplay());
	}
	public static void printInputBonus(){
		System.out.println(Display.INPUT_BONUS.getDisplay());
	}

	public static void printResult() {
		System.out.println(Display.SHOW_RESULT.getDisplay());
		System.out.println("---");

	}
}
