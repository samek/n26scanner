package si.root.n26scanner.Fragments;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import si.root.n26scanner.R;
import si.root.n26scanner.Utils.SettingsHelper;
import si.root.n26scanner.ViewModels.AuthTokenVM;
import si.root.n26scanner.ViewModels.TransactionVM;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentConfirmationFragment extends Fragment {

    private float ammountF;
    private String name="";
    private String iban="";
    private String reference="";
    private String Token = "";
    private SharedPreferences mSettings;
    private SettingsHelper s;
    private ProgressBar pg;

    public PaymentConfirmationFragment() {
        // Required empty public constructor
    }

    private void getArgs() {
       Integer amount =  PaymentConfirmationFragmentArgs.fromBundle(getArguments()).getAmount();
       name = PaymentConfirmationFragmentArgs.fromBundle(getArguments()).getName();
       iban = PaymentConfirmationFragmentArgs.fromBundle(getArguments()).getIban();
       reference = PaymentConfirmationFragmentArgs.fromBundle(getArguments()).getReference();
       ammountF = (float) amount  / (float) 100;
       System.out.print(ammountF+"");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getArgs();

        return inflater.inflate(R.layout.fragment_payment_confirmation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView amountText = view.findViewById(R.id.confirmation_amount);
        TextView nameText = view.findViewById(R.id.confirmation_name);
        TextView ibanText = view.findViewById(R.id.confirmation_iban);
        TextView referenceText = view.findViewById(R.id.confirmation_reference);
        pg = view.findViewById(R.id.confirmation_progressBar);

        amountText.setText(String.valueOf(ammountF));
        nameText.setText(name);
        ibanText.setText(iban);
        referenceText.setText(reference);

        Button makePayment = view.findViewById(R.id.confirmation_make_payment);

        makePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTokenAndMakePayment();
            }
        });
    }

    private void makePayment() {

        TransactionVM tvm = ViewModelProviders.of(this).get(TransactionVM.class);
        tvm.MakeTransaction(Token,s.getPin(),ammountF,"",iban,name,reference).observe(this,data->
        {
            togleProgressBar();
            if (data!=null) {
                if (data.getTitle()!=null) {
                    showToast(data.getMessage());
                } else {
                    showToast("Confirm with you mobile phone "+data.getId());
                }
            } else {
                showToast("Failed request ");
            }
        });
    }


    private void getTokenAndMakePayment() {

        togleProgressBar();
        mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        s = new SettingsHelper(mSettings);
        s.FillInCredentials();
        AuthTokenVM avm = ViewModelProviders.of(this).get(AuthTokenVM.class);
        avm.GetAuthToken(s.getEmail(), s.getPassword()).observe(this, data -> {
            if (data != null) {
                System.out.println("TOKEN:" + data.getAccessToken());
                Token = data.getAccessToken();
                makePayment();
            } else {
               showToast("Cannot get auth");
               togleProgressBar();
            }
        });
    }

    private void showToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    private void togleProgressBar() {
        if (pg.getVisibility()==View.VISIBLE) {
            pg.setVisibility(View.GONE);
        } else {
            pg.setVisibility(View.VISIBLE);
        }
    }

}
