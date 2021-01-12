package lib;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class PhoneNumberValidatorBuilder extends DefaultValidatorBuilder {
    public PhoneNumberValidatorBuilder() {
    	
    	
    	this.validation(character -> {
    		  
    		if(character.length()==10)
    		{
    		 if ((character.substring(0,1).compareTo("0") == 0) 
    				&& (character.substring(1,2).compareTo("0") != 0) )
    			return true; 
    		}
    		return false;
    		
    	}, "Enter valid phone number");
	}
}