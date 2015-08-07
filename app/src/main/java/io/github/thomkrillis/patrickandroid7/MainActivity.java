package io.github.thomkrillis.patrickandroid7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.github.thomkrillis.patrickandroid7.activities.SecondWorld;


public class MainActivity extends Activity {


    public static final String KEY_HELLO = "key_hello";
    public static final String CARD_SELECTED = "";
    public static final int REQUEST_COMS = 99;

    private Button button1;
    private Button button2;
    private Button button3;

    public static final String KING_OF_HEARTS ="Suicide King";
    public static final String ONE_EYED_JACK ="Jack of diamonds";
    public static final String QUEEN_OF_SPADES ="Queen of Spades";

    private List<String> cardList;

    private void randomizeCards() {
        String[] cards = new String[] {KING_OF_HEARTS, ONE_EYED_JACK, QUEEN_OF_SPADES};
        cardList = Arrays.asList(cards);
        Collections.shuffle(cardList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setText("card");

        button2 = (Button) findViewById(R.id.button2);
        button2.setText("card");

        button3 = (Button) findViewById(R.id.button3);
        button3.setText("card");
    }

    @Override
    protected void onResume() {
        super.onResume();

        randomizeCards();

        setupListeners();

    }

    private void setupListeners() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchWorld(0);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchWorld(1);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchWorld(2);
            }
        });

    }

    private void launchWorld(int cardNumber) {
        Intent launchComIntent = new Intent(this, SecondWorld.class);
        launchComIntent.putExtra(MainActivity.CARD_SELECTED, cardList.get(cardNumber));
        startActivityForResult(launchComIntent, REQUEST_COMS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_COMS) {
            if (resultCode == RESULT_OK) {
                String responseMsg = data.getStringExtra(KEY_HELLO);

                Toast.makeText(this, responseMsg, Toast.LENGTH_LONG)
                        .show();
            }
        }
    }
}