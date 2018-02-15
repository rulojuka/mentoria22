package br.com.caelum.mentoria.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class MenuItem {

	private String title;
	private Optional<String> description;
	private List<MenuItem> children = new ArrayList<MenuItem>();
	private Set<Role> roles = new HashSet<Role>();

	public MenuItem(String title, String description) {
		this.title = title;
		this.description = Optional.ofNullable(description);
	}
	
	public MenuItem(String title) {
		this(title,null);
	}

	public String getTitle() {
		return this.title;
	}

	public Optional<String> getDescription() {
		return this.description;
	}

	public void addChild(MenuItem menuItem) {
		this.children.add(menuItem);
	}

	public List<MenuItem> getChildren() {
		return this.children;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}

	public boolean visibleFor(User user) {
		return roles.stream().anyMatch(role -> role.authorize(user));
	}
	
}
