public class FenwickTree {
//
// * Space complexity for fenwick tree is O(n)
// * Time complexity to create fenwick tree is O(nlogn)
// * Time complexity to update value is O(logn)
// * Time complexity to get prefix sum is O(logn)
// *
    //https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/FenwickTree.java


    // check this alsp https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/SegmentTreeMinimumRangeQuery.java
    public static void main(String args[]) {
        int[] input =  {2, 1, 1, 3, 2, 3,
                4, 5, 6, 7, 8, 9};
        FenwickTree tree = new FenwickTree();
        int[] fenwickTree = tree.createFenWickTree(input);
        System.out.println("SUM " + tree.getSum(fenwickTree,5));
        tree.updateFenWickTree(fenwickTree,6,3);
        System.out.println("SUM " + tree.getSum(fenwickTree,6));
    }


    /**
     * Start from index+1 if you want prefix sum 0 to index. Keep adding value
     * till you reach 0
     */


//    For rangeSum(l, r) = getSum(r) – getSum(l-1).

    private int getSum(int[] fenwicktree, int index) {
        index ++;
        int sum =0;
        while(index >0){
            sum = sum + fenwicktree[index];
            index = getParent(index);
        }
        return sum;
    }

    private int getParent(int index){
        return index - (index & -index);
    }

    private int[] createFenWickTree(int[] inputs) {
        int [] fenwickTree = new int[inputs.length + 1];
        for(int i=0;i<inputs.length;i++) {
            updateFenWickTree(fenwickTree,inputs[i],i);
        }
        return fenwickTree;
    }

    private void updateFenWickTree(int [] fenwickTree,int a, int index) {
        index++;
        while(index <fenwickTree.length) {
            fenwickTree[index]+=a;
            index = getNext(index);
        }
    }

    private int getNext(int i) {
         i = i + (i&(-i));
         return i;
    }



}
