import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Solution {
	
	/*
	 * 
	 */
	static void displayArray(int[] arr) {
		System.out.print("arr: ");
		for (int i = 1; i <= arr.length; i++) {
			System.out.print(arr[i - 1] + " ");
			if (i % 10 == 0)
				System.out.println();
		}
		System.out.println();
	}
	

    // Complete the climbingLeaderboard function below.
	// It should return an integer array where each element res[j]
	// represents Alice's rank after the jth game. 
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

    	int count = alice.length;
    	
//    	System.out.println("count: " + count);

    	int[] rank 					= new int[count];

//    	TreeMap<Integer, Integer> map 	= new TreeMap<Integer, Integer>();
//
//    	// **** populate the tree with the scores ****
//    	for (int s : scores) {
//    		if (map.containsKey(s)){
//    			map.put(s, map.get(s) + 1);
//    		} else {
//    			map.put(s, 1);
//    		}
//    	}

//    	System.out.println("map: " + map.toString() + "\n");
    	
    	// **** remove duplicates and sort scores ****
    	scores = IntStream.of(scores).distinct().sorted().toArray();
//    	displayArray(scores);
    	
//    	alice = IntStream.of(alice).sorted().toArray();
//    	displayArray(alice);

    	
    	// **** loop adding Alice's scores to the tree and computing her rank ****
    	for (int i = 0; i < alice.length; i++) {
    		
//    		System.out.println("alice[i]: " + alice[i]);
    		
    		int j = Arrays.binarySearch(scores, alice[i]);
    		
//    		System.out.println("j: " + j);
    		
    		// **** ****
    		if (j < 0)
    			rank[i] = scores.length - Math.abs(j) + 2;
    		else
    			rank[i] = scores.length - j;
    		
//			System.out.println("rank[" + i + "]: " + rank[i]);
    	}

    	
//    	// **** loop adding Alice's scores to the tree and computing her rank ****
//    	int i = 0;						// rank index
//	   	int j = 0;						// map index
//    	for (int a : alice) {
//    		
////    		System.out.println("a: " + a);
//    		
//    		// **** add Alice's score to the map ****
//    		if (map.containsKey(a)) {
//    			map.put(a, map.get(a) + 1);
//    		} else {
//    			map.put(a, 1);
//    		}
//    		
////    	   	System.out.println("                map: " + map.toString());  
////    		System.out.println("map.entrySet().size: " + map.entrySet().size());
//
//    		// **** determine and save Alice's rank at this time ****
//    	  	for ( ; j < map.entrySet().size(); j++) {
//    	  		
//    	  		// **** get the grade at this index ****
//    	  		int g = (int)map.keySet().toArray()[j];
//    	  		
////    	  		System.out.println("g[" + j + "]: " + g);
//    	  		
//    	  		// **** if Alice's grade matches; then compute and save this rank ****
//    	  		if (a == g) {
//    	  			
//    	  			// **** compute and save Alice's rank ****
//    	  			rank[i] = map.size() - j;
//    	  			
////    	  			System.out.println("rank[" + i + "]: " + rank[i]);
//    	  			
//    	  			// **** increment indices ****
//    	  			i++;
//    	  			j++;
//    	  			break;
//    	  		} 
//    	  	}
//    	}

    	
    	// **** return Alices's rankings ****
    	return rank;
    }

    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
