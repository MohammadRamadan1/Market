package com.mohammadramadan.android.getbackup;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 2;

    public void minus(View view) {
        quantity = quantity - 1;
        displayQuanity(quantity);
        if ( quantity<= 0){
            Toast.makeText(getApplicationContext(),"You Can't buy less than 1 ", Toast.LENGTH_LONG).show();
        }
        else{
            return;
        }
    }

    public void plus(View view) {
        quantity = quantity + 1;
        displayQuanity(quantity);
        if (quantity >= 21){
            Toast.makeText(getApplicationContext(),"You Can't buy more than 20 ", Toast.LENGTH_LONG).show();
        }
        else{
            return;
        }
    }

    public void displayQuanity(int numberOfStuff) {
        TextView quanityTextView = (TextView) findViewById(R.id.number_of_stuff);
        quanityTextView.setText("" + numberOfStuff);
    }

    public void buyMessage (View view) {
        CheckBox mouseCheckBox = (CheckBox) findViewById(R.id.mouse);
        boolean hasMouseChexkBox = mouseCheckBox.isChecked();

        CheckBox keyboardCheckBox = (CheckBox) findViewById(R.id.keyboard);
        boolean hasKeyboardCheckBox= keyboardCheckBox.isChecked();

        int price = calculaterPrice();

        String message =createOrderSummery(price, hasKeyboardCheckBox, hasMouseChexkBox);
        displayMessage(message);
    }


    public int calculaterPrice() {
        return quantity * 100;
    }

    private String createOrderSummery (int price, boolean addKeyboardCheckBox, boolean addMouseCheckBox){
        String priceMessage = "Thanks for using the App!";

        priceMessage +="\nAdd Keyboard? " + addKeyboardCheckBox;
        if (addKeyboardCheckBox) {
            price = price + 10;
        }
        priceMessage +="\nAdd Mouse? " + addMouseCheckBox;
        if (addMouseCheckBox){
            price = price +5;
        }

        priceMessage +="\n total: "+ price +"€";
        return  priceMessage;
    }

    private void displayMessage(String message){
        TextView orderSummeryTextView = (TextView) findViewById(R.id.order);
        orderSummeryTextView.setText(message);
    }
}
