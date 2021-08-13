package co.edu.unipiloto;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import co.edu.unipiloto.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickFindBeer(View view){
        Spinner color = (Spinner)findViewById(R.id.color);
        String selectedBeerType = String.valueOf(color.getSelectedItem());

        List<String> brandsList = expert.getBrands(selectedBeerType);
        StringBuilder brandsFormatted = new StringBuilder();

        for(String brand : brandsList){
            brandsFormatted.append(brand).append('\n');
        }

        TextView brands = (TextView) findViewById(R.id.brands);
        brands.setText(brandsFormatted);
    }
}