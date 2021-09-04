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
//        Arrays.sort(chArr);
        System.out.println("lEE");
        System.out.println(Arrays.binarySearch(chArr,'b')); // After sort Right 
    }
}
