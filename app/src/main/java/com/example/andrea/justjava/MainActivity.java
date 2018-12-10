package com.example.andrea.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* method for the button */
    public void submitOrder(View view){
        //displayPrice(quantity * 5);
        //String message = "She said \"1 dollar\"";
        int price = quantity * 5;
        String message = "The price is $" + price + ", thank you.";
        message = message + "\nSee you later!";
        displayMessage(message);
    }

    /* The method display the given quantity value on the screen */
    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /* The method displays the given quantity value on the screen */
    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /* The method display message on the screen */
    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /* This method is called when the plus button is clicked */
    public void increment(View view){
        quantity = quantity + 1;
        display(quantity);
    }

    /* This method is called when the minus button is clicked */
    public void decrement(View view){
        quantity = quantity - 1;
        display(quantity);
    }
}
