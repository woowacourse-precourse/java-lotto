## 📝 구현 기능 목록

- [x] **`로또 시작 문구`를 출력하는 기능** - InputView

```
구입금액을 입력해 주세요.
```

- [x] **금액을 입력받는 기능 (Console API)**
    - [x] 문자열로 입력 받은 수를 int형으로 변환하는 기능
> 예외

- [x] 1,000단위로 나누어 떨어지지 않을 경우
- [x] 1,000원보다 작을 경우
- [x] 숫자가 아닐 경우

> 처리 (순서대로)

1. `IllegalArgumentException` 발생
2. `[ERROR]`로 시작하는 에러 메시지를 출력
3. 애플리케이션 종료

- [x] **`로또 구입 개수 문구`를 출력하는 기능** - OutputView

```
8개를 구매했습니다.
```

<br>

- [x] **랜덤으로 숫자를 생성하는 기능 (Randoms API)**
    - [x] 여섯 자리 수
    - [x] 1~45 사이의 수
    - [x] 각 자리 수는 모두 다름
    - [x] 오름차순으로 정렬하여 보여줄 것
    - [x] 금액 만큼 생성할 것
- [x] **당첨 번호를 입력받는 기능 (Console API)** - InputView

```
당첨 번호를 입력해 주세요.
```

> 예외

- [x] 1~45 사이의 수가 아닐 경우 - LottoResult
- [x] 중복되는 수가 있을 경우 - LottoResult
- [x] 6개가 아닐 경우 - LottoResult
- [x] 숫자가 아닐 경우 - InputView

> 처리 (순서대로)

1. `IllegalArgumentException` 발생
2. `[ERROR]`로 시작하는 에러 메시지를 출력
3. 애플리케이션 종료

- [x] **보너스 번호를 입력받는 기능 (Console API)** - InputView

```
보너스 번호를 입력해 주세요.
```

> 예외

- [x] 1~45 사이의 수가 아닐 경우 - LottoResult
- [x] 숫자가 아닐 경우 - InputView

> 처리 (순서대로)

1. `IllegalArgumentException` 발생
2. `[ERROR]`로 시작하는 에러 메시지를 출력
3. 애플리케이션 종료

<br>

- [x] **등수를 매기기 위한 등수리스트 생성 기능** - RankingCalculator
  - [x] 같은 수가 몇개 있는지 판단하는 기능 - RankingCalculator
  - [x] 당첨번호, 보너스번호에 따른 등수 판단 기능 - RankingCalculator
  - [x] 당첨번호, 보너스번호에 따른 등수 결과 리스트를 만드는 기능 - RankingCalculator

- [x] **등수를 매기는 기능** - Ranking Enum
  - [x] 등수 Enum - Ranking Enum
  - [x] 등수 리스트를 만드는 기능 - Ranking Enum
  - [x] 로또 하나에 대한 등수를 매기는 기능 - Ranking Enum

- [ ] **당첨 통계를 출력하는 기능** - OutputView
    - [x] 당첨 개수를 확인하는 기능 - GameResult
    - [x] 총 상금을 계산하는 기능 - GameResult
    - [x] 수익률을 계산하는 기능 - NumberOfLottos

```
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```