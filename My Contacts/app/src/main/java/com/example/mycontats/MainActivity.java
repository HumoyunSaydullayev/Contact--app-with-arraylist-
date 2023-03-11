package com.example.mycontats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mycontats.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{

    ArrayList<String> name=new ArrayList<String>();
    ArrayList<String>  last=new ArrayList<String>();
    ArrayList<String>  numbers=new ArrayList<String>();
    ArrayList<String>  email=new ArrayList<String>();
    ArrayList<String>  types=new ArrayList<String>();
    ArrayList<String>  company=new ArrayList<String>();
    ArrayList<String>  country=new ArrayList<String>();
    ArrayList<Integer> imageId=new ArrayList<Integer>();
    ArrayList<User> userArrayList=new ArrayList<User>();
    ListAdapter listAdapter;

    public ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        imageId.add(R.drawable.ic_launcher_foreground);
        name.add("Humoyun");
        last.add("Saydullayev");
        numbers.add("+998945741504");
        types.add("Do'st");
        country.add("Uzbekistan");
        company.add("Media park");
        email.add("Humoyun@gmail.com");
        for (int i = 0; i < name.size(); i++) {
            User user=new  User(name.get(i),last.get(i),numbers.get(i), email.get(i),types.get(i),company.get(i),country.get(i),imageId.get(i) );
            userArrayList.add(user);
        }

        listAdapter=new ListAdapter(MainActivity.this,userArrayList);
        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,UserActivity.class);
                intent.putExtra("name", name.get(i));
                intent.putExtra("last", last.get(i));
                intent.putExtra("image", imageId.get(i));
                intent.putExtra("number", numbers.get(i));
                intent.putExtra("email", email.get(i));
                intent.putExtra("country", country.get(i));
                intent.putExtra("company", company.get(i));
                startActivity(intent);
            }
        });

        View add=findViewById(R.id.add_aniamtion);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity.this,R.style.BottomSheetDialogTheme);
                View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.add_contact,findViewById(R.id.contaneir));
                bottomSheetDialog.setContentView(bottomSheetView);

                String[] SpinnerCountry={"Uzbekistan","Russia","USA","UK","China"};
                int[] SpinnerCountryImage={R.drawable.uzbekistan,R.drawable.russia,R.drawable.usa,R.drawable.uk,R.drawable.china};
                CustomAdapterCountry country_adapter=new CustomAdapterCountry(getApplicationContext(),SpinnerCountry,SpinnerCountryImage);
                Spinner Country_Spinner=bottomSheetView.findViewById(R.id.Country_spinner);
                Country_Spinner.setAdapter(country_adapter);


                String[] SpinnerType={"Family","Friend","Work","Other"};
                int[] SpinnerTypeImage={R.drawable.family,R.drawable.friend,R.drawable.work,R.drawable.others};
                CustomAdapterType type_adapter=new CustomAdapterType(getApplicationContext(),SpinnerType, SpinnerTypeImage);
                Spinner Type_Spinner=bottomSheetView.findViewById(R.id.type_spinner);
                Type_Spinner.setAdapter(type_adapter);

                String[] SpinnerCompany={"University","Ministry","None","Other"};
                int[] SpinnerCompanyImage={R.drawable.university,R.drawable.ministry,R.drawable.none,R.drawable.others};
                CustomAdapterCompany company_adapter=new CustomAdapterCompany(bottomSheetDialog.getContext(),SpinnerCompany,SpinnerCompanyImage);

                Spinner Company_Spinner=bottomSheetView.findViewById(R.id.company_spinner);
                Company_Spinner.setAdapter(company_adapter);


                TextView new_first_name=bottomSheetView.findViewById(R.id.first_name_edittext);
                TextView new_last_name=bottomSheetView.findViewById(R.id.last_name_edittext);
                TextView new_phone=bottomSheetView.findViewById(R.id.phone_edittext);
                TextView new_email=bottomSheetView.findViewById(R.id.email_edittext);
                Button save=bottomSheetView.findViewById(R.id.Save_contact);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!new_first_name.equals("") && !new_last_name.equals("") && !new_email.equals("")){
                            name.add(new_first_name.getText().toString());
                            last.add(new_last_name.getText().toString());
                            numbers.add(new_phone.getText().toString());
                            email.add(new_email.getText().toString());
                            imageId.add(R.drawable.ic_launcher_foreground);

                            String SelectCompany=SpinnerCompany[company_adapter.getPosition()];
                            company.add(SelectCompany);

                            String SelectType=SpinnerType[type_adapter.getPosition()];
                            types.add(SelectType);

                            String SelectCountry= SpinnerCountry[country_adapter.getPosition()];;
                            country.add(SelectCountry);

                            userArrayList.clear();
                            for (int i = 0; i < name.size(); i++) {
                                User user=new  User(name.get(i),last.get(i),numbers.get(i), email.get(i),types.get(i),company.get(i),country.get(i),imageId.get(i) );
                                userArrayList.add(user);
                            }
                            listAdapter=new ListAdapter(MainActivity.this,userArrayList);
                            binding.listView.setAdapter(listAdapter);
                            Toast.makeText(getApplicationContext(), "Qo'shildi",Toast.LENGTH_SHORT).show();
                        }



                    }
                });




                bottomSheetDialog.show();
            }
        });
    }
}