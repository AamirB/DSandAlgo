package greedy;

import google.graph.DisJointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// create a slot for deadline . sort by max profit. fill the slot. if missing slot then check towars left
//or lower bound if max profit can be accomodated
public class JobSequence {

    class Job {

        int deadline;
        int profit;
        char jobId;

        Job(char jobId, int deadline, int profit){
            this.deadline = deadline;
            this.profit = profit;
            this.jobId = jobId;
        }
    }

    public static void main(String args[]){

        JobSequence sequence = new JobSequence();
        System.out.println(sequence.findMaxProfit());

    }

    public int findMaxProfit(){
        List<Job> jobs = new ArrayList<>();
        Job j1 = new Job('a', 2, 100);
        Job j2 = new Job('b', 1, 19);
        Job j3 = new Job('c', 2, 27);
        Job j4 = new Job('d', 1, 25);
        Job j5 = new Job('e', 3, 15);
        jobs.add(j1); jobs.add(j2); jobs.add(j3); jobs.add(j4); jobs.add(j5);

        return getMaximumProfit(jobs );

    }

   public int  getMaximumProfit(List<Job> jobs ){


       Collections.sort(jobs, new Comparator<Job>() {
           @Override
           public int compare(Job o1, Job o2) {
               return Integer.compare(o2.profit,o1.profit);
           }
       });

       // find max deadline from job to create slot
       int maxDeadline = 0;
       for(Job j : jobs ){
           maxDeadline = Math.max(maxDeadline, j.deadline);
       }

       char [] slot = new char[maxDeadline];
       Arrays.fill(slot, '*');
       int maxProfit = 0;
       for(int i=0;i<jobs.size();i++){


           if(slot[jobs.get(i).deadline-1] == '*'){
               slot[jobs.get(i).deadline-1] = jobs.get(i).jobId;
               maxProfit += jobs.get(i).profit;
           } else {

               int index = findEmptySlotLeft(slot, jobs.get(i).deadline-1);

               if(index !=-1 && slot[index] == '*'){
                   slot[index] = jobs.get(i).jobId;
                   maxProfit += jobs.get(i).profit;
               }

           }

       }

       for(int i=0;i<slot.length;i++){
           System.out.println(" Job selected "+ slot[i]);
       }

        return maxProfit;
   }

   public int findEmptySlotLeft(char[] slot, int index){


        for(int i=index-1;i>=0;i--){
            if(slot[i] == '*')
                return i;
        }

        return -1;

   }



    }


