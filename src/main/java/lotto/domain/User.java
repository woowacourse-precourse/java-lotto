package lotto.domain;

import java.util.List;

import lotto.ExceptionHandler;

public class User {
	private static int money;
	private List<List<Integer>> lottoeris;
	private double rateOfReturn;

	public User(int money) {
		ExceptionHandler.checkMoney(money);

		this.money = money;
	}

	public User(List<List<Integer>> lottoeris) {
		this.lottoeris = lottoeris;
	}
	public static int getMoney() {
		return money;
	}

	public void setRateOfReturn(double rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}

	public double getRateOfReturn() {
		return rateOfReturn;
	}

	public void userLottoeris(List<List<Integer>> lottoeris) {
		this.lottoeris = lottoeris;
	}

	public List<List<Integer>> getLottoeris() {
		return lottoeris;
	}
}
