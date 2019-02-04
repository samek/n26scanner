package si.root.n26scanner.Fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import si.root.n26scanner.R;
import si.root.n26scanner.Utils.SettingsHelper;
import si.root.n26scanner.ViewModels.AuthTokenVM;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private EditText email;
    private EditText pass;
    private EditText pin;
    private SharedPreferences mSettings;
    private SettingsHelper s;
    private View v;
    private ProgressBar pg;

    public SettingsFragment() {
        // Required empty public constructor
    }

    private void togleProgressBar() {
        if (pg.getVisibility()==View.VISIBLE) {
            pg.setVisibility(View.GONE);
        } else {
            pg.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        s = new SettingsHelper(mSettings);
        v = inflater.inflate(R.layout.fragment_settings, container, false);
        email = v.findViewById(R.id.emailSetting);
        pass = v.findViewById(R.id.passwordSetting);
        pin = v.findViewById(R.id.pinSetting);
        pg = v.findViewById(R.id.settings_progressBar);


        Button b = v.findViewById(R.id.storeSettings);
        if (s.FillInCredentials()) {
            email.setText(s.getEmail());
            pass.setText(s.getPassword());
            pin.setText(s.getPin());
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndInsert();
            }
        });
        return v;
    }

    private void validateAndInsert() {
        if (email.getText().toString().equals("") || pass.getText().toString().equals("") || pin.getText().toString().equals("")) {
            showToast("Please enter all the data");
        } else {
            s.setEmail(email.getText().toString());
            s.setPassword(pass.getText().toString());
            s.setPin(pin.getText().toString());
            togleProgressBar();
            AuthTokenVM avm = ViewModelProviders.of(this).get(AuthTokenVM.class);
            avm.GetAuthToken(s.getEmail(),s.getPassword()).observe(this, data -> {
                togleProgressBar();
                if (data != null ) {
                    System.out.println("TOKEN:"+data.getAccessToken());
                    Navigation.findNavController(v).navigate(R.id.bankInfo);
                } else {
                    showToast("Invalid cretentials - try again");
                }
            });

        }
    }

    private void showToast(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }


}
