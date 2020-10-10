package parse;

import java.util.Stack;

public class Parser {
	
	public static String parse(String operation, String str) {
		
		String result="";
	
		switch(operation) {
			
			case "DecimalToDecimal":
				if(isDecimal(str)==false) {
					result="Error";
					break;
				}
				result=str;
				break;
			case "BinaryToBinary":	
				if(isBinary(str)==false) {
					result="Error";
					break;
				}
				result=str;
				break;
			
			case "DecimalToBinary":
				
				if(isDecimal(str)==false) {
					result="Error";
					break;
				}
				
				Stack<String> record=new Stack<String>();
				int num=Integer.valueOf(str);
				for(;;){
					record.add(String.valueOf(num%2));
					num=Math.round(num/2);
					if(num==1) {
						record.add("1");
						break;
					}
				}
				StringBuilder sb=new StringBuilder();
				while(record.isEmpty()==false) {
					sb.append(record.peek());
					record.pop();
				}
				result=sb.toString();
				break;
				
			case "BinaryToDecimal":
				
				if(isBinary(str)==false) {
					result="Error";
					break;
				}
				
				int ppb=0;
				
				for(int i=0;i<=str.length()-1;i++) {
					
					if(str.charAt(str.length()-i-1)=='1') { //this checks from last position to first. StringBuilder.reverse() could have been used instead
						ppb+=Math.pow(2, i);
					}
				}
				result=String.valueOf(ppb);
				break;
			}
		
		return result;
	}
	private static boolean isBinary(String str) {
		String[] array=new String[2];
		try {
			for(char e:str.toCharArray()) {
				array[Character.getNumericValue(e)]="s";
			}
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	private static boolean isDecimal(String str) {
		try {
			Integer.valueOf(str);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
