package brigitasugg.brigitasugg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.LinkedList;
import java.util.List;

public class createNewContact extends Activity {
    final private DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_new_contact);
        List<String> contactsStrings = new LinkedList<String>();
        for (Contact c : db.getAllContacts()) {
            contactsStrings.add(c.getName());
        }
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsStrings);
        ListView listView = (ListView) findViewById(R.id.contactList);
        listView.setAdapter(itemsAdapter);
        
        Button Create = (Button) findViewById(R.id.Create);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.page1);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            //Trying to connect to the next activity
            public void onClick(View view) {

                startNewContact();

            }

        };
        Create.setOnClickListener(listener);

    }

    private void startNewContact() {
        Intent intent = new Intent(getApplicationContext(), NewContact.class);
        startActivity(intent);
    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_new_contact, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }}



