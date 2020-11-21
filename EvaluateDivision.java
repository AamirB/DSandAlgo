package google.graph;


//https://leetcode.com/discuss/interview-question/269629/Google-or-Phone-screen-or-Delete-nodes-and-Currency-rate


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/EvaluateDivison.java
public class EvaluateDivision {


        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {


            Map<String, Integer> stringToIndex = createMapOfStringToIndex(equations);

            int N = stringToIndex.size();

            double[][] graph = new double[N][N];

            for(int i=0;i<graph.length;i++){
                Arrays.fill(graph[i], -1.0);
            }

            for(int i=0;i<equations.size();i++) {
                String s = equations.get(i).get(0);
                String d = equations.get(i).get(1);

                int i1 = stringToIndex.get(s);
                int i2 = stringToIndex.get(d);

                graph[i1][i1] = graph[i2][i2] = 1.0;
                graph[i1][i2] = values[i];
                graph[i2][i1] = 1/values[i];

            }

            // floyd warshal apply

            for(int i=0;i<N;i++){

                for(int j=0;j<N;j++){

                    if(graph[i][j] != -1){
                        continue;
                    }

                    for(int k=0;k<N;k++){

                        if (graph[i][k] == -1 || graph[k][j] == -1) {
                            continue;
                        }

                        graph[i][j] = graph[i][k] * graph[k][j];

                    }

                }

            }




            double [] results = new double[queries.size()];

            for(int i=0;i<queries.size();i++){
                List<String> s = queries.get(i);

                String s1 = s.get(0);
                String s2 = s.get(1);

                if(!stringToIndex.containsKey(s1) || !stringToIndex.containsKey(s2)){
                    results[i] = -1.0;
                } else {

                    int i1 = stringToIndex.get(s1);
                    int i2 = stringToIndex.get(s2);

                    results[i] = graph[i1][i2];
                }
            }

            return results;

        }



        public Map<String, Integer> createMapOfStringToIndex(List<List<String>> equations) {

            Map<String, Integer> stringToIndex = new HashMap<>();
            int count = 0;
            for(List<String> eqn : equations) {
                String s = eqn.get(0);
                String d = eqn.get(1);

                if(!stringToIndex.containsKey(s)){
                    stringToIndex.put(s, count++);
                }


                if(!stringToIndex.containsKey(d)){
                    stringToIndex.put(d, count++);
                }

            }

            return stringToIndex;



        }
    }


