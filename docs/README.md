## 기능목록

```
<구현 목표>
1. 클래스(객체)를 분리하는 연습
2. 도메인 로직에 대한 단위 테스트를 작성하는 연습
```

1. 입력
   - 입력값 검증
     - 로또 
       - 1장 당 1000원 -> 1000원 단위로 입력하지 않은 경우 에러 발생
       - 1장 당 가격으로 나눠서 몇장 구매했는지 확인 -> 그거에 맞춰서 로또 리스트 생성
     - 당첨 번호 
       - , 기준으로 안보낼 경우 예외 발생
       - 1 ~ 6개 입력 안한 경우 예외 발생
     - 보너스 번호
       - 1개 이상 입력한 경우 예외 발생
     - 중복된 값 입력 시 예외 발생
2. 당첨
    - 1등 ~ 5등에 대한 enum 정의 `key: count, value: 당첨금액`
    - 수익률 계산 `수익률 = (얻게된 수익/원금) * 100`
      - 수익 == 당첨 금액, 원금 == 입력값
3. 예외 클래스 작성
   - static final 상수 -> `"[ERROR]"` 생성
   - 잘못된 값 입력(validate error) -> `IllegalArgumentException`
     - 각 예외 던질 때 붙여서 전달

---

### 기능적 요구사항
- 프로그램 종료 시 System.exit()를 사용 금지
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현. 2까지만 허용
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 
- 3항 연산자를 사용 금지
- 기능 목록이 정상 동작함을 테스트 코드로 확인

### 비기능적 요구사항
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현
- Java Enum을 적용
- 도메인 로직에 단위 테스트를 구현


## 커밋 컨벤션

- 영어로 작성
- `type: detail text` 형태로 작성
- type
    - feat (feature)
    - fix (featrue fix and bugfix)
    - docs (documentation)
    - style (formatting, missing semi colons, …)
    - refactor
    - test (when adding missing tests)
