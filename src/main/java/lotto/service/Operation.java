package lotto.service;

import lotto.domain.Rank;

public interface Operation {
    double apply(int count, Rank rank);
    double sum(double count1, double count2, double count3, double count4, double count5);
}
