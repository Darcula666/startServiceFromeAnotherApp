package net.gfdz.com.anotherapp;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * 通过anotherapp启动app的Service
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     private Button mbtn01;
    private Button mbtn02;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn01= (Button) findViewById(R.id.btnStart);
        mbtn01.setOnClickListener(this);
        mbtn02= (Button) findViewById(R.id.btnStop);
        mbtn02.setOnClickListener(this);
         i=new Intent();
        i.setComponent(new ComponentName("net.gfdz.com.startservicefromeanotherapp","net.gfdz.com.startservicefromeanotherapp.AppService"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStart:


                startService(i);
                break;
            case R.id.btnStop:
                stopService(i);
                break;
        }
    }
}
