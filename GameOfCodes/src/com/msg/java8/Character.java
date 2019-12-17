package com.msg.java8;
public class Character {
	private int id;
	private String name;
	private String title;
	private boolean male;
	private String mother;
	private String father;
	private String house;
	private String spouse;
	private boolean isMarried;
	private boolean isNoble;
	private Integer age;
	private boolean isAlive;
	
	public Character(int id, String name, String title) {
		this.id=id;
		this.name=name;
		this.title=title;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getSpouse() {
		return spouse;
	}
	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public boolean getIsAlive() {
		return isAlive;
	}
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public boolean isNoble() {
		return isNoble;
	}

	public void setNoble(boolean isNoble) {
		this.isNoble = isNoble;
	}
	
	public String toShortString() {
		return "Character [id=" + id + ", title=" + title + ", name=" + name +  "]";	
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", title=" + title + ", male=" + male + ", mother="
				+ mother + ", father=" + father + ", house=" + house + ", spouse=" + spouse + ", isMarried=" + isMarried
				+ ", isNoble=" + isNoble + ", age=" + age + ", isAlive=" + isAlive + "]";
	}


}
