package com.example.andrea.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* method for the button */
    public void submitOrder(View view){

        CheckBox whippedCheck = findViewById(R.id.WhippedCheck);
        CheckBox chocolateCheck = findViewById(R.id.ChocolateCheck);
        EditText client = findViewById(R.id.NameClient);
        boolean whipped = whippedCheck.isChecked();
        boolean chocolate = chocolateCheck.isChecked();
        String nameClient = client.getText().toString();
        int price = calculatePrice(chocolate, whipped);

        String message = "Name: " + nameClient;
        message += "\nTotal: $" + price;
        message += "\nQuantity: " + quantity;
        message += "\nAdd whipped cream? " + whipped;
        message += "\nAdd chocolate? " + chocolate;
        message += "\nThank you, see you later!";
        displayMessage(message);
    }

    /* The method display the given quantity value on the screen */
    private void display(int number){
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /* The method displays the given quantity value on the screen */
    private int calculatePrice(boolean chocolate, boolean whipped){
        int basePrice = 5;

        if(chocolate){
            basePrice = basePrice + 2;
        }

        if(whipped){
            basePrice = basePrice + 1;
        }

        return quantity * basePrice;
    }

    /* The method display message on the screen */
    private void displayMessage(String message){
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /* This method is called when the plus button is clicked */
    public void increment(View view){
        if (quantity == 100) {
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity + 1;
        display(quantity);
    }

    /* This method is called when the minus button is clicked */
    public void decrement(View view){
        if (quantity == 1) {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }
}
