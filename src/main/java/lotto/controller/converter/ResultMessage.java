package lotto.controller.converter;

import lotto.domain.info.Rank;

import java.util.List;

public interface ResultMessage {
    void printResult(List<Rank> ranks, int price);
}
