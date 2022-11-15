package lotto.controller;

public enum WinStatisticsStatus {
	FIRST_PLACE(6, 2000000000) {
		@Override
		public void showResult(int matchNumber) {
			System.out.printf("6개 일치 (2,000,000,000원) - %d개", matchNumber);
		}
	}, BONUS_PLACE(100, 30000000) {
		@Override
		public void showResult(int matchNumber) {
			System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", matchNumber);
		}
	}, SECOND_PLACE(5, 1500000) {
		@Override
		public void showResult(int matchNumber) {
			System.out.printf("5개 일치 (1,500,000원) - %d개", matchNumber);
		}
	}, THIRD_PLACE(4, 50000) {
		@Override
		public void showResult(int matchNumber) {
			System.out.printf("4개 일치 (50,000원) - %d개", matchNumber);
		}
	}, FOURTH_PLACE(3, 5000) {
		@Override
		public void showResult(int matchNumber) {
			System.out.printf("3개 일치 (5,000원) - %d개", matchNumber);
		}
	};
	private final int rank;
	private final int price;

	WinStatisticsStatus(int rank, int price) {
		this.rank = rank;
		this.price = price;
	}

	public int getRank() {
		return rank;
	}

	public int getPrice() {
		return price;
	}

	public abstract void showResult(int matchNumber);
}
