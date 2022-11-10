package com.example.ddyssadmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileUser extends Fragment {

 private FirebaseAuth mAuth;
 private Button btnLogout;

 private TextView mFullName, mEmail, mPassword, mPhone;
 private DatabaseReference mDatabase;


 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState) {
  View root = inflater.inflate(R.layout.fragment_profile_user, container, false);

  mAuth = FirebaseAuth.getInstance();
  mDatabase = FirebaseDatabase.getInstance().getReference();
  btnLogout = (Button)root.findViewById(R.id.btnLogout);
  mFullName = (TextView)root.findViewById(R.id.txtname);
  mEmail = (TextView)root.findViewById(R.id.txtemail);
  mPhone = (TextView)root.findViewById(R.id.txtnumber);

  btnLogout.setOnClickListener(new View.OnClickListener() {

   @Override
   public void onClick(View view) {
    mAuth.signOut();
    Intent intent = new Intent(getActivity(), login.class);
    startActivity(intent);
    onStop();
   }
  });

  getUserInfo();
  return root;

 }

  private void getUserInfo() {
  String id = mAuth.getCurrentUser().getUid();
   mDatabase.child("User").child(id).addValueEventListener(new ValueEventListener(){

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
      if (dataSnapshot.exists()) {
       String Name = dataSnapshot.child("Name").getValue().toString();
       String Email = dataSnapshot.child("Email").getValue().toString();
       String Phone = dataSnapshot.child("Phone").getValue().toString();

       mFullName.setText(Name);
       mEmail.setText(Email);
       mPhone.setText(Phone);
      }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
   });
}
}
