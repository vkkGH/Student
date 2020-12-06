/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author PC
 */
public class Address {
    private String aptNum;
    private String streetNum;
    private String streetName;
    private String city;
    private String province;
    private String zipcode;
    
    public Address() { // default;
        this.aptNum = null;
        this.streetNum = null;
        this.streetName = null;
        this.city = null;
        this.province = null;
        this.zipcode = null;
    }
    public Address(String aptNum, String streetNum, String streetName, String city, String province, String zipcode) {
        this.aptNum = aptNum;
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.zipcode = zipcode;
    }
    public Address(Address address){
        this.aptNum = address.aptNum;
        this.streetNum = address.streetNum;
        this.streetName = address.streetName;
        this.city = address.city;
        this.province = address.province;
        this.zipcode = address.zipcode;
    }
    public boolean isZipCodeValid(String zipCode){
        if (zipCode.length() != 7)
            return false;
        return Character.isLetter(zipCode.charAt(0)) &&
                Character.isDigit(zipCode.charAt(1)) &&
                Character.isLetter(zipCode.charAt(2)) &&
                Character.isWhitespace(zipCode.charAt(3)) &&
                Character.isDigit(zipCode.charAt(4)) &&
                Character.isLetter(zipCode.charAt(5)) &&
                Character.isDigit(zipCode.charAt(6));
                }   

    public boolean equals(Address address){
        return this.aptNum.equals(address.aptNum) &&
        this.streetNum.equals(address.streetNum) &&
        this.streetName.equals(address.streetName) &&
        this.city.equals(address.city) &&
        this.province.equals(address.province) &&
        this.zipcode.equals(address.zipcode); // equals for string and not ==
    }
      @Override
    public String toString() {
        String str = "";
        str += String.format("%-10s: %s\n", "aptNum", aptNum);
        str += String.format("%-10s: %s\n", "strNum", streetNum);
        str += String.format("%-10s: %s\n", "strName", streetName);
        str += String.format("%-10s: %s\n", "city", city);
        str += String.format("%-10s: %s\n", "province", province);
        str += String.format("%-10s: %s\n", "zipcode", zipcode);
        return str;
    }

    public String getAptNum() {
        return aptNum;
    }

    public void setAptNum(String aptNum) {
        this.aptNum = aptNum;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        if (isZipCodeValid(zipcode))
            this.zipcode = zipcode;
        else
            System.out.println("%sis not a valid zipcode" +zipcode);
    }
    }
