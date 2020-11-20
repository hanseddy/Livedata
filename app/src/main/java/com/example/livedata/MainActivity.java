package com.example.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    frag1 frag1;
    frag2 frag2;
    myviewmodel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag1 = new frag1();
        frag2 = new frag2();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.constraint1, frag1).add(R.id.constraint2, frag2);
        fragmentTransaction.commit();
        /**************déclaration viewmodel*****************/
        viewmodel = new ViewModelProvider(this).get(myviewmodel.class);
        viewmodel.init();
    }
}