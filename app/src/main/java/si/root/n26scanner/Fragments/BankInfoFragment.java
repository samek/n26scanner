package si.root.n26scanner.Fragments;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import si.root.n26scanner.Models.TransactionResponse;
import si.root.n26scanner.R;
import si.root.n26scanner.Utils.SettingsHelper;
import si.root.n26scanner.ViewModels.AuthTokenVM;
import si.root.n26scanner.ViewModels.MeVM;
import si.root.n26scanner.ViewModels.TransactionVM;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BankInfoFragment extends Fragment {
    private SharedPreferences mSettings;
    private SettingsHelper s;
    private View v;
    private String Token="";
    private ProgressBar pg;

    public BankInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v  =  inflater.inflate(R.layout.fragment_bank_info, container, false);

        Button b  = v.findViewById(R.id.LogOut);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogOut();
            }
        });

        mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        s = new SettingsHelper(mSettings);
        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pg = view.findViewById(R.id.bankInfo_progressbar);
        ShowInfo();
    }

    private void  ShowInfo() {
        if (s.FillInCredentials()) {
            togleProgressBar();
            AuthTokenVM avm = ViewModelProviders.of(this).get(AuthTokenVM.class);
            avm.GetAuthToken(s.getEmail(), s.getPassword()).observe(this, data -> {
                if (data != null) {
                    System.out.println("TOKEN:" + data.getAccessToken());
                    Token = data.getAccessToken();
                    fillData();
                } else {
                    Navigation.findNavController(v).navigate(R.id.settings);
                }
            });
        } else {
            Navigation.findNavController(v).navigate(R.id.settings);
        }

    }



    private void fillData() {
        MeVM mvm = ViewModelProviders.of(this).get(MeVM.class);
        mvm.GetMeInfo(Token).observe(this, data -> {
            togleProgressBar();
            if (data != null) {
                TextView LastName = v.findViewById(R.id.lastNameText);
                TextView Name = v.findViewById(R.id.nameText);
                LastName.setText(data.getLastName());
                Name.setText(data.getFirstName());

            } else {
                Navigation.findNavController(v).navigate(R.id.settings);
            }
        });

    }

    private void LogOut() {
        s.setEmail("");
        s.setPassword("");
        s.setPin("");
        Navigation.findNavController(v).navigate(R.id.settings);
    }

    private void togleProgressBar() {
        if (pg.getVisibility()==View.VISIBLE) {
            pg.setVisibility(View.GONE);
        } else {
            pg.setVisibility(View.VISIBLE);
        }
    }
}
