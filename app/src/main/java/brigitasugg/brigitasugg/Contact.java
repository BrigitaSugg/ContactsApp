package brigitasugg.brigitasugg;

import android.location.Location;
import android.provider.ContactsContract;

import java.util.Date;

/**
 * Created by mksugg on 3/26/15.
 */
public class Contact {
    //private variables
    int id;
    String name;
    String phoneNumber;
    String email;
    String facebook;
    String nextMeetingDateTime;
    String nextMeetingLocation;
    String nextMeetingNotes;
    String lastMeetingDateTime;
    String lastMeetingLocation;
    String lastMeetingNotes;


    // Empty constructor
    public Contact() {

    }

    public Contact(int id, String name, String phoneNumber, String email, String facebook, String nextMeetingDateTime, String nextMeetingLocation, String nextMeetingNotes, String lastMeetingDateTime, String lastMeetingLocation, String lastMeetingNotes) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.facebook = facebook;
        this.nextMeetingDateTime = nextMeetingDateTime;
        this.nextMeetingLocation = nextMeetingLocation;
        this.nextMeetingNotes = nextMeetingNotes;
        this.lastMeetingDateTime = lastMeetingDateTime;
        this.lastMeetingLocation = lastMeetingLocation;
        this.lastMeetingNotes = lastMeetingNotes;
    }

    public Contact(String name, String phoneNumber, String email, String facebook, String nextMeetingDateTime, String nextMeetingLocation, String nextMeetingNotes, String lastMeetingDateTime, String lastMeetingLocation, String lastMeetingNotes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.facebook = facebook;
        this.nextMeetingDateTime = nextMeetingDateTime;
        this.nextMeetingLocation = nextMeetingLocation;
        this.nextMeetingNotes = nextMeetingNotes;
        this.lastMeetingDateTime = lastMeetingDateTime;
        this.lastMeetingLocation = lastMeetingLocation;
        this.lastMeetingNotes = lastMeetingNotes;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getNextMeetingDateTime() {
        return nextMeetingDateTime;
    }

    public void setNextMeetingDateTime(String nextMeetingDateTime) {
        this.nextMeetingDateTime = nextMeetingDateTime;
    }

    public String getNextMeetingLocation() {
        return nextMeetingLocation;
    }

    public void setNextMeetingLocation(String nextMeetingLocation) {
        this.nextMeetingLocation = nextMeetingLocation;
    }

    public String getNextMeetingNotes() {
        return nextMeetingNotes;
    }

    public void setNextMeetingNotes(String nextMeetingNotes) {
        this.nextMeetingNotes = nextMeetingNotes;
    }

    public String getLastMeetingDateTime() {
        return lastMeetingDateTime;
    }

    public void setLastMeetingDateTime(String lastMeetingDateTime) {
        this.lastMeetingDateTime = lastMeetingDateTime;
    }

    public String getLastMeetingLocation() {
        return lastMeetingLocation;
    }

    public void setLastMeetingLocation(String lastMeetingLocation) {
        this.lastMeetingLocation = lastMeetingLocation;
    }

    public String getLastMeetingNotes() {
        return lastMeetingNotes;
    }

    public void setLastMeetingNotes(String lastMeetingNotes) {
        this.lastMeetingNotes = lastMeetingNotes;
    }
}

