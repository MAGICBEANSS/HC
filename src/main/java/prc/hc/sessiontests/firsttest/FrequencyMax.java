package prc.hc.sessiontests.firsttest;

import java.util.*;

public class FrequencyMax {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 3,1};
        ArrayList list = new ArrayList();
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        int result = maxElementFrequency1(list.size(),  list);
     //   int result = maxElementFrequency(0, new ArrayList<>());
      //  int result = callme(arr.length, arr);
        System.out.println(result);
    }

    public  static int maxElementFrequency(int n, ArrayList<Integer> a) {
        if(n==0) return 0;
        Integer maxCount = 1;
        Integer maxEle = a.get(0);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            Integer x = a.get(i);
            if(x>maxEle) {
                maxEle  = x;
            }
            Integer count = map.getOrDefault(x,0);
            map.put(x,count+1);
        }
          return map.get(maxEle);

    }

    public  static int maxElementFrequency1(int n,ArrayList<Integer> list) {
           // ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }
        return callme(n,arr);
    }
    public  static int callme(int n,int[] a) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(map.containsKey(a[i])) {
                map.put(a[i],map.get(a[i])+1);
            }
            else {
                map.put(a[i],1);
            }
        }
        int max = Integer.MIN_VALUE;
        int ele;
        for(Integer i: map.keySet()) {
            if(max>map.get(i)) {
                continue;
            }
            else {
                max = map.get(i);
                ele=i;

            }

        }
        return max;

    }

    }
