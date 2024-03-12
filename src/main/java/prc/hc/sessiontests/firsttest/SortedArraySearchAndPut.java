package prc.hc.sessiontests.firsttest;

import java.util.ArrayList;

public class SortedArraySearchAndPut {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        ArrayList list2 = new ArrayList();
        list2.add(5);
        int x = searchPosition(list,3);
        System.out.println(x);

    }

    public static int searchPosition(ArrayList<Integer> arr, int target) {
     //   if(arr.size()==0 || arr.get(0)>target) return 0;
      //  if(arr.get(arr.size()-1)<target) return arr.size();
        return findElement(arr,target,0,arr.size()-1);
    }

    static int findElement(ArrayList<Integer> arr,int target, int low,int high) {
        int mid = (low+high)/2;
        while (low<=high) {
             mid = (low+high)/2;
            if(arr.get(mid)==target) {
                return mid;
            }
            else if(mid>low && mid<high && arr.get(mid-1)<target && arr.get(mid+1)>target) {
                return mid;
            }
            else if(target>arr.get(mid)) {
                low = mid+1;
            }
            else  if(target<arr.get(mid)) {
                high = mid-1;
            }


        }
        return mid;
    }
}
