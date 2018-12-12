# serializeUtil
Here are some common serialization tools in Java, including FST、.hessian、Protostuff、.kryo

### 使用说明

util 包下有四个Util 工具类，由其命名可知它们分别代表着Fst、Hessian、.kryo、Protostuff 的工具包。每个工具包有两个基本的方法：`serialize()`和`deserialize()` 分别代表着基本的序列化和反序列化操作。

`serialize()`将基本对象Object 序列化为byte 数组，而`deserialize()` 将byte[] 数组反序列化为基本对象Object 。

### 测试

test 包下有四个test case 分别对应着四个工具包的测试：（测试的对象是一个有12个属性字段的User 对象）

1. fst 测试结果：
    ```angular2html
    序列化耗时：58ms
    码流大小为：48 byte
    反序列化耗时：6ms
    ``` 
2. hessian 测试结果：
    ```angular2html
    序列化耗时：233ms
    码流大小为：179 byte
    反序列化耗时：6ms
    ```
3. kryo 测试结果：
    ```angular2html
    序列化耗时：297ms
    码流大小为：56 byte
    反序列化耗时：4ms
    ```
4. protoStuff 测试结果：
    ```angular2html
    序列化耗时：259ms
    码流大小为：77 byte
    反序列化耗时：6ms
    ```

> 声明：测试结果可能并不反映真实性能，仅供参考！！！