package lotto.service;


import lotto.domain.GameSet;

public interface LottoService {
    GameSet startGame();
    void generateAwardLotto();
    void play();
    void generateLotto();
}
