package com.example.alartdialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AlertDialog;
import java.util.Random;
import android.content.Intent;


/**
 * @author		Amir Youssef amiryoussef1210@gmail.com
 * @version	1.6 (current version number of program)
 * @since		6/2/2025
 * this is the main that deals with all the button option
 */

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder abd;

    LinearLayout ll;

    Random rnd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.main);
        rnd = new Random();


    }


    /**
     * shows message only
     *
     *
     * @param	view the view
     * @return	None
     */

    public void firstMessageOnly(View view)
    {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("first");
        abd.setMessage("msg");

        AlertDialog ad = abd.create();
        ad.show();
    }


    /**
     * shows message and icon
     *
     *
     * @param	view the view
     * @return	None
     */
    public void secondMessageIcon(View view)
    {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("second");
        abd.setMessage("msg and icon");
        abd.setIcon(R.drawable.car);

        AlertDialog ad = abd.create();
        ad.show();
    }


    /**
     * shows icon and exit button
     *
     *
     * @param	view the view
     * @return	None
     */
    public void thirdMessageIconExit(View view)
    {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("third");
        abd.setMessage("msg icon and exit");
        abd.setIcon(R.drawable.car);
        abd.setPositiveButton("exit", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });

        AlertDialog ad = abd.create();
        ad.show();
    }



    /**
     * shows message gives the option to randomly change the background and exit button
     *
     *
     * @param	view the view
     * @return	None
     */
    public void forth(View view) {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("forth");
        abd.setMessage("change bg color");
        abd.setPositiveButton("exit", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        abd.setNegativeButton("random", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                ll.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });

        AlertDialog ad = abd.create();
        ad.show();
    }


    /**
     * shows message exit button gives the option to change the bg color randomly and change the bg color to white
     *
     *
     * @param	view the view
     * @return	None
     */
    public void fifth(View view)
    {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("fifth");
        abd.setMessage("random color and white");
        abd.setPositiveButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        abd.setNegativeButton("random", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ll.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        abd.setNeutralButton("back to white", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ll.setBackgroundColor(Color.WHITE);
            }
        });

        AlertDialog ad = abd.create();
        ad.show();
    }



    /**
     * create menu
     *
     *
     * @param	menu  the menu
     * @return	None
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    /**
     * go to the credits activity and check the id
     *
     *
     * @param	menu the menu
     * @return	None
     */
    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.goToCredits)
        {
            Intent si = new Intent(this, CreditsActivity.class);
            startActivity(si);
        }

        return true;
    }
}