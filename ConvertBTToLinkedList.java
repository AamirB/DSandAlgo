package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertBTToLinkedList {


    public static void main(String args[]){
        final List<String> allMerchantList = new ArrayList<>();
        List<String> merchantToIsAmazonMerchant = null;

        merchantToIsAmazonMerchant = allMerchantList.stream().collect(Collectors.toList());
        System.out.println(merchantToIsAmazonMerchant);
    }




}
