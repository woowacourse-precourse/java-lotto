### 기능 요구 사항
1. 사용자는 로또 구입 금액을 입력한다.
2. 사용자는 당첨 번호(숫자 6개)를 입력한다. 쉼표(,)를 구분자로 한다. 
3. 사용자는 보너스 번호(숫자 1개)를 입력한다.
4. 시스템은 (사용자가 입력한 로또 구입 금액//1,000) 만큼 로또(숫자 7개)를 랜덤으로 생성한다.
5. 생성된 로또와 당첨 번호+보너스 번호를 비교하여 맞은 개수를 비교한다.
6. 수익률(수익/구입 비용)을 출력한다.

> __당첨금__
> - 3개 일치 -> 5,000원
> - 4개 일치 -> 50,000원
> - 5개 일치 -> 1,500,000원
> - 5개 일치, 보너스 볼 일치 -> 30,000,000원
> - 6개 일치 -> 2,000,000,000원

> __수익률 출력 범위__<br>
> 소수점 둘째 자리에서 반올림

### 기능 분리
> ㅁ(통합 테스트)-ㅁ(기능 구현 순서)-ㅁ(단위 테스트) ==> 최종 인수 테스트 진행

__User__
- BuyLotto : 로또 구입 금액 입력 __(1-2)__
- SetWinNumber : 당첨 번호 설정 __(2-2)__
  - ValidateWinNumberType : 당첨 번호에 숫자 이외의 문자가 포함되어 있는지 확인 __(2-2-1)__ - ValidateInputType
  - ValidateWinNumberReplicate : 당첨 번호에 중복 숫자가 포함되어 있는지 확인 __(2-2-2)__ - 오버로딩
  - ValidateWinNumberLength : 당첨 번호가 6자리인지 확인 __(2-2-3)__ - ValidateNumberLength
- SetBonusNumber : 보너스 번호 설정 __(3-2)__
  - ValidateBonusNumberType : 보너스 번호가 숫자가 아닌 문자인지 확인 __(3-2-1)__ - ValidateInputType
  - ValidateBonusNumberRange : 입력받은 보너스 번호가 1-45 사이의 값인지 확인 __(3-2-2)__ - ValidateNumberRange
  - ValidateBonusNumberReplicate : 보너스 번호가 당첨 번호와 중복되는지 확인 __(3-2-3)__ - 오버로딩

__System__
- PrintPurchaseGuide : 구입 금액을 입력해달라는 안내문 출력 __(1-1)__
- PurchaseLotto : 구입 로또 개수 산출 __(1-3)__
  - ValidateMoneyType : 구입 금액에 숫자 이외의 문자가 포함되어 있는지 확인 __(1-3-1)__ - ValidateInputType
  - ValidateMoneyUnit : 구입 금액이 1,000원 단위인지 확인 __(1-3-2)__
- PrintPurchaseLotto : 구입 로또 개수 출력 __(1-4)__
- PrintWinNumberGuide : 당첨 번호를 입력해달라는 안내문 출력 __(2-1)__
- PrintBonusNumberGuide : 보너스 번호를 입력해달라는 안내문 출력 __(3-1)__
- CompareWithWinNumber : 당첨 번호와 로또 번호 비교 __(4-1)__
- CompareWithBonusNumber : 보너스 번호와 로또 번호 비교 __(4-2)__
- PrintStatistics : 당첨 통계 출력 __(4-3)__
- CalculateProfit : 수익률 계산 __(5-2)__
  - ProfitRondOff : 수익률 둘째 자리에서 반올림 __(5-2-1)__
- PrintProfit : 수익률 출력 __(5-3)__

__Enum__
- Rank __(5-1)__

__Module__
- ValidateNumberRange : 입력받은 숫자가 1-45 사이의 값인지 확인
- ValidateInputType : 입력받은 값에 숫자가 아닌 문자가 포함되어 있는지 확인
- ValidateNumberLength : 입력받은 숫자의 개수가 입력받은 개수와 맞는지 확인

### 예외 처리
> 예외 상황 시 `IllegalArgumentException`를 발생시키고, 포맷에 맞게 에러를 출력한 후 시스템을 종료한다.<br>
> `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`

1-a. 숫자가 아닌 문자를 입력받는 경우<br>
`[ERROR] 구입 금액 숫자여야 합니다.`<br>
1-b. 구입 금액이 1,000원으로 나누어 떨어지지 않은 경우<br>
`[ERROR] 구입 금액을 1,000원 단위로 입력해주세요.`<br>
2-a. 숫자가 아닌 문자를 입력받는 경우<br>
`[ERROR] 로또 번호는 숫자여야 합니다.`<br>
2-b. 입력받은 당첨 번호가 6개가 아닐일 경우<br>
`[ERROR] 로또 당첨 번호가 6개 미만입니다.`<br>
2-c. 입력받은 당첨 번호 중 1-45 범위에 없는 숫자가 존재할 경우<br>
`[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`<br>
3-a. 숫자가 아닌 문자를 입력받는 경우<br>
`[ERROR] 보너스 번호는 숫자여야 합니다.`<br>
3-b. 입력받은 보너스 번호가 1개 미만을 경우<br>
`[ERROR] 보너스 번호가 1개 미만입니다.`<br>
3-c. 입력받은 보너스 번호가 1개 초과일 경우<br>
`[ERROR] 보너스 번호가 1개 초과입니다.`<br>
3-d. 입력받은 보너스 번호가 1-45 범위에 없는 숫자일 경우<br>
`[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`<br>

### 기타 유의 사항
- JDK 11버전에서 실행 가능
- 외부 라이브러리 사용 불가
- Java 코드 컨벤션 가이드 준수
- 프로그램 종료 시 `System.exit()` 호출 금지
- indent depth 3 미만으로 구현
- 3항 연산자 사용 불가
- 함수의 크기를 최대한 작게 생성
  - 15라인 이하로 작성
- 도메인 로직에 단위 테스트를 구현
  - UI(System.out, System.in, Scanner) 로직 제외
- else 예약어 사용 불가
  - switch/case 사용 불가
- Java Enum 적용
- `camp.nextstep.edu.missionutils` 라이브러리 활용
  - Randoms / Console
- `Lotto` 클래스를 활용해 구현
  - 매개 변수가 없는 생성자 추가 금지
  - `numbers` private 변경 금지
  - `Lotto`에 인스턴스 변수 추가 금지
  - `Lotto` 패키지 변경 가능
- 커밋 메시지 컨벤션 가이드 준수