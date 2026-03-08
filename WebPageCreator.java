public class WebPageCreator
{
	public static void main(String[] args){
		createWebpage(); //Linked from final method.
	}
	public static String surroundWithTag(String tag,String text){
		
		//Status: tested and working. This is to surround the text with a html tag.
		return "<" + tag + ">" + text + "</" + tag + ">";
	}
	public static String calculateAge(int days){
		
		//Status: tested and working.
		int years = (days/360); //years
		int months = (days/30); //months
		int remainingdays_postyears = days % 365; //days after removing years
		int remainingDays = remainingdays_postyears & 30; //days after removing months
		
		return "I am " + years + " years, " + months + " months, " + remainingDays + " days old";
		
	}
	public static String createHead(String name){
		
		//Status: tested and working. This is to automatically create a html title.
	return "<head><title>" + name + "</title></head>";
	
	}
	public static String createBody (String name,int age,String hobby){
		//This probably took years off my life thank you very much 
		
		String welcome_part = surroundWithTag("h1","Welcome to " + name + "'s" + " Website"); //link from tag method
		String age_part = surroundWithTag("p",calculateAge(age)); // link from calculate tag method plus a calculate age method inside
		String hobby_part = surroundWithTag("p","My favorite hobby is " + hobby); //simple link from tag method again
		String body_content = (welcome_part + age_part + hobby_part); //combining strings
		return surroundWithTag("body",body_content); //adding the body tag
		
	}
	public static void createWebpage(){
		
		//this could of been the main but instructions said that its a no no
		java.util.Scanner reader = new java.util.Scanner(System.in);
		
		System.out.println("drop ur name pls");
		String web_name = reader.next();
		
		System.out.println("give age in days po favor");
		int web_age = reader.nextInt(); 
		
		System.out.println("uhhh ur favorite hobby please????");
		String web_hobby = reader.next();
		
		//once again combining strings or concationation or whatever you wanna call them
		String head = createHead(web_name);
		String body = createBody(web_name,web_age,web_hobby);
		String html = surroundWithTag("html",head + body);
		
		System.out.println("Here's your webpage dude:");
		System.out.println(html);  //I'M FREEEEEEE
	}
}
		
	
