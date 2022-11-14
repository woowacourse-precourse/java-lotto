package lotto.Utils;

public class Constants {
    public enum MatchNumber{
        THREE_MATCH("5,000", 5000, 3),
        FOUR_MATCH("50,000", 50000, 4),
        FIVE_MATCH("1,500,000", 1500000, 5),
        FIVE_BONUS_MATCH("30,000,000", 30000000, 5),
        SIX_MATCH("2,000,000,000", 2000000000, 6);
        private final String moneyAsString;
        private final int moneyAsInt;
        private final int matchNumber;

        MatchNumber(String moneyAsString, int moneyAsInt, int matchNumber) {
            this.moneyAsString = moneyAsString;
            this.moneyAsInt = moneyAsInt;
            this.matchNumber = matchNumber;
        }

        public String getMoneyAsString() {
            return moneyAsString;
        }
        public int getMoneyAsInt(){
            return moneyAsInt;
        }
        public int getMatchNumber() {
            return matchNumber;
        }
    }
}
