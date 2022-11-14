package lotto.ui;


public final class Constants {
    public static final int LOTTO_SIZE = 6;

    public static final String[] printTable = {"3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ", "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "6개 일치 (2,000,000,000원) - "
    };

    public enum Statistic {
        THREE(3, 5000), FOUR(4, 50000),
        FIVE(5, 1500000), FIVE_BONUS(15, 30000000),
        SIX(6, 2000000000);
        private final int gotMoney;
        private final int correctNumber;
        private int count = 0;

        Statistic(int correctNumber, int gotMoney) {
            this.gotMoney = gotMoney;
            this.correctNumber = correctNumber;
        }

        public int getCount() {
            return count;
        }

        public int getAllPrize () {
            return gotMoney * count;
        }

        public int getCorrectNumber() {
            return correctNumber;
        }

        public void addCount() {
            count += 1;
        }

        public String getPrint(){
            if (correctNumber == 3){
                return printTable[0];
            }
            else if (correctNumber == 4){
                return printTable[1];
            }
            else if (correctNumber == 5){
                return printTable[2];
            }
            else if (correctNumber == 15){
                return printTable[3];
            }
            return printTable[4];
        }
    }
}
