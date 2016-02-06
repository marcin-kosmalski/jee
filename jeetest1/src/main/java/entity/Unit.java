package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Unit {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@JsonIgnore
	private String type;

	public static Unit create(String name, String type) {
		return new Unit(name, type);
	}

	public Unit() {

	}

	public Unit(String name, String type) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Unit [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}
