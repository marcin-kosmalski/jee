package entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
public class CachedUnit {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@JsonIgnore
	private String type;

	@ManyToOne(fetch=FetchType.LAZY)
	private Owner owner;
	
	public static CachedUnit create(String name, String type) {
		return new CachedUnit(name, type);
	}

	public CachedUnit() {

	}

	public CachedUnit(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	

	@Override
	public String toString() {
		return "Unit [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}
