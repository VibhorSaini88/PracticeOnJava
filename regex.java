import java.util.regex.*;
class RegularExp{
	public static void main(String[] arg){
		Pattern p = Pattern.compile("ab");
		Matcher m = p.matcher("abbbbabbba");
		int count  = 0 ;
		while(m.find()){
			System.out.println(m.start()+" "+m.end()+" "+m.group() );
			count++;
		}
		System.out.println(count);
	}
}