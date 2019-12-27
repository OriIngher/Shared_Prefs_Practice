package com.example.shared_prefs_practice;
/**
 * @author oriin
 */

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tv1;
EditText ed1;
SharedPreferences settings;
int x;
String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = getSharedPreferences("prefs_name",MODE_PRIVATE);
        if (settings!=null)
        {
            x=settings.getInt("X",0);
            st = settings.getString("Text","Enter Text");
        }

        tv1= (TextView) findViewById(R.id.tv1);
        ed1= (EditText) findViewById(R.id.ed1);
        if (tv1!=null)
        {
            tv1.setText(Integer.toString(x));
        }
        if (ed1!=null)
        {
            ed1.setText(st);
        }
    }
    /**
     *
     * @param menu
     */
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     *
     * @param item
     * @return checks if "credits" button is pressed and if so moves to "credits" activity
     */
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id==R.id.credits)
        {
            Intent si = new Intent(this,credits.class);
            startActivity(si);
        }
        return true;
    }

    /**
     * @return inc the value showed on the Text View
     * @param view
     */
    public void Count(View view) {
        x = x+1;
        tv1.setText(Integer.toString(x));
    }

    /**
     * @return reset the value of the Text View and Edit Text
     * @param view
     */
    public void Reset(View view) {
        x=0;
        tv1.setText(Integer.toString(x));
        ed1.setText("");

    }

    /**
     * @return saving the data in the Text View and Edit Text and close the app
     * @param view
     */
    public void Exit(View view) {
        settings = getSharedPreferences("prefs_name",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("X",x);
        editor.putString("Text", String.valueOf(ed1.getText()));
        editor.commit();
        finish();


    }

}
