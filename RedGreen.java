/**
 *COSC326 Etude10: Red and Green
 *@author Alfred Pardoe
 *@id 7150195
 */

import java.util.*;

public class RedGreen{
  
    public static void main(String [] args){
	Scanner sc = new Scanner(System.in);
	String first;
	while(sc.hasNextLine()){
	    first = sc.nextLine();
	    if(!(first.isEmpty()) && first.charAt(0) != '#'){
		String result = "";
		String ar[] = first.split(" ");
		int a = Integer.parseInt(ar[0]);
		int b = Integer.parseInt(ar[1]);
		int upper = (a + b);
		for(int x = a; x < upper; x++){
		    String s = go(x);
		    result += s;
		}
		System.out.println(a + " " + b + "\n# " + result + "\n");
	    }else{
		if(sc.hasNextLine()){
		    String trash = first;
		}
	    }
	}

    }//end main
  
    public static String go(int i){
	String result = "";
	int red = 0;
	int green = 0;

	if(i == 1){
	    result = "G";
	    green++;
	}else if(i == 2 || i == 3){
	    result = "R";
	    red++;
	}else{
	    
	    while(i > 0){
		ArrayList<Integer> results = new ArrayList<Integer>();
		ArrayList<Integer> unique = new ArrayList<Integer>();
		String temp = "";
		for(int x = 2; x < i; x++){
		    int d = i / x;
		    results.add(d);
		}
		
		for(int y = results.size() - 1; y >= 0; y--){
		    if(!(unique.contains(results.get(y)))){
			unique.add(results.get(y));
		    }
		}
		
		for(Integer r : unique){
		    String s = go(r);
		    temp += s;
		    for(int c = 0; c < s.length(); c++){
			if(s.charAt(c) == 'G'){
			    green++;
			}else if(s.charAt(c) == 'R'){
			    red++;
			}
		    }
		}

		if(green > red){
		    result = "R";
		}else{
		    result = "G";
		}

		i--;
	    }
	}
	return result;	
    }//end go



}//end class
