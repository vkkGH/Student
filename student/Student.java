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
public class Student {
    private String name;
    private int age;
    private String gender;
    private String id;
    private String email;   // name@vaniercollege.qc.ca
    private Address address;
    private static int nextId = 1; // one copy of it
    private final static String SCHOOL_NAME = "Vanier College";  // here because final static, you do snake case, like SCHOOL_NAME and not schoolName
   
    public Student(){
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.id = null;
        this.email = null;
        this.address = null;
    }
    
    public Student(String name, int age, String gender, Address address){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = String.format("%06d", nextId++); // static variable
        generateEmail();
        this.address = address;
    }
    public Student(Student student){
        this.name = student.name;
        this.age = student.age;
        this.gender = student.gender;
        this.id = student.id;
        this.email = student.email;
        this.address = new Address(student.address); // deep copy
}
    public void generateEmail(){
        email = String.format("%s@vaniercollege.qc.ca", name.toLowerCase());
    }
    public static boolean isNameValid(String name){ // this is static, you can't put a non static in a static, but you can put a static in a static
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && c != '-' && c != '\'')
                return false;
        }
        return true;
    }
    public void checkDistance() {
        if (address.getCity().equalsIgnoreCase("montreal"))
            System.out.println("Not far");
        else if (address.getProvince().equalsIgnoreCase("qc"))
            System.out.println("Not far, not close");
        else
            System.out.println("Very Far");
    }
    
    public boolean equals(Student student){
        return this.name.equals(student.name) &&
                this.age == student.age &&
                this.gender.equals(student.gender) && this.id.equals(student.id) && this.email.equals(student.email) && this.address.equals(student.address);
    }
    @Override
    public String toString(){   // non static method (basically what is not said static is not static)
        String str = "";
        str += String.format("Student from %s\n", SCHOOL_NAME); // static var
        str += String.format("%-10s: %s\n", "Name", name);
        str += String.format("%-10s: %s\n", "Age", age);
        str += String.format("%-10s: %s\n", "Gender", gender);
        str += String.format("%-10s: %s\n", "Id", id);
        str += String.format("%-10s: %s\n", "Email", email);
        str += String.format("%-10s: %s\n", "Address", address);
        return str;
        
    }

    public String getName() { 
        return name;
    }

    public void setName(String name) {
        if (isNameValid(name)) {
        this.name = name;
        email = String.format("%s@vaniercollege.qc.ca", name);
    }
        else
            System.out.println("Sorry, the new name is invalid...");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setEmail(String email){
        this.email = email;
        int atIdx = email.indexOf('@');
        name = email.substring(0, atIdx);
    }
    
    // public Student (String name, Sting gender) { non static method
// non static can use static and non static
    // always when you put a bracket, put a space

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}


  
    
    
