package si.root.n26scanner.Fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.notbytes.barcode_reader.BarcodeReaderFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import si.root.n26scanner.R;
import si.root.n26scanner.Utils.SettingsHelper;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class QrCodeReaderFragment extends Fragment implements BarcodeReaderFragment.BarcodeReaderListener {
    private SharedPreferences mSettings;
    private SettingsHelper s;
    private BarcodeReaderFragment barcodeReader;
    private View view;

    public QrCodeReaderFragment() {
        // Required empty public constructor
    }

    public static QrCodeReaderFragment newInstance() {
        Bundle args = new Bundle();
        QrCodeReaderFragment fragment = new QrCodeReaderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_qr_code_reader, container, false);
        barcodeReader = (BarcodeReaderFragment) getChildFragmentManager().findFragmentById(R.id.barcode_fragment);
        barcodeReader.setListener(this);
        mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        s = new SettingsHelper(mSettings);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!s.FillInCredentials()) {
            Navigation.findNavController(view).navigate(R.id.settings);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onScanned(final Barcode barcode) {
        System.out.println(barcode.rawValue);
        parseQr(barcode.rawValue);
        //QrCodeReaderFragmentDirections.ActionQrCodeReaderToPaymentConfirmationFragment g = QrCodeReaderFragmentDirections.actionQrCodeReaderToPaymentConfirmationFragment().setAmount(1000);
        //Navigation.findNavController(view).navigate(g);
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {
        Log.e(TAG, "onScannedMultiple: " + barcodes.size());

        String codes = "";
        for (Barcode barcode : barcodes) {
            codes += barcode.displayValue + ", ";
        }

        final String finalCodes = codes;
        Toast.makeText(getActivity(), "Barcodes: " + finalCodes, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {
        Log.e(TAG, "onScanError: " + errorMessage);
    }

    @Override
    public void onCameraPermissionDenied() {
        Toast.makeText(getActivity(), "Camera permission denied!", Toast.LENGTH_LONG).show();
    }


    private void  parseQr(String rawText) {

        String[] segments = rawText.split("\n");
        if (segments.length<18) {
            Toast.makeText(getContext(),"Wrong QR parameters. " ,Toast.LENGTH_LONG);
        } else if  (!segments[0].contains("UPNQR")){
            Toast.makeText(getContext(),"Not a valid QR code",Toast.LENGTH_LONG);
        } else {

            float ammount = (Float.parseFloat(segments[8]) / 100);
            Integer ammountInt = Integer.parseInt(segments[8]);
            String iban = segments[14];
            String name = segments[16] + " " + segments[17] + " " + segments[18];
            String reference = segments[15];
            QrCodeReaderFragmentDirections.ActionQrCodeReaderToPaymentConfirmationFragment g = QrCodeReaderFragmentDirections.actionQrCodeReaderToPaymentConfirmationFragment(iban,name,reference)
                    .setAmount(ammountInt);
            System.out.println("Amount:" + ammount + " Iban:" + iban + " name:" + name + " reference:" + reference);
            Navigation.findNavController(view).navigate(g);
        }
    }
}
