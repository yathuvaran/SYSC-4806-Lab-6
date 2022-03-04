package addressBook;

import java.util.ArrayList;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class AddressBook implements Serializable {

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BuddyInfo> buddies;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private BuddyInfo bookOwner;

    public AddressBook() {
        buddies = new ArrayList<>();
        this.bookOwner = new BuddyInfo();
    }

    public AddressBook(BuddyInfo bookOwner) {
        this.bookOwner = bookOwner;
        buddies = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddyToAdd) {
        buddies.add(buddyToAdd);
    }

    public void removeBuddy(BuddyInfo buddyToRemove) {
        buddies.remove(buddyToRemove);
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        else if (o == null)
            return false;
        else if (!(o instanceof AddressBook))
            return false;
        AddressBook other = (AddressBook) o;
        boolean same = other.getBuddies().equals(this.buddies);
        return same;
    }

}
