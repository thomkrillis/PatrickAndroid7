package io.github.thomkrillis.patrickandroid7.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import io.github.thomkrillis.patrickandroid7.MainActivity;
import io.github.thomkrillis.patrickandroid7.R;

public class SecondWorld extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String cardSelected = getIntent().getStringExtra(MainActivity.CARD_SELECTED);

        if(cardSelected.equals(MainActivity.KING_OF_HEARTS)
                || cardSelected.equals(MainActivity.ONE_EYED_JACK)) {
            String response = "Wrong card; try again.";

            Intent responseIntent = new Intent();
            responseIntent.putExtra(MainActivity.KEY_HELLO, response);

            setResult(RESULT_OK, responseIntent);

            finish();
        } else {

        }

    }
}