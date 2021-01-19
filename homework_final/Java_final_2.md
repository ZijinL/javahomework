# Java 知识点

## 概述

* JDK、JRE、JVM；`javac, java, .class, .java`
* `NoClassDefFoundError`,`NoSuchMethodError`
* 编译错误，运行时错误，逻辑错误
* 保留字小写

## 基本程序设计

* 字符串常量不能跨行
* 控制台读取输入，屏幕输出
* 声明明确导入、声明通配符导入
* 合法标识符的条件 数字 字母 下划线 美元，数字不开头
* 赋值表达式合法形式、命名常量
* 命名习惯：常量、类名、变量和方法
* 数值数据类型和表示范围 `byte, short, int, long, float, double`
* 数值操作符：`+, -, *, /, %` 
* 幂运算 `Math.pow(a, b)`得到浮点数 
* 字面值：整型、浮点型、科学计数法 `0b, 0B, 0, 0x, 0X; 2.0D, 2.0d, 2.0F, 2.0f; 2e10, 2E-10` 
* 数字型字面值之间可以有下划线隔开，但不能在开头和末尾
* 前自增和后自增区别
* 语句`b = b + 1`和表达式`b+1`的区别
* 类型转换，向上取整，向下取整，强制转换，自动转换，扩展类型，缩小类型
* 未声明、未初始化、未使用的变量；整数溢出；浮点数舍入错误；非预期的整数除法；冗余的输入对象



## 选择

* 忘记必要的括号
* 错误地在if后出现冒号或分号
* 对布尔值地冗余测试
* 悬空`else`即最近匹配
* 测试两个浮点数的相等
* 产生随机数`System.currentTimeMillis`，`Math.random(), [0.0, 1.0)`
* 逻辑操作符 `! || && ^` 
* 不可以两边比较，因为第一个算出是`boolean`
* `switch`必须是`char, byte, short, int, string`，必须有括号
* 下面各项都必须是常量，不含变量，`case 'a': x += 1; break;`
* 一旦匹配则执行后续全部语句，直到`break` ；`default`默认也会执行
* 三元条件运算符
* 操作符优先级：一元 > 计算 > 比较 > 逻辑 > 赋值

## 数学

* `import java.lang.Math`：`Math.toDegrees(), Math.toRadian(), Math.sin(), Math.atan()` 
* `Math.exp(), Math.log(), Math.log10(), Math.pow(a, b), Math.sqrt()` 
* `Math.ceil(), Math.floor(), Math.rint(), Math.round()` 取整除了`round`都返回`double`
* `Math.min(), Math.max(), Math.abs()` 适用于 `int long float double` 
* `Math.random(): [0.0, 1.0)`
* Unicode编码，ASCII码，转义字符；相互转换，强制转换；字符比较
* `Character`类静态方法：`Character.isDigit(), Character.isLetter(), Character.isLetterOrDigit(), Character.isLowerCase(), Character.isUpperCase(), Character.toLowerCase(), Character.to UpperCase` 
* `String`类实例方法：`"x".length(), "x".charAt(index), "x".concat(s1), "x".toUpperCase(), "x".toLowerCase(), "x".trim()` 
* 加号连接字符串至少要有一个操作数是字符串
* `input.next()`读取任何空白字符结尾的输入字符串，`input.nextline()` 读取以换行符结束的整行
* `String`类实例比较方法：`"x".euqals(s1), "x".equalsIgnoreCase(s1), "x".compareTo(s1), "x".compareToIgnoreCase(s1), "x".startsWith(prefix), "x".endswith(suffix), "x".contains(s1)` 里面只有两个返回的不是布尔值，字符串不可以用不等号比较，==只能比较是否指向同一个对象
* `"x".substring(beginIndex, endIndex)`：返回该字符串的子串，从开始位置到结束位置前一个，缺省即到最后一个；
* `"x".indexOf(s, fromIndex)`：返回字符串从某个位置开始出现的第一个字符或字符串的下标；` "x".lastIndexOf(s, fromIndex)`返回字符串从某个位置之前的最后一个字符或字符串的下标
* 字符串与数值类型转换`Integer.parseInt("124") = 123`，`Double.parseInt("123.123") = 123.123`
* 格式化控制输出 `System.out.printf("-%#10.2f this", 123.123)`将输出`123.12##### this` 左对齐+填充符
* 指定类型和实际类型必须严格匹配，如果指定宽度不够会自动扩充；`%b, %, %d, %f, %e, %s` ；



## 循环

* `do-while`循环最后需要写分号
* `for(;;){}`是死循环；初始化条件，循环继续条件，每次迭代后的操作
* 在循环条件中用浮点数将导致数值错误



## 方法

* 修饰符、返回值类型、形式参数、方法体、返回值、实际参数、方法签名=方法名+参数列表
* `main`：`public static void main(String [] args)` ，不带返回值的方法调用时必须时一条语句；
* 调用栈最下面永远是`main`
* 实参必须与方法签名中定义的形参在次序和数量上匹配，在类型上兼容，即不需显式转换；
* 在传参时，如果传的是对象那么方法中可以改变参数本来的值，如果参数是基本类型则不改变
* 方法重载必须有不同的参数列表，不能基于不同修饰符或者返回值类型来重载
* 编译器调用重载的方法时用最精确的匹配，当无法确定时会产生歧义调用编译错误



## 一维数组

* 数组的声明：`int[] nums; int nums[];`；数组创建：`nums1 = new int[size]`；
* 数组变量本质是一个指向该类型元素的数组的引用变量
* 数组大小`nums.length`是属性，不是方法；创建后就有了初始值`int-0, char-'\u0000', boolean-false` 
* 数组初始化简写方式：`int[] nums = {1, 2, 3}`，包含了**声明、创建、初始化**三个步骤
* `for-each`循环；越界访问数组将抛出一个运行时错误`ArrayIndexOutOfBoundsEexception` 
* 数组实现复制的方法：循环逐个复制，`System.arraycopy(src, srcpos, tar, tarpos, length)`
* 可变长参数列表`int... numbers`，只能是最后一个参数，任何普通参数都得在其后面
* `Java.util.Arrays`静态方法： `Arrays.sort(list, from, to) 数值或字符, Arrays.binarySearch(list, key) 升序排好, Array.equals(list1, list2), Arrays.fill(list, from, to, value)`

## 多维数组

* 声明`int[][] matrix; int matrix[][]`，创建 `maatrix = new int[m][n]`，获取长度，不规则数组-各行长度不一 `matrix = new int[5][]` 

## 对象和类

* 类：数据域、构造方法、方法；实例变量，实例方法；静态变量，静态方法
* 构造方法：必须同类名、没有返回值类型`void`，只在`new`一个对象的时候调用、默认无参构造
* 数据域中的变量有默认值：引用类型数据域是`null`，数值类型、布尔类型、字符类型同理；但是局部变量是没有默认值的；如果访问了`null`的引用变量上的方法则会抛出`NullPointerException` 
* 匿名对象/匿名数组：直接用`new ClassName().method()`访问的，或者用`{1, 2}`这样的数组；用完就回收；
* `Date`类实例方法：`date.getTime(), data.toString(), date = new Date(), date = new Date(millisecond)` 
* `Random`类实例方法：`random = new Random(seed: long), random.nextInt(int n), random.nextDouble()`等
* 可见性修饰：`public 其他类, private 自己类, default 自己包, protected包内可见子类可见`
* 数据域一般都设为私有的，另外加上访问器方法和修改器方法，以保障数据安全性和完整性
* 不可变类：一旦创建了对象就不可修改，比如`String`，所有数据域都是私有，没有修改器，没有返回一个指向可变数据域的引用的访问器方法（比如get一个数组）
* 隐藏的实例变量可以用`this.i`访问，隐藏的静态变量可以用`ClassName.i`访问；`this`还可以调用其他构造方法



## 面向对象思考

*  `java.lang.Integer`包装类的静态方法：`Intger.MAX_VALUE, Integer.MIN_VALUE`；`Integer.valueOf(String s, int radix) 返回Integer`，`Integer.parseInt(String s, int radix)返回int`；指定的是`String`中的进制
* 构造方法：`new Integer(int value), new Integer(String s)` 
* 实例方法：`x.byteValue(), x.doubleValue(), x.toString(), x.compareTo(Integer 0)` 
* 注意`new Double(double x)`中构造方法必须是`double`，不可以是`int` 
* `String`：`str.replace(), str.replaceFirse(), str.replaceAll(), str.equals(), str.matches(), str.toCharArray()`；`String str = new String(char []), String str = String.valueOf(char [])`
* 转为字符串的方法：`x.toString()`，`String.valueOf()`可以是任何基本类型以及字符数组
* `String.format("%6.2f%6d", 23, "123")`返回一个格式化的字符串
* `StringBuilder`适合单线程；`StringBuffer`适合多线程；调用`strb = new StringBuilder(String s)`创建，然后调用`strb.toString()`返回字符串；其实例可以`insert, append, delete, replace, reverse, setCharAt`

## 继承和多态

* 一个类可以有多个子类，但是只能继承一个父类；
* `super(arguments)`：调用父类构造方法时类似this调用重载的构造方法，要求参数匹配；`super.method()`调用父类的一般方法；
* 构造方法链：当子类实例化时，其初始化会从最底端依次向上找符合条件的构造方法，直到最顶级的父类的构造方法开始调用
* 方法重写：重写的方法要有一样的方法签名，返回类型可以缩小；只有当实例方法可以访问时才能重写，否则这两个方法毫无关系；静态方法能被继承但是不能重写，那叫重新定义，可以用`ClassName.method()`来调用父类隐藏的方法；
* 方法重载`@Override`：参数列表不同，返回值类型不要求
* 区别：方法的重载和重写都是实现多态的方式，区别在于前者实现的是编译时的多态性，而后者实现的是运行时的多态性。重载发生在一个类中，同名的方法如果有不同的参数列表（参数类型不同、参数个数不同或者二者都不同）则视为重载；重写发生在子类与父类之间，重写要求子类被重写方法与父类被重写方法有相同的参数列表，有兼容的返回类型，比父类被重写方法更好访问，不能比父类被重写方法声明更多的异常（里氏代换原则）。重载对返回类型没有特殊的要求，不能根据返回类型进行区分。
* 声明类型、实际类型、动态绑定
* 封装、继承、多态（每一个子类的对象都是父类的实例，子类对象可以调用父类的方法，向上转换）
* `ArrayList`：`add, clear, con                                                                                                                      tains, get, indexOf, isEmpty, lastIndexOf, remove, size, set`

## 异常

* 免检异常：`RunTimeException, Error`；其他都是检查性异常，必须要在方法头中显式声明，告知调用者例如`public void myMethod() throws IOException`，或者用`try-catch`语句进行处理

* 声明异常`throws Expcetion1, Exception2`；抛出异常`throw new Exception()` 

* 如果父类中的方法没有声明异常，那么就不能在子类中对其重写时声明异常；

* 如果异常没有在当前的方法中被捕获，就传给该方法的调用者，一直到`mian`

* 如果可以捕获一个父类的异常，那么就可以捕获其子类的全部异常；因此要把捕获子类异常的`catch`语句放在前面；

* `java.lang.Throwable`中的实例方法：`ex.getMessage(), ex.toString(), ex.printStackTrace(), ex.getStackTrace()`

  ```java
  try {
      
  }
  catch (Exception | Exception) {
      
  }
  catch (Exception) {
      
  }
  finally {
      
  }
  ```

  

* `File`：`file = new File(parentDir, childFile)`，`file.exists(), file.isDirenctory(), file.isFile(), file.getPath(), file.getParent(), file.deletee(), file.lastModified(), file.length(), file.mkdir()`
* 创建`File`对象并不代表创建一个新的文件，需要调用方法进行判断；
* `PrintWriter`文件输入：向文本中写入数据；`pw = new PrintWriter(File file), pw.print(), pw.printf(), pw.println()`
* `Scanner`文件读取：从文件中读取文本数据，`sc = new Scanner(File), sc.close(), sc.next(), sc.hasNextInt()`

## 抽象

* 抽象类不能实例化，构造方法定义为`protected`，因为其只能被子类调用
* 抽象方法是静态的，如果子类不能实现全部父类的抽象方法，那么必须声明为静态；
* 包含抽象方法的类必须是抽象类，但是抽象类中可以没有抽象方法；
* 即使父类是具体的，这个子类也可以是抽象的；抽象类不能实例化，但是可以用作声明变量类型；
* 接口：接口中只能有抽象的方法，而抽象类中可以有甚至都可以是普通方法；一个类之能继承一个类，而可以实现多个接口；感性地来说，类的继承主要表示是不是的关系，而接口的继承主要表示有没有的关系；
* 接口和抽象类都不能实例化；接口中所欲呕的数据域都是`public static final`，所有的方法都是`public abstrac`，因此可以都省略；

