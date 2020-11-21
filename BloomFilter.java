package misc;

import java.util.BitSet;
import java.util.HashMap;


//Bloom filters
//        https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/
//
//        Bloom filter is a space-efficient probabilistic data structure that is used to test whether an element is a member of a set
//        False positive means, it might tell that given username is already taken but actually it’s not.
//        Bloom filters never generate false negative result, i.e., telling you that a username doesn’t exist when it actually exists.
//
//        We can control the probability of getting a false positive by controlling the size of the Bloom filter. More space means fewer false positives. If we want decrease probability of false positive result, we have to use more number of hash functions and larger bit array. This would add latency in addition of item and checking membership.
//        https://gist.github.com/VarunVats9/02942fd38a5cbdf673715d2e607e5752
public class BloomFilter {


    final static int NUMBER_OF_BITS = 6400;

    BitSet bitSet ;

    final  HashFunction h1 = new HashFunction(11, 9);
    final  HashFunction h2 = new HashFunction(17, 15);
    final  HashFunction h3 = new HashFunction(31, 29);
    final  HashFunction h4 = new HashFunction(61, 59);


    public BloomFilter(){
        this.bitSet = new BitSet(NUMBER_OF_BITS);
    }


    public void addToBloomFilter(String[] words){

        for(String s: words){

            addBits(s);
        }
    }


    public void addBits(String words){

        bitSet.set(h1.getHash(words));
        bitSet.set(h2.getHash(words));
        bitSet.set(h3.getHash(words));
        bitSet.set(h4.getHash(words));
    }


    public void markIt(int bit){
        bitSet.set(bit);
    }


    public boolean isMarked(int bit){
        return bitSet.get(bit);
    }




    public static void main(String args[]){


    }


    class HashFunction {

        private long odd;
        private long prime;

        public HashFunction(final long odd, final long prime ){
            this.odd = odd;
            this.prime = prime;
        }


        public int getHash(final String word){
            int hash = word.hashCode();
            if (hash < 0) {
                hash = Math.abs(hash);
            }
            return calculateHash(hash);

        }

        private int calculateHash(final int hash) {
            return (int)((((hash % NUMBER_OF_BITS) * prime) % NUMBER_OF_BITS) * odd) % NUMBER_OF_BITS;
        }


    }

}
