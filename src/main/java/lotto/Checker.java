package lotto;

public class Checker {
	private static final int MAX_PRICE = 100000;
	private static int FIRST;
	private static int SECOND;
	private static int THIRD;
	private static int FOURTH;
	private static int FIFTH;

	private void checkSameNumber() {

	}

	public static void checkUserInput(String userInput) {
		checkNumberOnlyException(userInput);
		checkMaxPrice(userInput);

	}

	private static void checkMaxPrice(String userInput) {
		if (isExceedMaxPrice(userInput)) {
			Exception.maxPriceException();
		}
	}

	private static boolean isExceedMaxPrice(String userInput) {
		return Integer.parseInt(userInput) > MAX_PRICE;
	}

	private static void checkNumberOnlyException(String userInput) {
		try {
			int money = Integer.parseInt(userInput);
		} catch (IllegalArgumentException e) {
			Exception.numberOnlyException();
		}
	}

	public void compareNumbers() {

	}
}
