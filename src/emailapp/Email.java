package emailapp;

import java.util.Scanner;

public class Email {
	private String  firstName;
	private String  lastName;
	private String password;
	private String department; //학과
    private String email;
	private int mailboxCapacity = 500; //사서함 용량
	private int defaultpasswordLength =10 ; //기본 암호 길이
	private String alternateEmail; // 다른 이메일
	private String companySuffix = "aeycompany.com"; //회사 접미사
	
	// Constructor to receive the first name and lastName
	//이름과 성을 받을 생성자 
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		// call a method asking for the department - return the department
		// 학과 호출-학과 반환
		this.department = setDepartment();
		
		//call a method that return a random password 임의로 암호를 반환하는 메서드 오출
		this.password = randomPassword(defaultpasswordLength);
		System.out.println("Your password is:" + this.password);
		
		// combine element to generate email 이메일 생성
		email = firstName.toLowerCase() +"."+lastName.toLowerCase()+
				"@"+ department + "." +companySuffix;		
	}
	// Ask for the department 학과 물어보기
	private String setDepartment() {
		System.out.println("New worker:"+firstName+".Department Codes:\n1 "
				+ "for sales\n2 for Dvelopment\n3 for Accouting\n0 "
				+ "for none\nEneter dapartment code:");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) { return"sales" ; }
		else if (depChoice ==2) {return "dev";}
		else if (depChoice ==3) {return "acct";}
		else {return "";}
		}
	
	
	//Generate a random password  임의 암호 생성
    private String randomPassword(int length) {
    	String passwordSet ="ABCEFGHIJKLMNOPQRSTUXYZ0123456789!@#$%";
    	char[] password = new char[length];
    	for(int i =0; i<length; i++) {
    		int rand =(int)(Math.random()* passwordSet.length());
    		password[i]= passwordSet.charAt(rand);   		
    	}
    	return new String(password);
       }
    
	
	// set the mailbox capacity 사서함 용량 설정
    public void setMailboxCapacity(int capacity) {
    	this.mailboxCapacity = capacity;
    }
	
	//set the alternate email 다른 이메일 설정
    public void setAlternateEmail(String altEamil) {
    	this.alternateEmail = altEamil;
    }
	
	//change the password // 비번 바꾸기
    public void chagePassword(String password) {
    	this.password = password;
    }
    public int getMailboxCapacity() {return mailboxCapacity;}
    public String getAlternateEmail() { return alternateEmail;}
    public String getPassword() {return password;}
	
    public String showInfo() {
    	return "DISPLAY NAME:" + firstName+""+ lastName+
    			"\nCOMPANY EMAIL:"+email+
    			"\nMAILBOX CAPACITY:" + mailboxCapacity + "mb";
    }
}


