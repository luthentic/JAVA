# JAVA

### LeeStudy JAVA

## TABLE
- [TYPE](#TYPE)	
- [STATIC](#STATIC)	
- [OVERLOADING](#OVERLOADING)
- [CONSTRUCTOR](#CONSTRUCTOR) 
- [INHERITANCE](#INHERITANCE) 
- [OVERRIDING](#OVERRIDING)
- [PACKAGE](#PACKAGE)
- [ENCAPSULATION](#ENCAPSULATION)
- [POLYMORPHISM](#POLYMORPHISM)
- [INTERFACE](#INTERFACE)
- [StringBuffer](#StringBuffer)
- [CollectionFramwork](#CollectionFramwork)
- [Thread](#Thread)


* * *


### class Card() <-  ERROR: Class doesn't have ()
### Object is a bundle of variables.
### rt.jar (~JAVA 8) module (JAVA9~) 
### Sacnner.next() vs nextLine()   next() return till space (default) nextLine() return whole line
* * *

## TYPE
```java
class Data { int x; }

class PRIMITIVE {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);

		change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x);
	}

	static void change(int x) { 
		x = 1000;
		System.out.println("change() : x = " + x);	
	}
}

```
### PRIMITIVE can't pass the value from the memory
```java
class Data3 { int x; }
class REFERENCE {
	public static void main(String[] args) {
		Data3 d = new Data3();
		d.x = 10;

		Data3 d2 = copy(d); 
		System.out.println("d.x ="+d.x);
		System.out.println("d2.x="+d2.x);
	}

	static Data3 copy(Data3 d) {
		Data3 tmp = new Data3();   

		tmp.x = d.x; 

		return tmp;   			
	}
}
```
### Reference can paas the value from the memory
* * *

## STATIC
```java
class Human{
	String color;
	int number;
	
	static int width = 100;
	static int height = 250;
}

public class java01{
	public static void main(String args[]) {
		Human h = new Human();
		
		h.color = "Brown";
		h.number = 15;
		
		Human.width = 200;        	 <===  name it as class name for static variables;
		Human.height = 100;
		
	}	
}
```
### Static method  Cannot use Instance methods and variables because it doesn't use without Instancing.
* * *

## OVERLOADING 
OverLoading Rules: 1.Same Methods Names, 2.Different Quentity Of Parameters Or Types
```java
class MyMath3 {
	int add(int a, int b) {
		System.out.print("int add(int a, int b) - ");
		return a+b;
	}
	

	long add(long a, long b) {
		System.out.print("long add(long a, long b) - ");
		return a+b;
	}

	int add(int[] a) {	
		System.out.print("int add(int[] a) - ");
		int result = 0;
		for(int i=0; i < a.length;i++) 
			result += a[i];
		
		return result;
	}
}
```
```java
long add(int a, long b) {return a+b;}
long add(long a, int b) {return a+b;}         	<=== Ambiguous OverLoading
```
* * *

## CONSTRUCTOR
### Every Constructors must call other constructors
```java
 class LEE extends Object{
            int x;
            int y;

            LEE(){
                this(0,0);
            }

            LEE(){
                super();
                this.x = x;
                this.y = y;
            }

        }
```
```java
class Car {
	String color;		
	String gearType;	
	int door;			

	Car() {}				<=== Default Constructor 

	Car(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
}
```
```java
class Car2 {
	String color;		
	String gearType;	
	int door;		
	
	Car2() {
		this("white", "auto", 4);   	<== Call Car2(String color, String gearType, int door) Class
	}

	Car2(String color) {
		this(color, "auto", 4);
	}

	Car2(String color, String gearType, int door) {
		this.color  <== IV = color  		<== LV; 
		this.gearType = gearType;
		this.door = door;
	}
}
```
### this = Instance Value, this(),this(some,some) = Constructor
### Class Variable cannot use this
* * *

## INHERITANCE
## Inheritance vs composite 
```java
class Circle extends Point{
            int r;
        }
```
```java
class Circle {
            Point c = new Point();
            int z;
        }
```
![inher](https://user-images.githubusercontent.com/33567830/130701711-5824458a-d507-4b06-87e4-33f851c61bbc.png)
### INHERITANCE + COMPOSITE can be mixed. 
```java
Class Tv extends Object      <===  Object is default parent class
```
* * *

## OVERRIDING
### Access Modifier of Child Method Can't Be Narrower Than Parent Methods'   Public > Protected > Private
### Child Method Can't Have More Exception Than Parent Method	  throws IOEXception....
* * *

## PACKAGE
### Package declares once at the first line in source file
### If No Declaration, It Is Deafult Package
### Import Let Omit Package Name
### java.lang Package can use without import
### Import must be placed between Package and class
* * *

## ENCAPSULATION
### final class == can't be parents class ex) used for password 
### final vaiable == const value
### final method == can't be overrided
### 1. Public == No restriction 2. Protected == Same Package or Inheritance 3. Default == Same Package,~~~Inheritance~~~ 4. Private == Only Same Class
```java
class Time{
    private int hour;				<=== Protect data
    private int minute;
    private int second;

    public void setHour(int hour){			
        if(isNotVaildHour(hour))  return;

        this.hour = hour;
    }

    private boolean isNotVaildHour(int hour) {	<=== Only function for this class 
        return hour < 0 || hour > 24;
    }

    public int getHour(){
        return hour;
    }
}

public class test {
    public static void main(String[] args) {
        Time t = new Time();
        t.setHour(21);
        System.out.println(t.getHour());
        t.setHour(100);

    }
}
```
* * *

## POLYMORPHISM
### TV t = new SmartTV();  <=== Type doesn't have to be matched
```java
class TYPECASTING {
	public static void main(String args[]) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();			<== 5 IV
		car = fe;   			<== 5 IV => 4 IV  car = fe; car = (car)fe; 
		car.water();			<== Error 
		fe2 = (FireEngine)car; 		<== 4 IV => 5 IV so add TYPE (FireEngine)
		fe2.water();
	}
}

class Car {
	String color;
	int door;

	void drive() { 	
		System.out.println("drive, Brrrr~");
	}

	void stop() {  		
		System.out.println("stop!!!");	
	}
}

class FireEngine extends Car {	
	void water() {
		System.out.println("water!!!");
	}
}
```
### instanceof == to check typecasting avaiable
```java
void doWork(Car c){
	if(c instanceof FireEngine){
		FireEngine fe = (FireEngine)c;
		fe.water();
	}
}
```
### POLYMORPHISM + ABSTRACT
```java
abstract class Unit{
    int x,y;
    abstract void move(int x,int y);
}
class Marine extends Unit{
    void move(int x,int y){
        System.out.println("MARINE MOVE X:"+x + "Y:"+y);
    }
}
class Dropship extends Unit{
    void move(int x,int y){
        System.out.println("Dropship MOVE X:"+x + "Y"+y);
    }
}
public class Abstract {
    public static void main(String[] args) {
        Unit group[]= {new Marine(),new Dropship()};
        
        for (int i=0; i <group.length; i++){
            group[i].move(100,200);
        }
    }
}
```
* * *
## INTERFACE
### Interface can't have IV. Interface is clutter of abstract methods.
### Variable always Public static finaal, Method always public abstract  //can be omited
```java
interface LEE{
	public static final int spade = 4;
	final int spade = 4;
	int spade = 4;
	
	public abstract string lee();
	string lee();
}
```
## If Instance only partial, add Abstract before class
```java
interface Fightable{
	void move(int x,int y);
	void attak();
}
abstract class Fighter implement Fightable{
	public void move(int x,int y){}
}
```
## Deafult method (JDK 1.8>)
```java
interface LEE{
	default void lee{}
}
```
## Inner Class, Unchanged Values are treated like final (JDK 1.8>)
* * *
## ERROR
## 
1.Compile-Error
2.Runtime-Error
3.Lofical-Error 
## Error (Can't handle)> Exception (try-catch or throws)
## Try-Catch can't omit {}
## Multi Catch Block (JDK 1.7>)
```java
catch(Exception A | Exception B e){
	e.printeStackTrace();
}
```
## Exception: Exception(Checked Exception: Try-Catch Necessary)and Runtime Exception(Unchecked Exception: UnNecessary)
* * *
## equals(Obeject obj) 
```java
class Person {
	long id;

	public boolean equals(Object obj) {				<== Polymorphism
		if(obj instanceof Person)				
			return id ==((Person)obj).id; 
		else
			return false;
	}

	Person(long id) {
		this.id = id;
	}
}

class Ex9_2 {
	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);

		if(p1.equals(p2))
			System.out.println("Equals.");
		else
			System.out.println("DIFFERENT.");
	}
}
```
* * *
## Object Class

### public boolean equals(Object obj){}

### hashCode() == return INT address of Obejct    native code by C, JNI,  If override equals(), hashCode() override too
* * *
### String class is immutable, includes char[]
### String Class equals() is overrided 
### String str = String.valueOf(200); 
* * *

## StringBuffer

### StringBuffer is mutalbe

```java
StringBuffer() = StringBuffer sb = new StringBuffer();	<== Default 16 size array
```

### StringBuffer equals() is not overrided  has to convert in String then compare

### StringBuffer.append() 	<== converted in String

### StringBuffer.capacity()   	<==  return StringBuffer size 

### StringBuffer.lenth()	<==  return String size in StringBuffer 	

### StringBuffer.delete(3,6)

### StringBuffer.deleteCharAt(3);

### StringBuffer.insert(5,any type);

### StringBuffer.replace(int str, int end, String str);

### StringBuffer.reverser(); 

### StringBuffer.setCharAt(int index, char ch);

### StringBuffer.subString(int start,int end <-option) <== return String

* * *

## StringBuilder is synchronized for multi-thread

## rint() roundeven is more accurate than round()

* * *

## Collection Framwork

### List = Order: O, Overlap: O

### Statck = LIFO, CLASS   == ArrayList !remove from last index 
 
### QUE = FIFO, INTERFACE   == LinkedList

```java
import java.util.*;

public class lee02 {
  public static void main(String[] args) {
    Stack st = new Stack();
    Queue q = new LinkedList();

    st.push("0");
    st.push("1");
    st.push("2");

    q.offer("0");
    q.offer("1");
    q.offer("2");

    while (! st.empty()){
      System.out.println(st.pop());
    }

    while (! q.isEmpty()){
      System.out.println(q.poll());
    }
  }
}
```
* * *

## ARRAY

```java
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int [][] arr2D = {{11,22,33},{44,55,66}};

        System.out.println("Arr"+ Arrays.toString(arr));
        System.out.println("Arr2D" + Arrays.deepToString(arr2D));
        
        int[] arrCp = Arrays.copyOf(arr,arr.length);
        int[] arrCp3 = Arrays.copyOf(arr,3);
        int[] arrCp7 = Arrays.copyOf(arr,7); // [1,2,3,4,5,0,0]
        int[] arrCpRange1 = Arrays.copyOfRange(arr,2,4);
        int[] arrCpRange2 = Arrays.copyOfRange(arr,0,7); //[0,1,2,3,4,5,0,0]

        System.out.println("ArrCp=" + Arrays.toString(arrCp));
        
        int[] arrFill = new int[5];
        Arrays.fill(arrFill,9);
        System.out.println("ArrFill="+arrFill);
        
        Arrays.setAll(arrFill, i -> (int)(Math.random()*6)+1);
        System.out.println("ArrFillRamdom ="+arrFill);
        
        for(int i : arrFill){
            char[] graph = new char[3];
            Arrays.fill(graph,'*');
            System.out.println(new String(graph)+i);
        }
        
        String [][] str1 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
        String [][] str2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};

        System.out.println(Arrays.equals(str1,str2));   //False
        System.out.println(Arrays.deepEquals(str1,str2));// True
        
        char[] chArr = {'a','b','c','d'};

        System.out.println("Index of b="+ Arrays.binarySearch(chArr,'b')); // wrong
        Arrays.sort(chArr);
        System.out.println(Arrays.binarySearch(chArr,'b')); // After sort Right 
    }
}
```
### Iterator is interating standarzation for LIST SET MAP, Iterator is disposable
### Map has to add ketSet() entrySet() or valuesSet().iterator()
### BinarySearch needs Sort() first
* * *
### Comparator 

### Set  = Order: X, Overlap: X
### HashSet, LinkedHashSet,  TreeSet
### needs to override equals(), and hashCode() 
```java
import java.util.*;

class Scratch {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        
        set.add("abc");
        set.add("abc");
        set.add(new Person("Lee",10));
        set.add(new Person("Lee",10));
        System.out.println(set);
    }
}

class Person{
    String name;
    int age;

    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) return false;
            Person p = (Person)obj;

        return this.name.equals(p.name) && this.age ==p.age;  

    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return name +":"+ age;
    }
}
```
### TreeSet
* * *

### Map	 = Order: X, Overalp: Key:X, Value: O
### HashMap 
```java
class lee02{
  public static void main(String[] args) {
      HashMap map = new HashMap();
      map.put("LEE1",new Integer(60));
      map.put("LEE2",new Integer(70));
      map.put("LEE3",80);
      map.put("LEE4",new Integer(90));

      Set set = map.entrySet();
      Iterator it = set.iterator();

      while (it.hasNext()){
        Map.Entry e = (Map.Entry)it.next();
        System.out.println("Name:"+e.getKey()+" "+"Score" + e.getValue());
      }


  }
  }
```

## Thread
### Thread Class or Runnable Interface
```java
class Scratch {
    public static void main(String[] args) {
        Thread1 th1 = new Thread1();
        Runnable r = new Thread2();
        Thread th2 = new Thread(r);

        th1.start();
        th2.start();
    }
}

class Thread1 extends Thread{
    public void run(){
        for (int i=0; i < 5; i++){
            System.out.println(this.getName());
        }
    }
}

class Thread2 implements Runnable{
    public void run(){
        for (int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
```

```java
class Scratch {
    static long startTime = 0;
    public static void main(String[] args) {
        Thread1 th1 = new Thread1();
        Runnable r = new Thread2();
        Thread th2 = new Thread(r);
    
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();
        
        try{
            th1.join();
            th2.join();
        } catch (InterruptedException e){}
        System.out.println("Time Consume"+(System.currentTimeMillis() - startTime));
    }
}

class Thread1 extends Thread{
    public void run(){
        for (int i=0; i < 300; i++){
            System.out.print(new String("-"));
        }
    }
}

class Thread2 implements Runnable{
    public void run(){
        for (int i=0; i<300; i++){
            System.out.print(new String("|"));
        }
    }
}
```
## Lamda Function

```java
class Scratch {
    public static void main(String[] args) {
       Myfunction f = (int a, int b) -> a > b ? a: b;
       
       int value = f.max(3,5);
        System.out.println(value);
    }
}

@FunctionalInterface				<== funcation interface connect to instance
interface Myfunction {
    int max(int a,int b);
}
```
## Stream

### Intermediate Operations:

map: The map method is used to returns a stream consisting of the results of applying the given function to the elements of this stream.

	List number = Arrays.asList(2,3,4,5);

	List square = number.stream().map(x->x*x).collect(Collectors.toList());

filter: The filter method is used to select elements as per the Predicate passed as argument.

	List names = Arrays.asList("Reflection","Collection","Stream");

	List result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());

sorted: The sorted method is used to sort the stream.

	List names = Arrays.asList("Reflection","Collection","Stream");

	List result = names.stream().sorted().collect(Collectors.toList());

### Terminal Operations:

collect: The collect method is used to return the result of the intermediate operations performed on the stream.

	List number = Arrays.asList(2,3,4,5,3);

	Set square = number.stream().map(x->x*x).collect(Collectors.toSet());

forEach: The forEach method is used to iterate through every element of the stream.

	List number = Arrays.asList(2,3,4,5);

	number.stream().map(x->x*x).forEach(y->System.out.println(y));

reduce: The reduce method is used to reduce the elements of a stream to a single value.

	The reduce method takes a BinaryOperator as a parameter.

	List number = Arrays.asList(2,3,4,5);
	int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);

resoruce: https://www.geeksforgeeks.org/stream-in-java/
```java
import java.util.Comparator;
import java.util.stream.Stream;

class lee02{
  public static void main(String[] args) {
    Stream<Student> studentStream = Stream.of(
        new Student("LEE1",1,100),
        new Student("LEE2",2,600),
        new Student("LEE3",3,300),
        new Student("LEE4",4,200)
    );
    studentStream.sorted(Comparator.comparing(Student::getBan)
            .thenComparing(Comparator.naturalOrder()))
            .forEach(System.out::println);
  }
}

class Student implements Comparable<Student>{
  String name;
  int ban;
  int totalScore;

  Student(String name,int ban, int totalScore){
    this.name = name;
    this.ban  = ban;
    this.totalScore = totalScore;
  }
  public String toString(){
    return String.format("%s, %d, %d", name,ban,totalScore);
  }
  String getName(){ return name;}
  int getBan(){ return ban;}
  int getTotalScore(){return totalScore;}

  @Override
  public int compareTo(Student o) {
    return o.totalScore - this.totalScore;
  }
}
```

```java
import java.io.File;
import java.util.Comparator;
import java.util.stream.Stream;

class lee02{
  public static void main(String[] args) {
    File[] fileArr = {new File("Ex1.java"),new File("Ex2.bak"),
                      new File("Ex3.txt"),new File("Ex4.kotlin")};

    Stream<File> fileStream = Stream.of(fileArr);
    Stream<String> fileNameStream = fileStream.map(File::getName);
    fileNameStream.forEach(System.out::println);

    fileStream = Stream.of(fileArr);
    fileStream.map(File::getName)
            .filter(s -> s.indexOf('.')!=1)
            .map(s -> s.substring(s.indexOf('.')+1))
            .distinct()
            .forEach(System.out::println);

  }
}
```


### Buble Sort
```java
  public static void bubleSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i;i++){
                int tep =0;
                
                if (arr[j] > arr[j+1]){
                    tep = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tep;
                }
            }
        }
    }
```








