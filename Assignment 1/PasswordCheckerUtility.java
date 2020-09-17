import java.util.ArrayList;


/**
 * PasswrodCheckerUtility class with three main methods:
 * 1) isValidPassword - check if password is valid, return boolean
 * 2) isWeakPassword - check if password is weak, return boolean
 * 3) invalidPasswords - return array list of invalid passwords
 * @author felixyu00
 *
 */

public class PasswordCheckerUtility {
	
	private String pwdString;
	

	//Parameterized constructor
	public PasswordCheckerUtility() throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, InvalidSequenceException {
		setPassword(pwdString);
		isValidPassword(pwdString);
	    isWeakPassword(pwdString);
		//invalidPasswords(ArrayList<String> null);
	}
	
	//setting the parameter
	public void setPassword(String pwdString){
		
		this.pwdString = pwdString;
	}
	
	//method to check if password is valid
	//1.At least 6 characters long
	//2.10 or more characters is a strong password, between 6 and 9 characters is a weak (but acceptable) password
	//3.At least 1 numeric character
	//4.At least 1 upper case alphabetic character
	//5.At least 1 lower case alphabetic character
	public static boolean isValidPassword(String pwdString) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, InvalidSequenceException {
		
		boolean hasUppercase = !pwdString.equals(pwdString.toLowerCase());
		boolean hasLowercase = !pwdString.equals(pwdString.toUpperCase());
		
		//if password is valid, return true
		
		//if password is equals to or longer than 6 characters, if statement continues, if not, throw LengthException
		if (pwdString.length() >= 6){
			//if password has at least one upper case character, if statement continues, if not, throw NoUpperAlphaException
			if (hasUppercase) {
				//if password has at least one lower case character, if statement continues, if not, throw NoLowerAlphaException
				if (hasLowercase) {
					//if password has numbers, if statement continues, if not, throw NoNumberExecption
					if (pwdString.matches("(?=.*[0-9]).*")) {
						//if password doesn't have repeating characters (loop through String and compare adjacent characters), 
						//the for loop and if statement will end, returning the boolean true value. If not, throw InvalidSequenceException
						for (int i = 0; i < (pwdString.length()-1); i++) {
							if(pwdString.charAt(i)==pwdString.charAt(i+1)) {
								if(Character.isUpperCase(pwdString.charAt(i)) == Character.isUpperCase(pwdString.charAt(i+1))){
									throw new InvalidSequenceException("This password has an invalid sequence with two repeating characters.");
								}
							}
						}		
						return true;	
					}
					else {
						throw new NoDigitException("This password must contain at least one digit.");
					}
				}
				else {
					throw new NoLowerAlphaException("This password must contain at least one lower case chatacter.");
				}
			}
			else {
				throw new NoUpperAlphaException("This password must contain at least one upper case character.");
			}
		}
		else {
			throw new LengthException("The password must contain at least 6 characters long.");
		}
	}
		
	
	//method to check whether a password is weak
	public static boolean isWeakPassword(String pwdString) {
		
		if(pwdString.length() >= 10) 
			return false;
		return true;
	}
	
	//method returns the list of invalid passwords
	public static ArrayList<String> invalidPasswords(ArrayList<String> passwords) {

		ArrayList<String> invalid_passwords = new ArrayList <String>(passwords.size());	
		for(int i = 0; i < passwords.size(); i++) {
			try {
				PasswordCheckerUtility.isValidPassword(passwords.get(i));
				}
			catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| InvalidSequenceException e) {
			invalid_passwords.add(passwords.get(i));
			}
		}
		return invalid_passwords;
		
	}
	
}