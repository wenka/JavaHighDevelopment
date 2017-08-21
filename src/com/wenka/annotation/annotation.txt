# Java5.0定义的元注解：

1. @Target
2. @Retention
3. @Documented
4. @Inherited

# 1 @Targe
说明了Annotation所修饰的对象范围。

取值(ElementType)有:

	1. CONSTRUCTOR:用于描述构造方法
	2. FIELD:用于描述域
	3. LOCAL_VARIABLE:用于描述局部变量
	4. METHOD:用于描述方法
	5. PACKAGE:用于描述包
	6. PARAMETER:用于描述参数
	7. TYPE:用于描述类、接口(包括注解类型) 或enum声明
	
# 2 @Retention
    定义了该Annotation被保留的时间长短.表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）

取值（RetentionPoicy）有：  

    1. SOURCE:在源文件中有效（即源文件保留）
    2. CLASS:在class文件中有效（即class保留）
    3. RUNTIME:在运行时有效（即运行时保留） 
    	        
# 3 @Documented
用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化。		        

# 4 @Inherited

@Inherited阐述了某个被标注的类型是被继承的。


# 注解数据类型

格式：
```java
public @interface 注解名 {定义体}
```
　　

注解参数的可支持数据类型：

1. 所有基本数据类型（int,float,boolean,byte,double,char,long,short)
2. String类型
3. Class类型
4. enum类型
5. Annotation类型
6. 以上所有类型的数组

注解中的参数设定: 

- 只能用public或默认(default)这两个访问权修饰.
- 如果只有一个参数成员,参数名称设为"value",后加小括号.

