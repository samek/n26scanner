package si.root.n26scanner.Activities;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.notbytes.barcode_reader.BarcodeReaderFragment;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import si.root.n26scanner.Fragments.HomeFragmentDirections;
import si.root.n26scanner.R;

public class MainActivity extends AppCompatActivity implements BarcodeReaderFragment.BarcodeReaderListener {

    public NavController navController;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    navController.navigate(R.id.home2);
                    return true;
                case R.id.scan:
                    navController.navigate(R.id.qrCodeReader);
                    return true;
                case R.id.settings:
                    navController.navigate(R.id.settings);
                    return true;
                case R.id.bankInfo:
                    navController.navigate(R.id.bankInfo);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp();
    }

    @Override
    public void onScanned(Barcode barcode) {
        Toast.makeText(this, "MAINACTIVITI"+barcode.rawValue, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {

    }

    @Override
    public void onCameraPermissionDenied() {
        Toast.makeText(this, "Camera permission denied!", Toast.LENGTH_LONG).show();
    }


}
