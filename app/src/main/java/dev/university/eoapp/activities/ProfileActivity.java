package dev.university.eoapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dev.university.eoapp.R;
import dev.university.eoapp.models.data;
import dev.university.eoapp.storage.SharedPrefManager;

public class ProfileActivity extends AppCompatActivity {



    Button buttonshop,buttonoffer,buttonaddevent,buttonshow,buttonchat,Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        buttonshop=findViewById(R.id.buttonshop);
        buttonoffer=findViewById(R.id.buttonoffer);
        buttonaddevent=findViewById(R.id.buttonaddevent);
        buttonshow=findViewById(R.id.buttonshow);
        buttonchat=findViewById(R.id.buttonchat);
        Logout=findViewById(R.id.buttonlogout);

        data user = SharedPrefManager.getInstance(ProfileActivity.this).getUser();

        String type=user.getType();


        if(type.equalsIgnoreCase("provider"))
            buttonoffer.setText("Add Offer");



        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });




        buttonshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity( new Intent(ProfileActivity.this,ShopActivity.class));


            }
        });

        buttonoffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                startActivity( new Intent(ProfileActivity.this,OffersActivity.class));


            }
        });



        buttonaddevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity( new Intent(ProfileActivity.this,addevent.class));


            }
        });


        buttonshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity( new Intent(ProfileActivity.this,show_my_events.class));


            }
        });



        buttonchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity( new Intent(ProfileActivity.this,ChatActivity.class));


            }
        });


    }






    @Override
    protected void onStart() {
        super.onStart();

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, RegisterActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }


    public void logout() {

        SharedPrefManager.getInstance(ProfileActivity.this).clear();
        Intent intent = new Intent(this, beginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
