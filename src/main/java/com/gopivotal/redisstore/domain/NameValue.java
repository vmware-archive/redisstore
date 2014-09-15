package com.gopivotal.redisstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class NameValue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "namevalue_seq_gen")
    @SequenceGenerator(name = "namevalue_seq_gen", sequenceName = "namevalue_id_seq")
    private long id;
    private String name;
    private String Value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NameValue [name=").append(name).append(", Value=")
				.append(Value).append("]");
		return builder.toString();
	}
	public NameValue(String name, String value) {
		super();
		this.name = name;
		Value = value;
	}
	public NameValue() {
		super();
	}



}