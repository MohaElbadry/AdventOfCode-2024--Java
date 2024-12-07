package day2;

import java.util.Arrays;

public class day2 {
    public static int ChecksDownUp(Integer[] line) {
        int count;
        System.out.println("---Down-UP---");
        count = CheckDown(line);
        System.out.println("---Down-UP--- Count: " + count);
        if (count == 0) {
            return CheckUp(line);
        }
        return count;
    }

    public static Integer[] deleteElem(Integer[] line, int index) {
        Integer[] arrNew = new Integer[line.length - 1];
        System.out.println("in Delete elem the line " + index);
        System.out.println("The old arr = " + Arrays.toString(line));
        for (int i = 0, k = 0; i < line.length; i++) {
            if (i != index) {
                arrNew[k] = line[i];
                k++;
            }
        }
        System.out.println("The new arr = " + Arrays.toString(arrNew));
        return arrNew;
    }

    public static int CheckDown(Integer[] line) {
//        9 - 7 - 6 - 5 =>> 1
//        9 - 7 - 5 - 5 => DelLast -> 1
//        8 - 7 - 6 - 5 => DelFirst -> 1
//        9 - 7 - 6 - 5 =>
        System.out.println("-- Now in Down --");
        System.out.println("The arr ->" + Arrays.toString(line));
        int isChanged = 0;
        int length = line.length - 1;
        for (int i = 0; i < length; i++) {
            if (isChanged > 1) return 0;
            if (Math.abs(line[i] - line[i + 1]) > 3) return 0;
            if (line[i].equals(line[i + 1])) {
                line = deleteElem(line, i);
                isChanged++;
                length--;
                i = 0;
            }
            if (line[i] > line[i + 1]) {
                System.out.println("Down Continue");
            } else if (i + 1 == length) {
                System.out.println("Delete element in UP" + i);
                if (isChanged == 1) return 0;
                line = deleteElem(line, i + 1);
                isChanged++;
                length--;
                i = 0;
            } else {
                System.out.println("Delete element in UP" + i);
                line = deleteElem(line, i);
                isChanged++;
                length--;
                i = 0;
            }
        }
        return 1;
    }

    public static int CheckUp(Integer[] line) {
//        1 2 5 7
        System.out.println("-- Now in UP --");
        System.out.println("The arr ->" + Arrays.toString(line));
        int isChanged = 0;
        int length = line.length - 1;
        System.out.println("ths length in Up is " + length);
        for (int i = 0; i < length; i++) {
            if (isChanged > 1) return 0;
            if (Math.abs(line[i] - line[i + 1]) > 3) return 0;
            if (line[i].equals(line[i + 1])) {
                line = deleteElem(line, i);
                isChanged++;
                length--;
                i = 0;
            }
//            1, 2, 3, 4, 5, 6, 4
//            1, 2, 3, 4, 5, 7
            if (line[i] < line[i + 1]) {
                System.out.println("UP Continue");
                System.out.println("ths length in Continue Up is " + length);
            } else if (i + 1 == length) {
                System.out.println("Delete element in UP" + i);
                if (isChanged == 1) return 0;
                line = deleteElem(line, i + 1);
                isChanged++;
                length--;
                i = 0;
            } else {
                System.out.println("Delete element in UP" + i);
                line = deleteElem(line, i);
                isChanged++;
                length--;
                i = 0;
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        String data = """              
                3 6 4 8
                1 9 2 3
                """;
        String[] str = data.split("\n");
        Integer[][] TwoDimArray = new Integer[str.length][];
        // Process each line
        for (int i = 0; i < str.length; i++) {
            TwoDimArray[i] = Arrays.stream(str[i].trim().split(" ")) // Split line by spaces
                    .map(Integer::parseInt)          // Convert each string to an Integer
                    .toArray(Integer[]::new);        // Collect into an Integer array
        }

        int Stat = 0;
        int i = 0;
        for (Integer[] integersLine : TwoDimArray) {
            int check = ChecksDownUp(integersLine);
            System.out.println("the end of the Checking => " + check + " i : " + i);
            Stat += check;
            i++;
        }

        System.out.println("The Stat is");
        System.out.println(Stat);
    }
}
