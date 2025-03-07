package com.example.expensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.TransitionAdapter;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private Button btnlogin;
    private TextView currentDateTextView;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private RecyclerView transactionList;
    private TransactionAdapter transactionAdapter;
    private List<Transaction> transactions=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moveToLogin();
        ImageView prevDate=findViewById(R.id.prevDateBtn);
        ImageView nextDate=findViewById(R.id.nextDateBtn);
        currentDateTextView=findViewById(R.id.currentDate);

        dateFormat=new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        calendar=Calendar.getInstance();

        currentDateTextView.setText(dateFormat.format(calendar.getTime()));
        prevDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeDate(-1);
            }
        });
        nextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeDate(1);
            }
        });

        transactionList=findViewById(R.id.transactionList);
        FloatingActionButton addTransactionBtn=findViewById(R.id.floatingActionButton2);
        transactionList.setLayoutManager(new LinearLayoutManager(this));

        transactionAdapter = new TransactionAdapter(transactions);
        transactionList.setAdapter(transactionAdapter);

        addTransactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddTransactionBottomSheet();
            }
        });
    }
    private void moveToLogin(){
        btnlogin=findViewById(R.id.loginButton);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
    }
    private void changeDate(int days){
        calendar.add(Calendar.DAY_OF_MONTH,days);
        currentDateTextView.setText(dateFormat.format(calendar.getTime()));
    }
    private void openAddTransactionBottomSheet(){
        new AddTransaction(this, new AddTransaction.OnTransactionAddedListener() {
            @Override
            public void onTransactionAdded(Transaction transaction) {
                transactions.add(transaction);
                transactionAdapter.notifyItemInserted(transactions.size()-1);
            }
        });
    }







}