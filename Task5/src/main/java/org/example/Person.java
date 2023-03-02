package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Person {
    private String name;
    private boolean isEmployed;

    private int age;
    private Address address;
    private List<Hobby> hobbies;
    private List<FavoriteFood> favoriteFoods;
    public String getName() {
        return name;
    }

    Person(){}

    Person(String name, int age, boolean isEmployed){
        this.name = name;
        this.age = age;
        this.isEmployed = isEmployed;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    @JsonProperty("isEmployed")
    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    public int getAge(){
        return age;
    }

    @JsonProperty("age")
    public void setAge(int age){
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    @JsonProperty("hobbies")
    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public List<FavoriteFood> getFavoriteFoods() {
        return favoriteFoods;
    }

    @JsonProperty("favoriteFoods")
    public void setFavoriteFoods(List<FavoriteFood> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    @Override
    public String toString() {
        return "Person {" +
                "name = '" + name + '\'' +
                ", isEmployed = " + isEmployed +
                ", age = " + age +
                ", address = " + address +
                ", hobbies = " + hobbies +
                ", favoriteFoods = " + favoriteFoods +
                '}';
    }
}

class Address {
    private String street;
    private String city;
    private String state;

    public String getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

class Hobby {
    private String name;
    private String level;

    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    public String toString(){
        return "name: " + name + "; level: " + level;
    }
}

class FavoriteFood{
    private String name;
    private float rating;

    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(float rating) {
        this.rating = rating;
    }

    public String toString(){
        return "name: " + name + "; rating: " + rating;
    }
}
