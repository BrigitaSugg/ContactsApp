package brigitasugg.brigitasugg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NewContact extends Activity {

    private EditText name;
    private EditText phoneNumber;
    private EditText email;
    private EditText facebook;
    private EditText nextMeetingDateTime;
    private EditText nextMeetingLocation;
    private EditText nextMeetingNotes;
    private EditText lastMeetingDateTime;
    private EditText lastMeetingLocation;
    private EditText lastMeetingNotes;
    private Button saveButton;
    private Button deleteButton;

    final private DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        name = (EditText) findViewById(R.id.name);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        email = (EditText) findViewById(R.id.email);
        facebook = (EditText) findViewById(R.id.facebook);
        nextMeetingDateTime = (EditText) findViewById(R.id.lastMeetingDateTime);
        nextMeetingLocation = (EditText) findViewById(R.id.nextMeetingLocation);
        nextMeetingNotes = (EditText) findViewById(R.id.nextMeetingNotes);
        lastMeetingDateTime = (EditText) findViewById(R.id.lastMeetingDateTime);
        lastMeetingLocation = (EditText) findViewById(R.id.nextMeetingLocation);
        lastMeetingNotes = (EditText) findViewById(R.id.nextMeetingNotes);

        //Code for getting details from intent passed byt ConnectionListActivity
        Intent intent = getIntent();
        final String contactId = intent.getStringExtra("contact_id");
        //Toast.makeText(getBaseContext(), contactId, Toast.LENGTH_LONG).show();
        //Upon receipt, pull up the object out of the database, based on ID, and populate the object here.

        //Save Button for adding a new contact, IF contact was not pulled over
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = new Contact(1,
                        name.getText().toString(),
                        phoneNumber.getText().toString(),
                        email.getText().toString(),
                        facebook.getText().toString(),
                        nextMeetingDateTime.getText().toString(),
                        nextMeetingLocation.getText().toString(),
                        nextMeetingNotes.getText().toString(),
                        lastMeetingDateTime.getText().toString(),
                        lastMeetingLocation.getText().toString(),
                        lastMeetingNotes.getText().toString()
                );
                db.addContact(contact);
                Toast.makeText(getBaseContext(), contact.getName() + " Contact Saved ", Toast.LENGTH_LONG).show();
            }
        });

        //Delete button implementation
        deleteButton = (Button) findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(NewContact.this);

                builder.setTitle("Attention")
                        .setMessage("Are you sure you want to delete this contact ?")
                        .setCancelable(false)
                        .setIcon(R.drawable.ic_launcher)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                delete(contactId);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }

        });
    }

    private void delete(String contactId) {
        db.deleteContact(db.getContact(Integer.parseInt(contactId)));
        Intent intent = new Intent(this, createNewContact.class);
        startActivity(intent);
    }
}



