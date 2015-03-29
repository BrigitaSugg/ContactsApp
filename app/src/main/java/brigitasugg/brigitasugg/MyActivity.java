package brigitasugg.brigitasugg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        TextView Hello = (TextView) findViewById(R.id.Hello);
        TextView Today = (TextView) findViewById(R.id.Today);
        TextView Or = (TextView) findViewById(R.id.Or);
        Button buttonName = (Button) findViewById(R.id.CreateANewContact);
        Button buttonGo = (Button) findViewById(R.id.Create);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startCreateNewContact();

            }
        };

        buttonGo.setOnClickListener(listener);

        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startNewContact();

            };
        });
    }

    private void startCreateNewContact() {
        Intent intent = new Intent(this, createNewContact.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }



    private void startNewContact() {
        Intent intent = new Intent(this, NewContact.class);
        startActivity(intent);
    }
}

