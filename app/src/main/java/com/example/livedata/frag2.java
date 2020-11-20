package com.example.livedata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class frag2 extends Fragment {
    EditText edit2;
    Button button2;
    myviewmodel viewmodelFrag2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag2, container, false);
        edit2 = v.findViewById(R.id.editFrag2);
        button2 = v.findViewById(R.id.buttonFrag2);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewmodelFrag2 = new ViewModelProvider(requireActivity()).get(myviewmodel.class); // initialisation du viewmodel
        // gestion de l'envoie
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = edit2.getText().toString();
                viewmodelFrag2.SendMessageto1(message);
                //Toast.makeText(getContext(),"button 2 clicked",Toast.LENGTH_LONG).show();
            }
        });
        // gestion de la reception
        viewmodelFrag2.GetMessageFrom1().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                edit2.setText(s);
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
