## 🌊 프로그램 동작 흐름

---

1. 사용자로부터 구입 금액을 입력받는다.
2. 구입 금액에 맞게 -개의 자동 생성 `Lotto` 객체를 생성한다.
3. 과정 2에서 생성한 객체들에 대한 정보를 출력한다.
4. 사용자로부터 당첨 번호 한번에 입력받는다.
5. 사용자로부터 보너스 번호를 입력받는다.
6. 당첨 번호와 보너스 번호를 이용해 `WinningNumbers`객체를 생성한다. 
7. 과정 2에서 생성한 객체들과 과정 6에서 생성한 객체를 비교하여 당첨 통계 정보를 얻는다.
8. 과정 7에서 얻은 당첨 통계 정보를 출력한다.



## 📃 기능목록

---

### `class LottoGameController` [ - ]

로또 게임의 전체적인 과정을 컨트롤하는 기능

- `void runGame()` [ - ]

### `class ConsoleInputView` [ - ]

콘솔 입력 관련 기능

- `int readInteger()` [ - ]

  콘솔로부터 정수를 하나 입력받는 기능

- `List<int> readIntegers()` [ - ]

  콘솔로부터 쉽표로 구분된 여러 개의 정수를 한 번에 입력받는 기능

### `class ConsoleOutput` [ - ]

콘솔 출력 관련 기능

- `void println(String)` [ - ]

  콘솔에 문자열을 출력하는 기능

- `void println(List<T>)` [ - ]

  콘솔에 여러 개의 변수를 리스트 형식으로 출력하는 기능

- `void printlnError(String)` [ - ]

  예외 상황 시 콘솔에 에러 문자열을 출력하는 기능

### `class Payment` [ - ]

구입 금액 관련 기능

- `Payment(int)` [ - ]
  
  1000원 단위인지 확인 후 객체 생성

- `int getLottoCount()` [ - ]

  구입 금액으로 살 수 있는 로또 갯수를 계산하는 기능

### `class Lotto` [ - ]

로또 관련 기능

- `Lotto(List<Integer>)` [ O ]

  정수 리스트의 정수 갯수, 각 정수가 특정 범위에 속하는 지 등을 확인 후 객체 생성

- `LottoResult check(WinningNumbers)` [ - ]

  해당 `Lotto`의 당첨 결과를 확인하는 기능 

### `class LottoGenerator` [ - ]

로또 생성 관련 기능

- `static Lotto autoGenerate()` [ - ]

  무작위 로또 번호를 만들어 자동 로또를 생성하는 기능  

### `class WinningNumbers` [ - ]

당첨 번호 관련 기능

### `class WinningNumbersGenerator` [ - ]

당첨 번호 생성 관련 기능

- `static WinningNumbers generate(List<Integer>, int)` [ - ]
  
  당첨 번호 생성하는 기능

### `enum LottoResult` [ - ]

당첨 결과 관련 기능

- `int getPrize()` [ - ]

  당첨 결과의 상금을 얻어오는 기능

- `String getDescription()` [ - ]

  당첨 결과의 설명을 얻어오는 기능

### `class LottoStatistics` [ - ]

당첨 통계 관련 기능

- `String getHistoryDescription()` [ - ]

  당첨 내역 설명을 얻어오는 기능

- `String getReturnRateDescription()` [ - ]

  총 수익률 설명을 얻어오는 기능