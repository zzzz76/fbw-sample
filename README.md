# Fizz Buzz Whizz sample

本工程并不是最快、最简洁或圈复杂度最低的标准答案，是为了向大家展示可能性而故意做的略微复杂的示例。*也就是说大家的答案完全没必要做到这种程度，不要方。*

基于 JDK8 ，使用了如下所述的特性与第三方库：

- Maven
- stream API（JDK8）
- lambda expression（JDK8）
- Spring Boot
- Guava
- Junit
- AssertJ

推荐使用 Intellij IDEA 打开本工程。

## 如何打包

请在工程根目录运行 `mvn clean package` 编译并打包整个工程

## 如何运行

两种方式：

- 使用 IDE 导入工程后，直接运行 `io.terminus.fbw.Application` 并在 `Input here: ` 的提示后输入逗号分隔的数字
- mvn 打包完成后在根目录执行 `java -jar target/fbw-game.jar`
  - 上述命令可以带参数，如逗号分隔的数字：`java -jar target/fbw-game.jar '3, 5, 7'`
  - 也可以带三个参数：`java -jar target/fbw-game.jar 3 5 7`
  - 或者不带参数，在运行后与 `Input here: ` 提示后输入逗号分隔的数字
  
## 如何运行单元测试

- 于工程根目录运行 `mvn test` 即可，实际上 `mvn package` 时也会运行单元测试
- 使用 IDE 导入工程，运行 `src/test/java` 目录下的单元测试
