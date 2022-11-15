# 로또

---

## 기능

- 프로그램은 사용자에게로 부터 구입 금액을 입력받는다.
- 구입 금액은 1000원 단위이다.
- 구입 금액이 1000원으로 나누어떨어지지 않을 경우 예외 처리한다.
- 프로그램은 사용자에게로 부터 당첨 번호를 입력받는다.
- 당첨 번호는 1~45범위의 수 6개이다.
- 당첨 번호는 `','`로 나누어져있다.
- 당첨 번호가 숫자가 아니거나 1~45범위를 넘으면 예외처리한다.
- 당첨 번호가 `','`로 나누어져 있지 않으면 예외처리한다.
- 프로그램은 사용자에게로 부터 보너스 번호를 입력받는다.
- 보너스 번호는 1~45범위의 수 1개이다.
- 보너스 번호가 숫자가 아니거나 1~45범위를 넘으면 예외처리한다.
- 프로그램은 구입 금액을 통해 로또 발행 수를 구한다.
- 프로그램은 로또 발행 수를 화면에 출력한다.
- 프로그램은 로또 발행 수 만큼 로또 번호를 생성한다.
- 발행된 로또 번호는 1~45범위의 임의의 수 6개이다.
- 발행된 로또 번호는 오름차순으로 정렬되어 있다.
- 프로그램은 당첨 번호와 로또 번호를 비교한다.
- 프로그램은 당첨 결과를 계산한다.
- 프로그램은 당첨 결과를 출력한다.
- 프로그램은 당첨 결과와 구입 금액으로 수익률을 계산한다.
- 프로그램은 수익률을 출력한다.
- 수익률은 소수점 둘째자리에서 반올림한다.
- 예외처리는 `"[ERROR]"`로 시작하는 에러문구를 출력해야한다.
- 예외처리후 프로그램은 종료한다.

---

## 시나리오

1. 사용자가 로또 구매 금액을 입력한다.
2. 로또 발행기에서 로또 구매 금액을 입력받아 로또를 발행한다.
3. 당첨 번호를 입력받는다.
4. 당첨 번호와 발행된 로또를 비교하여 당첨을 확인한다.
5. 당첨결과를 사용자에게 출력한다.
6. 수익률도 출력한다.

---

## 객체 설계

프로그램의 핵심 기능이 되는 부분과 사용자와 프로그램이 연결된 부분을 나누어보자.

**요구사항 중 변화할 수 있는 부분을 고려하여 설계해보자.**
- 구입금액
- 번호 범위
- 당첨 번호를 나누는 문자
- 당첨 번호를 얻는 방식

### 핵심 기능

1. 프로그램은 로또 발행 수 만큼 로또 번호를 생성한다.
2. 프로그램은 당첨 번호와 로또 번호를 비교한다.
3. 프로그램은 당첨 결과를 계산한다.
4. 프로그램은 당첨 결과와 구입 금액으로 수익률을 계산한다.

#### Lotto

로또 ***클래스***

- 기존의 메서드와 필드 사용
- 추가: 다른 로또와 비교하여 같은 수가 얼마나 있는지를 반환한다.
  - `Integer compare(Lotto other)`

#### LottoPublisher

로또를 발행하는 ***클래스***

- 로또의 메타데이터를 갖는다.
  - `private final LottoMetadata lottoMetadata`
- 개수를 입력받아 로또를 발행한다.
  - `List<Lotto> purchase(Integer num)`

#### LottoWinningChecker

로또의 결과를 계산하는 ***클래스***

- 로또의 메타데이터를 갖는다.
  - `private final LottoMetadata lottoMetadata`
- 로또 정보를 받아 로또 결과를 계산한다.
  - `Map<Prize, Integer> countWinningLotto(Lotto target, Integer bonus, List<Lotto> lottos)`

#### Prize

로또의 상을 나타내는 ***열거형***

- FIRST, SECOND, THIRD, FOURTH, FIFTH

#### LottoMetadata

로또의 기본 정보를 나타내는 ***클래스***

- 로또 숫자 범위의 처음 시작을 의미한다. 해당 숫자를 포함한다.
  - `private final Integer startNumberInRange`
- 로또 숫자 범위의 처음 끝을 의미한다. 해당 숫자를 포함한다.
  - `private final Integer endNumberInRange`
- 로또 한 장당 가격을 의미한다.
  - `private final Integer wonPerLotto`
- 로또 당첨의 표를 의미한다.
  - `private final Map<Map.Entry<Integer, Boolean>, Prize> prizeTable`

### 입출력 기능

1. 프로그램은 사용자에게로 부터 구입 금액을 입력받는다.
   - 구입 금액은 1000원 단위이다.
   - 구입 금액이 1000원으로 나누어떨어지지 않을 경우 예외 처리한다.
2. 프로그램은 사용자에게로 부터 당첨 번호를 입력받는다.
   - 당첨 번호는 1~45범위의 수 6개이다.
   - 당첨 번호는 `','`로 나누어져있다.
   - 당첨 번호가 숫자가 아니거나 1~45범위를 넘으면 예외처리한다. 
   - 당첨 번호가 `','`로 나누어져 있지 않으면 예외처리한다.
3. 프로그램은 사용자에게로 부터 보너스 번호를 입력받는다.
   - 보너스 번호는 1~45범위의 수 1개이다.
   - 보너스 번호가 숫자가 아니거나 1~45범위를 넘으면 예외처리한다.
4. 프로그램은 로또 발행 수를 화면에 출력한다.
5. 프로그램은 수익률을 출력한다.
   - 수익률은 소수점 둘째자리에서 반올림한다.
6. 예외처리는 `"[ERROR]"`로 시작하는 에러문구를 출력해야한다.
7. 예외처리후 프로그램은 종료한다.

#### LottoSystem

로또 구매부터 결과 확인까지 로또의 모든 프로세스를 사용자에게 제공하는 ***인터페이스***

- 로또 구매를 안내한다.
  - `Integer askFeeFronUser()`
- 로또들을 구매한다.
  - `List<Lotto> purchaseMultipleLotto(Integer payment)`
- 로또들을 보여준다.
  - `void showMultipleLotto(List<Lotto> lottos)`
- 당첨 번호를 얻는다.
  - `void setNumbersByUser()`
- 당첨 결과를 알린다.
  - `void announceResult(List<Lotto> lottos)`

#### StdIOLottoSystem

표준 입출력을 이용해 로또 구매부터 결과 확인까지 로또의 모든 프로세스를 사용자에게 제공하는 ***클래스***

`LottoSystem`을 구현한다.

- 로또의 메타데이터를 갖는다.
  - `private final LottoMetadata lottoMetadata`
- 로또 발행기를 갖는다.
  - `private final LottoPublisher lottoPublisher`
- 로또 당첨확인기를 갖는다.
  - `private final LottoWinningChecker lottoWinningChecker`
- 당첨 번호를 갖는다.
  - `private final Lotto winningNumber`
- 보너스 번호를 갖는다.
  - `private final Integer bonusNumber`
