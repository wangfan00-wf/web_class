package webadv.s99201105.p02;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.apache.commons.codec.digest.DigestUtils;
public class App {
	public static void main(String[] args) throws IOException{
    	Scanner in = new Scanner(System.in);
    	System.out.println("请输入学号:");
    	String id=in.nextLine();
    	System.out.println("请输入密码:");
    	String password=in.nextLine();
		try {
			FileReader file = new FileReader("E:\\spring_tools_projects\\p02\\users.txt");
			BufferedReader bf=new BufferedReader(file);
	    	String str;
			try {
				str = bf.readLine();
				String[] str_a=str.split("\\b ");
				bf.close();
		    	file.close();
		    	if(id.equals(str_a[0])) {
					if(sha256hex(password).equals(str_a[1])){
						System.out.println("登陆成功！");
					}
		    		else {
		    		System.out.println("密码错误！");
		    	}
		    	}else {
		    		System.out.println("学号不存在！");
		    	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    public static String sha256hex(String input) {
		String psw=DigestUtils.sha256Hex(input);
        return psw;
    }
}
