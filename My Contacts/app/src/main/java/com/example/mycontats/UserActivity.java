package com.example.mycontats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mycontats.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {
    public ActivityUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=this.getIntent();

        if(intent != null){
            String name=intent.getStringExtra("name");
            String lastName=intent.getStringExtra("last");
            int image=intent.getIntExtra("image",R.drawable.ic_launcher_foreground);
            String number=intent.getStringExtra("number");
            String email=intent.getStringExtra("email");
            String country=intent.getStringExtra("country");
            String company=intent.getStringExtra("company");
            binding.ItemPersonImage.setImageResource(image);
            binding.ItemName.setText(name+" "+lastName);
            binding.ItemNumber.setText(number);
            binding.ItemEmail.setText(email);
            binding.ItemCountry.setText(country);
            binding.ItemCompany.setText(company);

        }


    }
}