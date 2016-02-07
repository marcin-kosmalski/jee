package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {

	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "owner")
	private Set<CachedUnit> cachedUnitList = new HashSet<CachedUnit>();
	
	public Owner(){
		
	}

	public Owner(Long id, String name, Set<CachedUnit> cachedUnitList) {
		super();
		this.id = id;
		this.name = name;
		this.cachedUnitList = cachedUnitList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CachedUnit> getCachedUnitList() {
		return cachedUnitList;
	}

	public void setCachedUnitList(Set<CachedUnit> cachedUnitList) {
		this.cachedUnitList = cachedUnitList;
	}
	
	
}
