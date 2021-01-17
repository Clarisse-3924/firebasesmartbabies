package com.example.smartbabies;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView Name;
    DrawerLayout drawerLayout;
List<listview>list;
ListView list_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (TextView) findViewById(R.id.name);
        drawerLayout = findViewById(R.id.drawer_layout);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Name.setText("WELCOME TO OUR STORE: " + name);
        list=new ArrayList<>();
        list.add(new listview(R.drawable.baby1,"Dress","5000 RWF", "Add To Cart"));
        list.add(new listview(R.drawable.baby2,"Dress","10000 RWF", "Add To Cart"));
        list.add(new listview(R.drawable.baby3,"Dress","6000 RWF", "Add To Cart"));
        list.add(new listview(R.drawable.baby4,"Trousers","15000 RWF", "Add To Cart"));
        list.add(new listview(R.drawable.baby5,"Trousers","7000 RWF", "Add To Cart"));
        list.add(new listview(R.drawable.baby6,"Shirt","5000 RWF", "Add To Cart"));
        list.add(new listview(R.drawable.baby7,"T-shirt","3000 RWF", "Add To Cart"));

        list_item=findViewById(R.id.list_item);
        mylistadapter adapter= new mylistadapter(this,R.layout.store,list);
        list_item.setAdapter(adapter);
    }
    public void ClickMenu(View view){
        //open drawe
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        // open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        //close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //close drawer layout
        //check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //when drawer is open
            //close drawe
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickHome(View view){
        //recreate activity
        recreate();
    }
    public void ClickAdmin(View view){
        //redirect to dashborad
        //MainActivity.redirectActivity(this,AdminLogin.class);
    }


    public void ClickSignUp(View view){
        //redirect about us
        MainActivity.redirectActivity(this,Signup.class);
    }
    public void Clickface(View view){
        //redirect about us
        MainActivity.redirectActivity(this,facebooklogin.class);
    }
    public void ClickLogin(View view){
        //redirect about us
        MainActivity.redirectActivity(this,Login.class);
    }
    public void Clickcontact(View view){
        //redirect about us
        MainActivity.redirectActivity(this,contact.class);
    }


    public void ClickLogout(View view){
        //close app
        logout(this);
    }

    public static void logout(final Activity activity) {
        //initialize dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("Lougout");
        //set meassage
        builder.setMessage("Are you sure you want to logout ?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finish activity
                activity.finishAffinity();
                //exit app
                System.exit(0);
            }
        });
        //negative button
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dismiss dialog
                dialog.dismiss();
            }
        });
        //show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity,Class aclass) {
        //Initialize intent
        Intent intent = new Intent(activity,aclass);
        //set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
    @Override
    protected void onPause(){
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }
}