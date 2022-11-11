## 어려웠던 점
### Immutable List , UnsupportedOperationException

```java
class LearnImmutableList { 
    List unmodifiableList = Collections.unmodifiableList(list);
    List newList = new ArrayList(unmodifiableList);
    Collections.sort(newList);
}
```

### 예외 처리
* 예외 처리 위치
* 꼼꼼한 예외 처리
* 테스트코드 작성시, 예외 발생 테스트