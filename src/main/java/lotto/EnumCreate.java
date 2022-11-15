package lotto;

import java.util.Arrays;
import java.util.List;

public class EnumCreate {
    public enum RangeNumber {

        RANGE_START(1),
        RANGE_END(45);

        private int range;

        RangeNumber(int range) {
            this.range = range;
        }

        public int getRangeNumber() {
            return range;
        }
    }

    public enum MatchNumberAmount { //사용자가 몇개를 맞췄는지 개수를 나타냄.
        THREE(3),
        FOUR(4),
        FIVE(5),
        FIVEBONUS(6),
        SIX(7);

        private int number;


        MatchNumberAmount(int number) {
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

    public enum RewardList {
        REWARD_LIST(Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000));


        private List<Integer> rewardList;

        RewardList(List<Integer> rewardList) {
            this.rewardList = rewardList;
        }

        public List<Integer> getRewardList() {
            return rewardList;
        }
    }


}
