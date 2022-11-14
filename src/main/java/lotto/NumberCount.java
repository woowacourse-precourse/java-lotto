package lotto;

public class NumberCount {
	int guess;
	int bonusGuess;

	public void setCount() {
		guess = 0;
		bonusGuess = 0;
	}

	public void guessCount() {
		guess++;
	}

	public void bonusGuessCount() {
		bonusGuess++;
	}

	public int getGuess() {
		return guess;
	}

	public int getBonusGuess() {
		return bonusGuess;
	}
}
