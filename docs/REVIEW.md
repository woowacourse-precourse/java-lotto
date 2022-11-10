Immutable List , UnsupportedOperationException

```java
class LearnImmutableList { 
    List unmodifiableList = Collections.unmodifiableList(list);
    List newList = new ArrayList(unmodifiableList);
    Collections.sort(newList);
}
```
