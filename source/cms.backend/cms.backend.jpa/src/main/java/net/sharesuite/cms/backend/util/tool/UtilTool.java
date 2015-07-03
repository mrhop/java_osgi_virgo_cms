package net.sharesuite.cms.backend.util.tool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilTool {

	public static String getUUIDUniqueId() {
		String returnStr = UUID.randomUUID().toString();
		returnStr = returnStr.replace("-", "");
		return returnStr;
	}

	public static String getTimestampUniqueId() {
		String returnStr = String.valueOf(new Date().getTime());
		returnStr = returnStr
				+ String.valueOf((int) (Math.random() * 1000 + 1000));
		return returnStr;
	}
	
	public static List<String> getMatches(String content,String regex) {
		Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(content);
        List<String> result=new ArrayList<String>();
        while(match.find()){
			result.add(match.group());
		}
        return result;
	}
	
	public static void main(String[] args){
		/*StringUtils*/
//		String[] abc="a$a".
//		System.out.print("a$a".split("\\$")[0]);
		
/*		Pattern pattern = Pattern.compile("\\$\\{(?!element:)[\\s\\S]*\\}");
		
         Matcher match = pattern.matcher("a${ccc:abc}b");
         List<String> result=new ArrayList<String>();
         while(match.find()){
 			result.add(match.group());
 		}
       
		String a="a${abc}b";
		String[] arr = a.split("\\$\\{[\\s\\S]*\\}");
		
		System.out.println(arr.length);
		System.out.println("${element:abc}".replace("${element:", "").replace("}", "").length());
		*/
		/*System.out.println("${element:abc}".replaceAll("\\$\\{element:", "").replaceAll("\\}", ""));

		System.out.println("${text1:textfield}".replaceAll("\\$", "").replaceAll("\\{", "").replaceAll("\\}", "").split(":")[0]);
*/		System.out.println("abc${element:14345946982091858}def".replace("${element:14345946982091858}", "abc${text1:textfield}def"));
		}
}
