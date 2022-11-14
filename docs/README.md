# 📝 기능 목록 & ⛔️ 예외 상황

`사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시킨다. "[ERROR]"로 시작하는 에러 메시지를 출력한 후 종료한다.`

## 입출력

### InputView

- [ ] 게임 시작시 `구입금액을 입력해 주세요.` 콘솔에 출력 후 입력을 받는다.
- [ ] 구입한 로또 출력 후 `당첨 번호를 입력해주세요.` 콘솔에 출력 후 입력을 받는다.
- [ ] 당첨 번호 입력 후 `보너스 번호를 입력해 주세요.` 콘솔에 출력 후 입력을 받는다.

### OutputView

- [ ] 발행한 로또 수량 및 번호를 출력한다. `n개를 구매했습니다.`, `[1, 2, 3, 4, 5, 6]`
- [ ] 당첨 통계에 대한 정보를 출력한다.
```
예시)
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

### InputConverter
- [x] String Input ➡️ Integer로 변환 (구입 금액)
  - [x] 구입 금액이 숫자 이외에 문자가 존재할 경우 IllegalArgumentException 발생 시킨다.
  - [x] 보너스 번호가 숫자 이외에 문자가 존재할 경우 IllegalArgumentException 발생 시킨다.
  
- [ ] String Input ➡️ `List<Integer>`로 변환 (당첨 번호)
  - [ ] **숫자, 쉼표`,` 이외에 문자**가 존재하는 경우 IllegalArgumentException 발생 시킨다. (`,` split 진행 후 각각 Integer.parseInt 예외가 발생한다.)


### InputValidator

- [ ] InputConverter를 통해 변환된 구입 금액이 올바른 값인지 검사한다.
    - [ ] 1,000원 단위 입력이 아닐 경우 IllegalArgumentException 발생 시킨다. (1000으로 나눴을 때 나머지가 0이 아닐 때 예외가 발생한다.)


- [ ] InputConverter를 통해 변환된 당첨 번호를 올바른 값인지 검사한다.
    - [ ] `1~45` **범위 이외의 숫자**일 경우 IllegalArgumentException 발생 시킨다. (범위 체크 메서드 return 값이 false일 경우 예외가 발생한다. )
    - [ ] 당첨 번호의 갯수가 6개가 아닌 경우 IllegalArgumentException 발생 시킨다. (size 체크시 6이 아닐 시 예외가 발생한다.)
    - [ ] 중복된 숫자가 존재하는 경우 IllegalArgumentException 발생 시킨다. (stream 이용하여 distinct().count()와 size가 다를 경우 예외가 발생한다.)

- [ ] InputConverter 를 통해 변환된 보너스 번호가 올바른 값인지 검사한다.
    - [ ] 위의 당첨 번호 예외 처리를 이용한다.


## Lotto

### Lotto
- [x] 유효한 랜덤 6자리 숫자를 생성한다.

### LottoNumbersValidator
- [x] 유효한 로또 번호인지 구분한다.

### LottoRank
- [x] 당첨 번호와 상금을 정의한 Enum




## 🎯 프로그래밍 요구 사항

### *** Commit & Push 전에 항상 요구 사항을 보고 코드 검증을 해야한다.***

- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 테스트 코드가 돌아가는지 확인해야 한다.
- 기능별 테스트 코드로 확인한다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다. `함수는 한 가지 일만 잘 하도록 구현한다.`
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
- Java Enum을 적용한다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
- `Lotto`에 매개 변수가 없는 생성자를 추가할 수 없다.
- `numbers`의 접근 제어자인 private을 변경할 수 없다.
- `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
- `Lotto`의 패키지 변경은 가능하다.
