package exceptions;
import com.cisc181.core.Person;

public class PersonException extends Exception{
	private Person exceptionalPerson;
	
	public PersonException(Person p){
		this.exceptionalPerson = p;
	}
}