package com.example.androidproj;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private String[] continents = {"Africa", "Antarctica", "Asia", "Australia", "Europe", "North America", "South America"};

    private EditText emailEditText, firstNameEditText, lastNameEditText, passwordEditText, confirmPasswordEditText;
    private Spinner preferredDestinationSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailEditText = findViewById(R.id.emailEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        preferredDestinationSpinner = findViewById(R.id.preferredDestinationSpinner);
    //  ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, android.R.layout.simple_spinner_item);

        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.continents, android.R.layout.simple_spinner_item);
     //   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    //    preferredDestinationSpinner.setAdapter(adapter);

        Button signUpButton = findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFormValid()) {
                    // perform registration
                } else {
                    showErrorMessage();
                }
            }
        });
    }

    private boolean isFormValid() {
        boolean isValid = true;

        String email = emailEditText.getText().toString().trim();
        if (!isValidEmail(email)) {
            emailEditText.setBackgroundColor(Color.RED);
            isValid = false;
        }

        String firstName = firstNameEditText.getText().toString().trim();
        if (firstName.length() < 3 || firstName.length() > 20) {
            firstNameEditText.setBackgroundColor(Color.RED);
            isValid = false;
        }

        String lastName = lastNameEditText.getText().toString().trim();
        if (lastName.length() < 3 || lastName.length() > 20) {
            lastNameEditText.setBackgroundColor(Color.RED);
            isValid = false;
        }

        String password = passwordEditText.getText().toString().trim();
        if (password.length() < 8 || password.length() > 15 || !isValidPassword(password)) {
            passwordEditText.setBackgroundColor(Color.RED);
            isValid = false;
        }

        String confirmPassword = confirmPasswordEditText.getText().toString().trim();
        if (!password.equals(confirmPassword)) {
            confirmPasswordEditText.setBackgroundColor(Color.RED);
            isValid = false;
        }

        return isValid;
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void validateSignUpData() {
        String email = emailEditText.getText().toString();
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();
      //  String selectedContinent = continentsSpinner.getSelectedItem().toString();

        if (!isValidEmail(email)) {
            emailEditText.setError("Invalid Email");
            emailEditText.requestFocus();
            return;
        }

        if (firstName.length() < 3 || firstName.length() > 20) {
            firstNameEditText.setError("First Name must be between 3 and 20 characters");
            firstNameEditText.requestFocus();
            return;
        }

        if (lastName.length() < 3 || lastName.length() > 20) {
            lastNameEditText.setError("Last Name must be between 3 and 20 characters");
            lastNameEditText.requestFocus();
            return;
        }

        if (!isValidPassword(password)) {
            passwordEditText.setError("Password must be 8-15 characters with at least one number, one lowercase letter and one uppercase letter");
            passwordEditText.requestFocus();
            return;
        }

        if (!confirmPassword.equals(password)) {
            confirmPasswordEditText.setError("Passwords do not match");
            confirmPasswordEditText.requestFocus();
            return;
        }

        // If all fields are valid, register user
    //    User user = new User(email, firstName, lastName, password, selectedContinent);
       // registerUser(user);
    }

    /*
            private boolean isValidEmail(String email) {
                return Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
    */
    private boolean isValidPassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,15}$";
        return password.matches(pattern);
    }

    private void registerUser(User user) {
        // Add code to register user
        // ...
        // Show Toast message on successful registration
        Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show();
    }
    private void showErrorMessage() {
        int message =1;
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}