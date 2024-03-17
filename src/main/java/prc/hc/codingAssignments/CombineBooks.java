package prc.hc.codingAssignments;

import java.util.ArrayList;
import java.util.List;

public class CombineBooks {
    public static void main(String[] args) {
            List<String> list1 = new ArrayList<>();
            list1.add("book");list1.add("enchanted");
            list1.add("spell");list1.add("spell");
            List<String> list2 = new ArrayList<>();
        list2.add("ancient");list2.add("dragon");
        list2.add("magic");list2.add("scroll");
            solve(list1,list2);
    }

    public static int stringCompare(String str1,
                                    String str2)
    {
        for (int i = 0; i < str1.length() &&
                i < str2.length(); i++) {
            if ((int)str1.charAt(i) ==
                    (int)str2.charAt(i)) {
                continue;
            }
            else {
                return (int)str1.charAt(i) -
                        (int)str2.charAt(i);
            }
        }

        if (str1.length() < str2.length()) {
            return (str1.length()-str2.length());
        }
        else if (str1.length() > str2.length()) {
            return (str1.length()-str2.length());
        }

        else {
            return 0;
        }
    }

    public static List<String> mergeSortedLists(List<String> list1, List<String> list2) {
        List<String> mergedList = new ArrayList<>();

        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).compareTo(list2.get(j)) <= 0) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }



    public static List<String> solve(List<String> inventory1, List<String> inventory2) {
        //Write your code here
        inventory1.sort((a,b)->{return a.compareTo(b);});
        inventory2.sort((a,b)->{return a.compareTo(b);});
        List<String> result = mergeSortedLists(inventory1,inventory2);
        return result;


    }
}
