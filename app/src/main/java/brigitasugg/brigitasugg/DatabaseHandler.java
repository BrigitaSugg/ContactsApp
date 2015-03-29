package brigitasugg.brigitasugg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {


    // All Static variables
// Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_FACEBOOK = "facebook";
    private static final String KEY_NEXT_MEETING_DATE_TIME = "next_meeting_date_time";
    private static final String KEY_NEXT_MEETING_LOCATION = "next_meeting_location";
    private static final String KEY_NEXT_MEETING_NOTES = "next_meeting_notes";
    private static final String KEY_LAST_MEETING_DATE_TIME = "last_meeting_date_time";
    private static final String KEY_LAST_MEETING_LOCATION = "last_meeting_location";
    private static final String KEY_LAST_MEETING_NOTES = "last_meeting_notes";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT, "
                + KEY_PH_NO + " TEXT, " + KEY_EMAIL + " TEXT, " + KEY_FACEBOOK + " TEXT, "
                + KEY_NEXT_MEETING_DATE_TIME + " TEXT, " + KEY_NEXT_MEETING_LOCATION + " TEXT, "
                + KEY_NEXT_MEETING_NOTES + " TEXT, " + KEY_LAST_MEETING_DATE_TIME + " TEXT, "
                + KEY_LAST_MEETING_LOCATION  + " TEXT, " + KEY_LAST_MEETING_NOTES + " TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    // Updating single contact
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getId())});
    }

    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getId())});
        db.close();
    }

    // Adding new contact
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // brigitasugg.brigitasugg.Contact Name
        values.put(KEY_PH_NO, contact.getPhoneNumber()); // brigitasugg.brigitasugg.Contact Phone Number
        values.put(KEY_EMAIL, contact.getEmail().toString());//brigitasugg.brigitasugg.Contact Email
        values.put(KEY_FACEBOOK, contact.getFacebook().toString());//brigitasugg.brigitasugg.Contact Facebook
        values.put(KEY_NEXT_MEETING_DATE_TIME, contact.getNextMeetingDateTime().toString());
        values.put(KEY_NEXT_MEETING_LOCATION, contact.getNextMeetingLocation().toString());//NextContactLocation
        values.put(KEY_LAST_MEETING_NOTES, contact.getNextMeetingNotes().toString());//NextContactNotes
        values.put(KEY_LAST_MEETING_DATE_TIME, contact.getLastMeetingDateTime().toString());//PreviousContactDate
        values.put(KEY_LAST_MEETING_LOCATION, contact.getLastMeetingLocation().toString());//PreviousContactLocation
        values.put(KEY_LAST_MEETING_NOTES, contact.getLastMeetingNotes().toString());//PreviousContactNotes
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_ID,
                        KEY_NAME, KEY_PH_NO, KEY_EMAIL, KEY_FACEBOOK, KEY_NEXT_MEETING_DATE_TIME, KEY_NEXT_MEETING_LOCATION
                        , KEY_LAST_MEETING_NOTES, KEY_LAST_MEETING_DATE_TIME, KEY_LAST_MEETING_LOCATION, KEY_LAST_MEETING_NOTES}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null
        );
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8),
                cursor.getString(9), cursor.getString(10));
        // return contact
        return contact;
    }

    // Getting All Contacts
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8),
                        cursor.getString(9), cursor.getString(10));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  count(*) FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int result = cursor.getInt(0);
        cursor.close();
        return result;
    }
}

