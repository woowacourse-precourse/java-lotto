package lotto.domain;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

public enum Rank {
    SIX_NUMBERS_MATCHING(PrintRank.FIRST, 2_000_000_000, 0),
    FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHING(PrintRank.BONUS, 30_000_000, 1),
    ONLY_FIVE_NUMBERS_MATCHING(PrintRank.THIRD, 1_500_000, 0),
    FOUR_NUMBERS_MATCHING(PrintRank.FOURTH, 50_000, 0),
    THREE_NUMBERS_MATCHING(PrintRank.FIFTH, 5_000, 0);

    private final PrintRank print;
    private int winningMoney;
    private int bonus;

    Rank(PrintRank print, int winningMoney, int bonus) {
        this.print = print;
        this.winningMoney = winningMoney;
        this.bonus = bonus;
    }

    public void printRank() {
        print.printBefore();
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    enum PrintRank {
        FIRST {
            void printBefore() {
                System.out.print("6개 일치 (2,000,000,000원) - ");
            }
        },
        BONUS {
            void printBefore() {
                System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
            }
        },
        THIRD {
            void printBefore() {
                System.out.print("5개 일치 (1,500,000원) - ");
            }
        },
        FOURTH {
            void printBefore() {
                System.out.print("4개 일치 (50,000원) - ");
            }
        },
        FIFTH {
            void printBefore() {
                System.out.print("3개 일치 (5,000원) - ");
            }
        };

        abstract void printBefore();
    }
}
