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

public class frag1 extends Fragment {
    EditText edit;
    Button button;
    myviewmodel viewmodelFrag1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag1, container, false);
        edit = v.findViewById(R.id.editFrag1);
        button = v.findViewById(R.id.buttonFrag1);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewmodelFrag1 = new ViewModelProvider(requireActivity()).get(myviewmodel.class); // initialisation du viewmodel
        // gestion de l'envoie
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = edit.getText().toString();
                viewmodelFrag1.SendMessageto2(message);
                //Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
            }
        });
        // gestion de la reception
        viewmodelFrag1.GetMessageFrom2().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                edit.setText(s);
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
