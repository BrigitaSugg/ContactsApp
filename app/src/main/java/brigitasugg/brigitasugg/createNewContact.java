package brigitasugg.brigitasugg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class createNewContact extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_contact);


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


