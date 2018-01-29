package com.example.user.android_assignment_15;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    //public is a method and fields can be accessed by the members of any class.
    //class is a collections of objects.
    //created MainActivity and extends with AppCompatActivity which is Parent class.

    RecyclerView recyclerView;
    MyAdapter adapter;
    //Intializing the recycler view and adapter.
    String[]data={"Alpha","Beta","Cupcake","Donut","Eclairs","Froyo","GingerBread","HoneyComb","IceCreamSandwich","JellyBean","KitKat","Lollipop","Marshmallow","Nougat","Oreo"};
    //giving data into a string with the name of data

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    protected void onCreate(Bundle savedInstanceState) {
        //protected can be accessed by within the package and class and subclasses
        //The Void class is an uninstantiable placeholder class to hold a reference to the Class object
        //representing the Java keyword void.
        //The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity
        // Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle.
        super.onCreate(savedInstanceState);
        //Android class works in same.You are extending the Activity class which have onCreate(Bundle bundle) method in which meaningful code is written
        //So to execute that code in our defined activity. You have to use super.onCreate(bundle)
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //main is the xml you have created under res->layout->main.xml
        //Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        //he other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        //the design

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //giving the toolbar with the id
        setSupportActionBar(toolbar);
        //declaring id's and set adapter to the recyclerview
        recyclerView=(RecyclerView)findViewById(R.id.rv);
        //giving the recycler id as rv.
        adapter=new MyAdapter(data);
        //creating the new adapter and getting the data which is applied in string
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        //A LayoutManager is responsible for measuring and positioning item views within a RecyclerView as well as determining the policy for when to recycle item views that are no longer visible to the user.
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        //An ItemDecoration allows the application to add a special drawing and layout offset to specific item views from the adapter's data set.
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //This class defines the animations that take place on items as changes are made to the adapter.
        recyclerView.setAdapter(adapter);
        //setting the adapter to the recyclerview.



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //declaring the id and creating new object as fab
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //giving the method of seton click listener when we click the click button for response.
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //giving like a toast as replace with your own action when clicking on float button.
                        .setAction("Action", null).show();
                //giving an action as to show the popup.
            }
        });
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //getting the xml from the main_menu
        return true;
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
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
}