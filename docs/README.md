# 미션 - 로또

## 기능 목록

### 입력

- 로또 구입 금액을 입력하는 기능
  - 입력한 문자열이 숫자로 치환이 가능한지 검증하는 기능
  - 입력한 문자열이 1000원 단위인지 검증하는 기능
- 로또 당첨 번호를 입력하는 기능
  - 입력한 문자열이 적합한 길이를 가지고 있는지 검증하는 기능
    - 11(한 자릿수 숫자 6개 길이 6 + 구분자 5) ~ 17(두 자릿수 숫자 6개 길이 12 + 구분자 5)
  - 입력한 문자열에 쉼표가 존재하는지 검증하는 기능
  - 입력한 문자열의 숫자가 치환이 가능한지 검증하는 기능
  - 입력한 문자열의 숫자가 1 ~ 45까지의 범위에 있는지 검증하는 기능
- 로또 보너스 번호를 입력하는 기능
  - 입력한 문자열의 숫자가 치환이 가능한지 검증하는 기능
  - 입력한 문자열의 숫자가 1 ~ 45까지의 범위에 있는지 검증하는 기능

### 출력

- 로또 구입 금액 입력 안내 문구를 출력하는 기능
- 발행한 로또 수량을 출력하는 기능
- 발행한 모든 로또의 번호를 출력하는 기능
  - 오름차순으로 출력
- 로또 당첨 번호 입력 안내 문구를 출력하는 기능
- 계산한 당첨 결과를 출력하는 기능
- 계산한 수익률을 출력하는 기능
  - 소수점 둘째 자리에서 반올림한 결과를 출력

### 로직

- 발행할 로또 수량을 계산하는 기능
- 발행할 로또 수량만큼 로또를 발행하는 기능
- 발행한 로또와 로또 당첨 번호를 비교해 당쳠 결과를 계산하는 기능
- 계산한 당첨 결과를 출력하는 기능
- 수익률을 계산하는 기능
- 계산한 수익률을 출력하는 기능

### 예외

- 로또 구입 금액 입력 시
  - 입력한 문자열이 숫자로 치환이 불가능할 때 예외 발생
  - 입력한 문자열이 1000원 단위가 아닐 때 예외 발생
- 로또 당첨 번호 입력 시
  - 입력한 문자열의 길이가 11 ~ 17이 아닐 때 예외 발생
  - 입력한 문자열에 숫자와 쉼표 외의 문자가 포함되었을 때 예외 발생
  - 입력한 문자열의 숫자가 1 ~ 45까지의 범위가 아닐 때 예외 발생
  - 입력한 문자열의 숫자가 중복되었을 때 예외 발생
- 로또 보너스 점수 입력 시
  - 입력한 문자열이 숫자가 아닐 시 예외 발생
  - 입력한 문자열의 숫자가 1 ~ 45까지의 범위가 아닐 때 예외 발생

## 애플리케이션 진행 순서

0. 애플리케이션 시작
1. 로또 구입 금액 입력 안내 문구 출력
2. 로또 구매 금액 입력
3. 발행할 로또 수량 계산
4. 계산한 로또 수량 출력
5. 발행할 로또 수량만큼 로또 발행
6. 발행한 모든 로또 번호 출력
7. 로또 당첨 번호 입력 안내 문구 출력
8. 로또 당첨 번호 입력
9. 로또 보너스 번호 입력
10. 로또 당첨 결과 및 수익률 계산
11. 로또 당첨 결과 및 수익률 출력
12. 애플리케이션 종료

## 패키지 구조

### src/main/java

```
└── src
    └── main
        └── java
            └── lotto
                ├── Application.java
                ├── GameRunner.java
                ├── domain
                │   ├── number
                │   │   ├── Lotto.java
                │   │   └── LottoNumber.java
                │   └── player
                │       ├── LottoPurchaseAmount.java
                │       └── Player.java
                ├── mvc
                │   ├── controller
                │   │   └── LottoGameController.java
                │   ├── model
                │   │   ├── LottoResult.java
                │   │   └── LottoStore.java
                │   ├── util
                │   │   ├── LottoGameStatus.java
                │   │   ├── LottoRanking.java
                │   │   ├── ProcessType.java
                │   │   ├── exception
                │   │   │   └── NotFoundViewMessageException.java
                │   │   └── message
                │   │       ├── InputViewMessageUtils.java
                │   │       └── LottoRankingMessageUtils.java
                │   └── view
                │       └── ConsoleView.java
                └── util
                    ├── message
                    │   ├── CommonMessageConst.java
                    │   ├── LottoExceptionMessageUtils.java
                    └── number
                        ├── LottoNumberConst.java
                        └── LottoNumberFactory.java
```

- `GameRunner` : 로또 게임을 진행하는 유틸리티 클래스
- `domain`
  - `number`
    - `Lotto` : 로또 숫자(`LottoNumber`) 6개를 관리하는 클래스
    - `LottoNumber` : 로또 숫자로 사용되는 숫자를 관리하는 `Wrapper` 클래스
  - `player`
    - `LottoPurchaseAmount` : 플레이어가 입력한 로또 구입 금액을 관리하는 클래스
    - `Player` : 플레이어 구입 금액과 플레이어가 구매한 로또를 관리하는 클래스
- `mvc`
  - `controller`
    - `LottoGameController` : 플레이어의 요청을 받아 필요한 로직을 수행하고 `View`에게 필요한 메세지를 출력하도록 전달하는 클래스
  - `model`
    - `LottoResult` : 로또 게임의 결과(로또 등수, 수익률)를 관리하는 클래스
    - `LottoStore` : 로또 게임의 플레이어 정보와 로또 당첨 번호를 관리하는 클래스
  - `util`
    - `LottoGameStatus` 로또 게임 상태를 관리하는 `enum`
    - `ProcessType` : 로또 게임 상태가 단순 입력 안내 문구인지, 로직을 수행해야하는지 구분하는 `enum`
    - `LottoRanking` : 로또 당첨 등수 정보를 관리하는 `enum`
    - `exception`
      - `NotFoundViewMessageException` : `View` 메세지를 찾지 못했을 때 발생하는 예외
    - `message`
      - `InputViewMessageUtils` : `LottoGameStatus`에 따라 필요한 플레이어 입력 안내 문구를 관리하는 `enum`
      - `LottoRankingMessageUtils` : 로또 당첨 메세지를 관리하는 `enum`
  - `view`
    - `ConsoleView` : `Console`에 전달받은 메세지를 출력하는 `View`
- `util`
  - `message`
    - `CommonMessageConst` : 예외 메세지 관련 공통 부분을 상수로 정의한 클래스
    - `LottoExceptionMessageUtils` : 예외 메세지를 관리하는 `enum`
  - `number`
    - `LottoNumberConst` : 로또 번호 관련 공통 부분을 상수로 정의한 클래스
    - `LottoNumberFactory` : `LottoNumber` 캐싱 객체를 정적 팩토리 메소드를 통해 제공하는 클래스

### src/test/java

```
└── src
    └── test
        └── java
            └── lotto
                ├── ApplicationTest.java
                ├── GameRunnerTest.java
                ├── common
                │     └── CommonExceptionTest.java
                ├── domain
                │     ├── argument
                │     │     ├── CalculateRevenueArgument.java
                │     │     ├── LottoResultTestArgument.java
                │     │     ├── LottoStoreTestArgument.java
                │     │     ├── LottoTestArgument.java
                │     │     └── PlayerTestArgument.java
                │     ├── number
                │     │     ├── LottoNumberTest.java
                │     │     └── LottoTest.java
                │     └── player
                │         ├── LottoPurchaseAmountTest.java
                │         └── PlayerTest.java
                ├── helper
                │     ├── exception
                │     │     ├── CannotReflectionException.java
                │     │     └── FieldNotFoundException.java
                │     ├── factory
                │     │     └── LottoStoreTestFactory.java
                │     ├── stub
                │     │     ├── StubLottoGameController.java
                │     │     └── StubWinningLotto.java
                │     └── util
                │         ├── LottoNumberTestUtils.java
                │         ├── LottoPurchaseAmountTestUtils.java
                │         ├── LottoRankingTestUtils.java
                │         ├── LottoResultTestUtils.java
                │         ├── LottoStoreTestUtils.java
                │         ├── LottoTestUtils.java
                │         ├── PlayerTestUtils.java
                │         ├── ReflectionFieldUtils.java
                │         └── TestArgumentUtils.java
                ├── mvc
                │     ├── controller
                │     │     └── LottoGameControllerTest.java
                │     ├── model
                │     │     ├── LottoResultTest.java
                │     │     └── LottoStoreTest.java
                │     └── util
                │         ├── LottoGameStatusTest.java
                │         ├── LottoRankingTest.java
                │         └── message
                │             ├── InputViewMessageUtilsTest.java
                │             └── LottoRankingMessageUtilsTest.java
                └── util
                    ├── message
                    │     └── LottoExceptionMessageUtilsTest.java
                    └── number
                        └── LottoNumberFactoryTest.java
```

- `lotto`
  - `common`
    - `CommonExceptionTest` : `IllegalArgumentException` 관련 예외 검증 로직을 공통 처리한 클래스
  - `domain`
    - `argument` : `@MethodSource`를 통해 사용할 테스트 매개변수를 정의한 클래스가 위치한 패키지
  - `helper`
    - `exception` : 테스트를 위한 `Reflection` 진행 도중 실패 시 발생하는 예외 클래스가 위치한 패키지
    - `factory` : 테스트를 위한 특정 객체를 생성해 반환하는 클래스가 위치한 패키지
    - `stub` : 테스트를 위해 정의한 구체적인 방식대로만 동작하는 `Stub` 클래스가 위치한 패키지
    - `util` : 테스트를 위해 `Reflection` 기능을 수행하는 유틸리티 클래스가 위치한 패키지