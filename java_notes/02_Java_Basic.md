# Java 基础语法

## 摘要

```java
javac HelloWorld.java // 编译.java文件得到.class
java HelloWorld // 解释执行.class文件
```

* 类名：类名的每个单词都应该大写，驼峰命名；一个文件只能有一个`public class`
* 方法名/函数名：方法名以小写字母开头，后续单词首字母大写
* 源文件名：源文件名必须和类名相同，后缀为`.java` 
* 主方法入口：所有的Java程序都由`publid static void main(String[] args)`开始
* Java 标识符：首字符可以是字母、美元符、下划线开始，后续可以有数字
* Java 修饰符：`default`, `public`, `protected`, `private`, `final`, `abstract`, `static` 
* Java 变量：局部变量，类变量（静态变量），成员变量（非静态变量）

## Java中的类

* 构造方法：创建对象时至少要调用一个构造方法，构造方法的名称必须与类名相同。可以有多个重名的构造方法，但是参数类型应当区别。

  ```java
  public class Puppy{
      public Puppy(){
      }
      public Puppy(String name){
          // 这个构造器仅有一个参数：name
      }
  }
  ```

* 创建对象：`Puppy myPuppy = new Puppy( "tommy" );`
  1. 声明 Declaration - 对象名称和对象类型
  2. 实例化 Instantiation  - 使用`new`关键字来创建一个新的对象
  3. 初始化 Initialization- 调用构造方法初始化对象。

* 源文件声明规则
  1. 一个源文件中只能由一个`public class`，可以有多个非public的类
  2. 源文件的名称应该和`pulic class`的类名保持一致
  3. 如果一个类定义在某个包中，那么package语句应该在源文件的首行
  
* 不可变类 Immutable Class

  1. 所有的数据域都是私有的
  2. 没有可以修改上述数据域的修改器方法
  3. 如果有方法返回可变数据域，那么一定要做深拷贝；不可以直接返回可变类型如数组
  4. 注意：类声明为`final`，类的数据域也声明为`final`，

##  Java 基本数据类型

* Java中两大数据类型：内置数据类型；引用数据类型

  1. 内置数据类型 - 声明之后不初始化有默认值

     整数型：`byte 8`, `short 16`, `int 32`, `long 64`

     浮点型：`float 32`, `double 64`

     其他类型：`boolean 1`, `char 16 \u0000`

     * Java中的基本数据类型没有方法和属性，而包装类就是为了让这些拥有方法和属性，每个基本类型都有对应的包装类，即首字母大写。`int - Integer`, `char - Character`除外。包装类的初始值是null（是一个对象）。

     * Java中除了`Float`和`Double`的其他基本数据类型的包装类都有常量池，用于保存小数据。

  2. 引用数据类型 - 对象 + 数组

     **对象**（包括字符串-String类的对象）、**数组**都是引用数据类型

     所有引用类型的默认值都是`null`，一个引用变量可以用来引用任何与之兼容的类型

     

  * Java 常量

    常量在程序运行时是不能被修改的，通常用`fianl 大写字母`表示常量

    四种整数型的字面量都可以用十进制、八进制`0`、十六进制`0x`来表示

    字符串常量有一些特殊的转义字符序列：`\u 16进制Unicode字符`, `\ 8进制字符`, `\r 回车`, `\n 换行`, `\f 分页`,`\b 退格`, `\s 空格`, `\0 空字符`

  * 类型转换

    自动类型转换级别：`byte,short,char—> int —> long—> float —> double ` 

    强制类型转换：`(type)value`，浮点数到整数的转换是直接舍弃小数得到

    注意：转换可能导致溢出或者精度损失；`boolean`不可以进行类型转换

## Java 变量类型

* 局部变量：在方法、构造方法或者语句块中定义的变量称为局部变量

  1. 局部变量声明和初始化都在方法中，方法结束后，变量就会自动销毁；
  2. 局部变量是在**栈**上分配的；局部变量没有默认值，所以局部变量声明后必须初始化才可使用
  3. 访问修饰符不能用于局部变量，其作用域仅限于在声明它的方法、构造方法或者语句块中可见。

* 成员变量（实例变量）：声明在类中，但在方法、构造方法和语句块之外的变量。

  1. 当一个对象被实例化之后，每个实例变量的值就跟着确定。它在对象创建时被创建，在对象被销毁时销毁。
  2. 实例变量的值应该至少被一个方法、构造方法或者语句块引用，使得外部能够通过这些方式获取实例变量的信息。
  3. 实例变量可以声明在使用前或者使用后，因为其具有默认值。
  4. 实例变量可以直接通过变量名访问。但在静态方法以及其他类中，就应该使用完全限定名。

* 类变量（静态变量）：类变量声明在类中，方法体之外，但必须声明为`static`类型。

  1. 无论一个类创建了多少对象，类只拥有类变量的一份拷贝。
  2. 静态变量储存在静态存储区。经常被`final/static`声明为常量，很少单独使用 static 声明变量，初始化后不可改变。
  3. 与实例变量具有相似的可见性。但为了对类的使用者可见，大多数静态变量声明为 public 类型。
  4. 静态变量在第一次被访问时创建，在程序结束时销毁，可以通过`类名.变量名`的方式访问。

  注意：区别`final`和`static`：`final`修饰的属性表明是一个创建后不能被修改的常数，`static`修饰的属性强调它们只有一个即使对象不同也没有其他拷贝。

## Java 修饰符

* Java修饰符分为**访问控制修饰符**和非访问修饰符

* 访问控制修饰符：

  `default`：默认权限，即只有在同一包内可见。

  `private`：只能被所属类访问，并且类和接口不能声明为private

  `public`：默认的访问权限是public，能够被任何其他类访问

  `protected`：**未解决**

  单向继承：`public -> protected -> private`

* 非访问修饰符：  

  `fianl`：修饰的**变量**变量一旦赋值后，不能被重新赋值。被 final 修饰的实例变量必须显式指定初始值，通常和 static 修饰符一起使用来创建类常量。修饰的**方法**可以被子类继承，但是不能重写和修改。修饰的**类**不能被继承。

  `static`：静态**变量**，独立于对象，只有一份拷贝。静态**方法**，只能使用类的静态变量计算。

  `abstract`：抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。一个类不能同时被 abstract 和 final 修饰。如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。抽象类可以包含抽象方法和非抽象方法。

  `synchronized`：关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以叠加应用于四个访问修饰符。

  `transient`：序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型。

  `volatile`：修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。一个 volatile 对象引用可能是 null。

## Java 运算符

* 算数运算符：`+  -  *  /  %  ++  --`
* 关系运算符：`==  !=  >  <  >=  <=`
* 位运算符：`&  |  ^  ~  <<  >>  >>>  `
* 逻辑运算符：`&&  ||-短路  !`
* 条件运算符：`variable x = (expression) ? (value if true) : (value if false)`
* 赋值运算符：`=  +=  -=  *=  /=  %=  <<=  >>=  &=  ^=  !=`
* `instanceof`运算符：`variable x = (reference variable) instanceof (class/interface/type)`
* 运算符优先级：

## Java 循环

* `while`循环

  ```java
  while(expression) {
    //循环内容
  }
  ```

* `do...while`循环

  ```java
  do {
         //代码语句
  }while(布尔表达式);
  ```

* `for` 循环

  ```java
  for(init; expression; update) {
      //代码语句
  }
  ```

* 增强 `for` 循环

  ```java
  for(datatype var : iterable)
  {
     //代码句子
  }
  ```

## Java 条件/分支语句

1. 注意`if-else`if结构中用了`else if`就必须带上`else`，否则编译不通过
2. 条件判断语句一旦找到出口就会跳出判断，后续语句将不被执行

```java
if(布尔表达式 1){
   //如果布尔表达式 1的值为true执行代码
}else if(布尔表达式 2){
   //如果布尔表达式 2的值为true执行代码
}else if(布尔表达式 3){
   //如果布尔表达式 3的值为true执行代码
}else {
   //如果以上布尔表达式都不为true执行代码
}
```

**switch case 语句**

1. `switch`语句中的变量可以是`byte` `short` `int` `char`，后续也加入了`String`的支持
2. `case`语句可以有多个，但是其必须是和上述表达式类型相同的常量值或者字面值
3. 只要符合`case`的条件就进入分支，如果没有`break`就会顺序执行下述全部语句，直到`break`跳出
4. `default`语句通常放在最后表示无论`case`匹配情况如何总会执行的语句，

```java
switch(expression) {
    case value :
       //语句
       break; //可选
    case value :
       //语句
       break; //可选
    //你可以有任意数量的case语句
    default : //可选
       //语句
}
```

## java.lang 类

注意：下面讲的这些全都是对象！

* **Java Number 类**

  为了体现“面向对象”的基本思想，Java为基本数据类型都定义了对应的包装类

  `Object <- Number <- Byte, Short, Integer, Long, Float, Double` 

  `Object <- Boolean, Character`

* **Java Math 类**

  `Math.random()`：返回一个double类型的随机数

  `x.intValue()`：将x-一个Number的对象转换成byte/short/int/long/float/double

  `x.compareTo(Integer)`：将x-一个Number的对象和相同对象的Number对象进行比较

  `x.toString()或者Integer.toString(x)`：用于将Number的对象转换为**字符串**

  `Integer.parseInt(String s, int base)`：使用指定基数的字符串参数表示的**Integer**  

  `Integer.valueOf(String x, int base)`：将x转换为指定的Number类型，并可以指定原数的基

* **Java Character 类**

  `Character.isLetter(char x)`

  `Character.isDigit(char x)`

  `Character.isWhitespace(char x)`

  `Character.isUpperCase(char x)`

  `Character.isLowerCase(char x)`

  `Character.toUpperCase(char x)`

  `Character.toLowerCase(char x)`

* **Java String 类**

  以`String str = new String("hello")`为例

  `str.length()`：字符串长度

  `str1.concat(str2)`：连接两个字符串

  `String.format("a=%f" + "b=%d" + "e=%s", floatVar, intVar, strVar)` 返回可复用格式化字符串

  `char str.charAt(int index)`：返回指定位置的字符

  `int str.compareTo(String str)`：两个字符串进行比较

  `int str.compareToIgnoreCase(String str)`：忽略大小写进行比较

  `int str.indexOf(String str, int fromIndex)`：返回指定子字符串在此字符串中第一次出现处的索引，从指定位置开始搜索
  
  `int str.lastIndexOf(String str, int fromIndex)`：返回指定子字符串在此字符串中第一次出现处的索引，从指定索引开始反向搜索
  
  `boolean str.endsWith(String suffix)`：测试此字符串是否以指定的后缀结束
  
  `boolean str.startswith(String prefix)`：测试此字符串是否以指定的前缀开始
  
  `int str.hashCode()`：返回此字符串的哈希码
  
  `boolean str.matches(String regex)`：测试此字符串是否匹配给定的正则表达式
  
  `String str.replaceAll(String regex, String replacement)`：使用给定的replacement替换所有匹配给定正则表达式的子字符串
  
  `boolean str.contains(String chars) `：判断字符串中是否包含指定的字符或字符串
  
  `boolean str.isEmpty()`：判断字符串是否为空
  
  * 为了方便修改`String`，即在修改时无需创建新的`String`对象，在Java中还引入了`StringBuffer`和`StringBuilder`类，其中`StringBuffer`是线程安全的，但是执行速度慢，常用于多线程操作字符缓冲区使用。一般则默认使用`String Builder`
  
  
  
  ## Java 数组
  
  * 初始化的几种方式
  
    1. 声明+创建+初始化
  
       声明：`dataType[] arrayRefVar;`或者 `dataType arrayRefVar []` 
  
       创建： `arrayRefVar = new dataType[arraySize]`
  
       初始化：`arrayRefVar = {1, 2, 3};`或者`arrayRefVar[0] = 1` 
  
    2. 声明+创建 初始化
  
       `dataType[] arrayRefVar = new dataType[arraysize]`
  
       初始化：`arrayRefVar = {1, 2, 3};`或者`arrayRefVar[0] = 1` 
  
    3. 声明 创建 初始化
  
       `dataType[] arrayRefVar = {1, 2, 3}`
  
  * 数组作为函数参数或者返回值
  
    注意这个例子：`System.out.println(new double[]{1, 3, 5})`
  
  * `for-each`循环快速完成数组遍历
  
    ```java
    for(type element: array)
    {
        System.out.println(element);
    }
    ```
  
  * 多维数组
  
    ```java
    String str[][] = new String[3][4];
    type[][] arrayName = new type[typeLength1][typeLength2]
        
    ```
  
  * Arrays方法
  
    `java.util.Arrays` 这些方法都是静态的，即不随对象改变而改变
  
    ```java
    // 对数组进行二叉查找
    public static int binarySearch(Object[]a, Object key);
    
    // 判断两个指定类型的数组是否相等
    public static boolean equals(long[] a, long[] a2);
    
    // 将指定的值填入指定类型的数组中每个元素
    public static void fill(int[] a, int val);
    
    // 对指定对象数组进行自然升序排序
    public static void sort(Object[] a);
    ```
  
    

## Java 日期和时间 - 未读

https://www.runoob.com/java/java-date-time.html

`java.util.Date`  

## Java 正则表达式 - 未读

`java.util.regex.*`

## Java 方法

组成：修饰符、返回值类型、方法名、参数类型、方法体。（其中方法名和参数表共同构成方法签名）

* 方法重载：方法重载根据方法签名来判断哪个方法应该被调用，故方法可以有相同的方法名但是不同的参数表。

* 命令行参数的使用：`public static void main(String args[])`在调用时可以传递参数的，例如`“good afternoon !”`就会被拆成`{"good", "afternoon", "!"}`这个String类对象组成的的数组。编译后调用`java x.class good afternoon !`来实现。

* 构造方法：创建对象时，调用构造方法来初始化该对象，构造方法和它所在类的名字相同但是没有返回值；如果不自行定义构造函数，Java提供一个默认构造方法，默认构造方法的访问修饰符和类的访问修饰符相同。构造方法没有返回值是因为构造方法和其他方法不一样，是由JVM而非其他对象调用的。

* **可变参数**：`typeName... parameterName`

  一个方法中只能指定一个可变参数，它必须是方法的最后一个参数，任何普通参数必须在它之前。

  ```java
  public static void printMax(double... numbers);
  // 在方法体中numbers可以当作一个double类型数组
  printMax(12, 34, 21, 1, 0.9, 3.5);
  printMax(new double[]{1, 3, 5, 2, 1})
  ```

* `finalize()`方法：Java允许定义这样的方法，它在对象被垃圾收集器（析构回收）之前调用，这个方法叫做`finalize()`它用来清楚回收对象。网上都不建议使用。



## Java Stream/File/IO - 未看





## Java Scanner 类

`java.util.Scanner`

```java
Scanner input = new Scanner(System.in);
String input.next(); // 一定要读取到有效字符才可以结束输入，自动去除前后空白字符；
String input.nextLine(); // 以Enter为结束符，可以获取空格/Tab
boolean input.hasNextInt(); // 判断输入是否整数
int input.nextInt(); // 读取下一个整数
```



## Java 异常处理 - 未看完

* `Throwable` = `Error` + `Exception`：`Throwable`类是`Exception`类和`Error`类的父类；Java程序通常不捕获`Error`错误，错误一般在严重故障时，它在Java程序处理的范畴之外。

所有的异常类都是从`java.lang.Exception`类继承的子类；其有两个主要的子类 `IOException`类和`RuntimeException`类

* Java 内置异常类

  1. 非检查性异常 Unchecked Exception：编译器在编译时不会检查的异常，需要程序员自己避免，否则运行时将出错。
  2. 检查性异常 Checked Exception：编译器在编译时将会检查，如果没有用`try...catch...`避免这类错误，编译器将报错。

  ``` java
  try{
    // 程序代码
  }catch(异常类型1 异常的变量名1){
    // 程序代码
  }catch(异常类型2 异常的变量名2){
    // 程序代码
  }finally{
    // 程序代码
  }
  ```
