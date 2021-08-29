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
