# 로또

--- 

## 🚀 기능 요구 사항

### ✅ 구매 금액  입력

-  ✅ (e) 양의 정수 형태 이외 입력 : <BuyerValidator> isInteger(), isNatural()

```
"1000원", "$1000", "1,000", "-1000" 등 문자열이 있는 경우
```

-  ✅ (e) 1000 단위 이하 입력 : <BuyerValidator> is1000Unit()

```
15700, 24620 과 같이 1000으로 나눈 나머지가 있는 경우
```

-  ✅ 입력 후, 정수형 변환 : <Util> getInput() -> getInt()

### ✅ 구매 개수 계산

-  ✅ 구매금액 / 1000 : <Calculator> divide1000()

```
구매 금액 = 24000 , 구매 개수 = 24000/1000 = 24
```

### ✅ 로또 지갑 생성

- ✅ 로또 생성 : <Buyer> addLotto(), <Util> generateRandomNum();
  - ✅ 1~45 사이 정수 
  - ✅ pickUniqueNumbersInRange() 활용
  - ✅ 중복 불가
  
```
불가 항목
1. 1~45 사이 x
[1,2,3,4,5,50], [0,2,5,6,35,100]

2. 중복
[1,1,2,2,3,3], [20,24,24,42,43,44]
```

- ✅ 로또 번호 출력 : <OutputView> printBuyerLotto();
  - ✅ 오름차순 정렬

### ✅ 이번주 당첨 번호 입력

- ✅ 이번주 당첨 로또 생성 : <WinningLotto> Constructor
  - ✅ (e) 번호 6개 , 구분자 = "," : <WinningLottoValidator> isValidLottoSize()
  - ✅ (e) 문자 입력 불가 : <WinningLottoValidator> isInteger()
  - ✅ (e) 1~45 사이 정수 : <WinningLottoValidator> isValidRange()
  - ✅ (e) 중복 불가 : <WinningLottoValidator> isOverlap()
  - ✅ readLine() 사용

- ✅ 보너스 번호 생성
  - ✅ (e) 문자 입력 불가 : <BonusValidator> isInteger()
  - ✅ (e) 1~45 사이 정수 : <BonusValidator> isValidRange()
  - ✅ (e) 중복 불가 : <BonusValidator> isOverlap()
  - ✅ readLine() 사용

### ✅ 당첨 내역 출력 by Enum

- ✅ 숫자 일치 개수 
  - ✅ 번호 1개씩 당첨로또에 포함되어있는지 확인 : <WinningLotto> matchNumberCount()
  - ✅ 보너스는 따로 확인 : <WinningLotto> isMatchBonusNumber()
- ✅ 당첨 로또 개수
  - ✅ 경우 별 당첨로또 개수 저장 : <Calculator> CountOfRank()

### ✅ 수익률 출력

- ✅ 총 당첨 금액 : 총합(경우별 당첨금액 * 경우별 당첨 로또 개수) : <Calculator> getSumOfWinningAmount()
- ✅ 수익률 : 총 당첨 금액 / 구매 금액 : <Calculator> earnedRatio()
- ✅ 소수점 둘째자리 반올림 Math.round()

---

## 🎯 프로그래밍 요구사항

### ✅ Java 컨벤션

### ✅ indent = 2까지 허용

### ✅ 함수 최대한 작게 구성

### ✅ JUnit5, AssertJ를 이용하여 기능 테스트

### ✅ 함수 길이 15라인 이하, 한 가지 일만 하도록 구현

### ✅ else 예약어 금지

### ✅ Java Enum 적용

### ✔ 도메인 로직에 단위 테스트 구현

## Lotto Class

### ✅ 매개변수가 없는 생성자 추가 X

### ✅ numbers 접근 제어자 변경 X

### ✅ 필드 추가 X

### ✅ 패키지 변경 가능

---

## ✍ 피드백

### ✅ 기능 목록 업데이트

### ✅ 하드 코딩 X (클래스별 상수 지정)

### ✅ 상수 - 멤버 변수 - 생성자 - 메서드 순으로 작성

### ✅ 변수 이름에 자료형 사용 x


