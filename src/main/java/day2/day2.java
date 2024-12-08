package day2;

import java.util.Arrays;

public class day2 {
    public static boolean IsSafe(Integer[] OneLine) {
        boolean isInc = OneLine[0] < OneLine[1];
        if (isInc) {
            for (int i = 0; i < OneLine.length - 1; i++) {
//               1 2 3 4
//                6 - 9 =
                if (0 <= (OneLine[i] - OneLine[i + 1]) || (OneLine[i] - OneLine[i + 1]) < -3) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < OneLine.length - 1; i++) {
//                9 6 5 2
//                9 - 6 = 3
                if (1 > (OneLine[i] - OneLine[i + 1]) || (OneLine[i] - OneLine[i + 1]) >3 ) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int CheckSafety(Integer[] line) {
        if (IsSafe(line)) {
            System.out.println("is safe " + Arrays.toString(line));
            return 1;
        }
        int i = 0;
        System.out.println("Not Safe : " + Arrays.toString(line));
        while (i < line.length) {
            Integer[] NewLine = deleteElem(line, i);
            System.out.println(Arrays.toString(NewLine));
            if (IsSafe(NewLine)) {
                System.out.println("Now Safe Arr = " + Arrays.toString(line));
                return 1;
            }
            i++;
        }
        System.out.println("Note Safe Arr = " + Arrays.toString(line));
        return 0;
    }

    public static void main(String[] args) {


        Integer[][] TwoDimArray = Str.getData();
        int CountSafe = 0;
        int iterations = 0;
        for (Integer[] integersLine : TwoDimArray) {
            int check = CheckSafety(integersLine);
            CountSafe += check;
        }
        System.out.println("The Stat is" + CountSafe);
        System.out.println(CountSafe);

    }

    public static Integer[] deleteElem(Integer[] line, int index) {
        Integer[] arrNew = new Integer[line.length - 1];
        for (int i = 0, k = 0; i < line.length; i++) {
            if (i != index) {
                arrNew[k] = line[i];
                k++;
            }
        }
//        System.out.println("The new arr = " + Arrays.toString(arrNew));
        return arrNew;
    }

}
