package greedy;

//https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// the maximum number of activities that can be performed by a single person
public class ActivitySelection {

    public static void main(String args[]){

        int[] start = {1, 3, 0, 5, 8, 5};
        int [] end = {2, 4, 6, 7, 9, 9};

        List<int[]> startEnd = new ArrayList<>();

        for(int i=0;i<start.length;i++){

            int [] tup = {start[i], end[i]};
            startEnd.add(tup);
        }

        // sort by finish time



        Collections.sort(startEnd , new Comparator<int[]>(){

            @Override
            public int compare(int []f1, int []f2){

                return Integer.compare(f1[1], f2[1]);
            }
        });

        for(int i=0;i<startEnd.size();i++){
            int[] t= startEnd.get(i);
            System.out.println(t[0] + " "+t[1]);
        }

        //int lastFinishTime = startEnd.get(0)[1];
        int maxTask = 1;
        int prevSelected = 0;
        System.out.println(" task selected "+ startEnd.get(0)[0] + " "+startEnd.get(0)[1]);
        for(int i=1; i< startEnd.size(); i++){
            int currstart= startEnd.get(i)[0];
            int prevFinish = startEnd.get(prevSelected)[1];
            if(currstart >= prevFinish) {
                maxTask++;
                prevSelected = i; // compare with prev selected
                System.out.println(" task selected "+ startEnd.get(i)[0] + " "+startEnd.get(i)[1]);

            }
        }


        System.out.println(" Max Task "+ maxTask);


    }






}
