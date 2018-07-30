package mx.edu.uacm.primerproyectohbm.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity	
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany(cascade= {CascadeType.PERSIST , CascadeType.MERGE})
	private List<Address> addresses = new ArrayList<>();
	
	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}
