package addressBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Scanner;

@Entity
public class BuddyInfo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;
    private int age;

    public BuddyInfo() {} //javabeans convention

    public BuddyInfo(String name) {
        this.name = name;
        this.address = this.phoneNumber = "unknown";
    }

    public BuddyInfo(BuddyInfo b) {
        this.name = b.getName();
        this.address = b.getAddress();
        this.phoneNumber = b.getPhoneNumber();
        this.age = b.getAge();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return this.age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return this.getName() + "#" + this.getAddress() + "#" + this.getPhoneNumber() + "#" + this.getAge();
    }

}

