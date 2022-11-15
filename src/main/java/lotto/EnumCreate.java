package lotto;

public class EnumCreate {

    public enum MatchAmount {
        THREE(3),
        FOUR(4),
        FIVE(5),
        FIVEBONUS(6),
        SIX(7);

        private int number;


        MatchAmount(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }


        public enum LottoMatchMoneyMessage {
            THREE("3개 일치 (5,000원) - "),
            FOUR("4개 일치 (50,000원) - "),
            FIVE("5개 일치 (1,500,000원) - "),
            FIVEBONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
            SIX("6개 일치 (2,000,000,000원) - ");
            private String numberMessage;

            LottoMatchMoneyMessage(String numberMessage) {
                this.numberMessage = numberMessage;
            }

            public String getNumberMessage() {
                return numberMessage;
            }
        }
    }


}
