package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 로또들을 관리하는 일급 컬렉션
 */
public final class Lottos {
    private static final String NULL_MESSAGE = "Lottos 를 생성할 때 null 이 들어왔습니다";
    private final List<Lotto> lottos;

    /**
     * 로또들을 받아서 일급 컬렉션을 행성한다
     *
     * @param lottos null 이 아닌 로또 리스트
     */
    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = Collections.unmodifiableList(lottos);
    }

    private void validate(List<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    /**
     * 로또들을 stream 형태로 반환해준다
     *
     * @return Stream<Lotto> 형태로 되어있는 stream
     */
    public Stream<Lotto> toStream() {
        return lottos.stream();
    }

    /**
     * 로또들의 숫자
     *
     * @return 숫자에 해당하는 int 값
     */
    public int size() {
        return lottos.size();
    }
}
