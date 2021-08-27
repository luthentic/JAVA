# JAVA

### LeeStudy JAVA

## TABLE
1. [TYPE](#TYPE)
2. [STATIC](#STATIC)
3. [OVERLOADING](#OVERLOADING)
4. [CONSTRUCTOR](#CONSTRUCTOR) 
5. [INHERITANCE](#INHERITANCE) 
6. [OVERRIDING](#OVERRIDING)
7. [PACKAGE](#PACKAGE)
8. [ENCAPSULATION](#ENCAPSULATION)
9. [POLYMORPHISM](#POLYMORPHISM)
* * *


### class Card() <-  ERROR: Class doesn't have ()
### Object is a bundle of variables.
### rt.jar (~JAVA 8) module (JAVA9~) 
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









