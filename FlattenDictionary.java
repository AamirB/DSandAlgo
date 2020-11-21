package pramp;

import java.util.HashMap;


class FlattenDictionary {

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        HashMap<String, String> result = new HashMap<String, String>();
        flattenDictionary(result, "", dict);
        return result;
    }


    static void flattenDictionary(HashMap<String, String> result, String currentKey, HashMap<String, Object> dict) {

        for(String key : dict.keySet()){

            Object value = dict.get(key);

                if(value instanceof String || value instanceof Integer ){

                        if(currentKey == "" || currentKey == null){
                            result.put(key, (String)value);
                        } else if(key  != ""){
                            result.put(currentKey + "."+key, (String)value);
                        }else {
                            result.put(currentKey , (String)value);
                        }
                } else {
                        if(currentKey == "" || currentKey == null){
                            flattenDictionary(result, key, ( HashMap<String, Object>) value);
                        }  else if(key !=""){
                            flattenDictionary(result, currentKey + "."+key,( HashMap<String, Object>) value);
                        }
                        else {
                            flattenDictionary(result, currentKey ,( HashMap<String, Object>) value);
                        }

            }
        }
    }


    public static void main(String[] args) {

    }

}
