import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.io.*;

public class ejercicio7 {

 

    public void sobres(String t[]) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\Usuario\\Problema\\out.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < t.length; i++) {
                pw.println(t[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public String[] f(int[] nums) {
        if (nums == null) {
            return null;
        }
        String[] result = new String[nums.length];

        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] prizes = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = nums.length - 1; i >= 0; i--) {
            int rank = nums.length - 1 - i;
            if (rank < 3) {
                result[index.get(nums[i])] = prizes[rank];
            } else {
                result[index.get(nums[i])] = "" + (rank + 1);
            }
        }
      
        return result;
    }

    public static void main(String[] arg) {
        ejercicio7 sb = new ejercicio7();
        Scanner sc = new Scanner(System.in);
        char[] array = new char[20];
        String aa = "";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File("C:\\Users\\Usuario\\Problema\\in.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            
            String linea = "";


            linea = br.readLine().replaceAll("[^\\dA-Za-z]", "");

            aa = linea;
            array = aa.toCharArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        int[] F = new int[5];
        for (int i = 0; i < array.length; i++) {
            F[i] = Character.getNumericValue(array[i]);

        }

        
      
        sb.sobres(sb.f(F));

    }
}
