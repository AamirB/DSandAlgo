package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java
public class Trie {


    class TrieNode {


        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode(){
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }

    }

    TrieNode root;

    public Trie()
    {
      this.root = new TrieNode();
    }




    public void insert(String word){

        TrieNode current = root;

        for(char ch : word.toCharArray()){

            if(current.children.get(ch) == null){
                current.children.put(ch, new TrieNode());
            }
             current = current.children.get(ch);
        }

        current.isEndOfWord = true;

    }


    public List<String> prefixMatchedWordsInDictionary(String prefix){


        List<String> results = new ArrayList<>();
        TrieNode current = root;
        for(char ch : prefix.toCharArray()){

            if(current.children.get(ch) == null){
                return results;
            }
            current = current.children.get(ch);
        }



        returnPrefixMatchingUtil(current, results, new StringBuilder(prefix));
        return results;
    }


    public void returnPrefixMatchingUtil(TrieNode current, List<String> words, StringBuilder currrString){


        if(current == null){
            return;
        }


        if(current.isEndOfWord){
            words.add(currrString.toString());
        }


       // int i=0;
        for(char a='A'; a<'z';a++){
            TrieNode node = current.children.get(a);
            if(node != null) {
                currrString.append(a);
                returnPrefixMatchingUtil(node, words,currrString);
                currrString.setLength(currrString.length()-1);
            }

        }
    }



    public String searchPrefixMatching(String word){

        TrieNode current = root;
        int i=0;
        for(i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(current.children.get(ch) == null){
                break;
            }
            current = current.children.get(ch);
        }

        return word.substring(0,i);
    }


    public boolean search(String word){

        TrieNode current = root;
        for(char ch: word.toCharArray()){
             if(current.children.get(ch) == null){
                 return false;
             }
             current = current.children.get(ch);
        }

        return current.isEndOfWord;
    }


    public void delete(String word){
        delete(root, word, 0);
        //System.out.println(" Tree modified for word "+ word + " "+t);
    }


    // tricky  Returns true if parent should delete the mapping
    public boolean delete(TrieNode current, String word, int index){


        //base condition
        if(index == word.length()) {
            if(!current.isEndOfWord){  // string exist but word does not exist
                return false;
            }
            current.isEndOfWord = false;
            return current.children.size() ==0;  // Here no children so delete all ancestor which is part of this word
        }

        char ch = word.charAt(index);
        if(current.children.get(ch) == null){  // word does not exist
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(current.children.get(ch), word, index+1);


//if true is returned then delete the mapping of character and trienode reference from map.

        if(shouldDeleteCurrentNode){

            current.children.remove(word.charAt(index));
            //return true if no mappings are left in the map.
            return current.children.size() == 0 && !current.isEndOfWord;

        }

        return false;



    }



    public static void main(String args[]){


//        Trie trie = new Trie();
//        trie.insert("ABCDbasement");
//        trie.insert("AbasesS");
//        trie.insert("Ab");
//        System.out.println(trie.prefixMatchedWordsInDictionary("Ab"));

       String s= "aamir";
       int i=0;
      System.out.println(s.substring(0,i));
        System.out.println(s.substring(i+1,s.length()));

        StringBuilder sb = new StringBuilder("w");


    }



}
