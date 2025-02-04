package com.example.alartdialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AlertDialog;
import java.util.Random;


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

    public void firstMessageOnly(View view)
    {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("first");
        abd.setMessage("msg");

        AlertDialog ad = abd.create();
        ad.show();
    }

    public void secondMessageIcon(View view)
    {
        abd = new AlertDialog.Builder(this);

        abd.setTitle("second");
        abd.setMessage("msg and icon");
        abd.setIcon(R.drawable.car);

        AlertDialog ad = abd.create();
        ad.show();
    }

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
}