package com.dreamchain.skeleton.web;

import com.dreamchain.skeleton.model.Country;

public class CountryCommand extends Country {

	private static final long serialVersionUID = -4686811929329857418L;

	private Boolean selected = false;
	
	public CountryCommand() {}

	public CountryCommand(Country user) {
		setCountryId(user.getCountryId());
        setName(user.getName());
	}

	public Country toCountry() {
        Country user = new Country();
		user.setCountryId(getCountryId());
		user.setName(getName());
		return user;
	}
	
	public Boolean getSelected() {
		return selected;
	}
	
	public void setSelected(Boolean changed) {
		this.selected = changed;
	}
	
}