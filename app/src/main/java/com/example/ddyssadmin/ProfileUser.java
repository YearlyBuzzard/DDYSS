package com.example.ddyssadmin;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileUser extends Fragment {

 private FirebaseAuth mAuth;
 private Button btnLogout;

 private TextView txtname;
 private TextView txtemail;
 private TextView txtnumber;


 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState) {
  View root = inflater.inflate(R.layout.fragment_profile_user, container, false);

  mAuth = FirebaseAuth.getInstance();

  btnLogout = (Button)root.findViewById(R.id.btnLogout);
  txtname = (TextView)root.findViewById(R.id.txtname);
  txtemail = (TextView)root.findViewById(R.id.txtemail);
  txtnumber = (TextView)root.findViewById(R.id.txtnumber);


  btnLogout.setOnClickListener(new View.OnClickListener() {

   @Override
   public void onClick(View view) {
    mAuth.signOut();
    Intent intent = new Intent(getActivity(), login.class);
    startActivity(intent);
    onStop();
   }
  });


  return  root;
 }

}
