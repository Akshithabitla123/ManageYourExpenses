package com.example.expensemanager;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class AddTransaction{
    public interface OnTransactionAddedListener{
        void onTransactionAdded(Transaction transaction);
    }
    private OnTransactionAddedListener listener;
    private String transactionType="";
    public AddTransaction(Context context,OnTransactionAddedListener listener){
        this.listener=listener;
        showBottomSheet(context);
    }
    private void showBottomSheet(Context context){
        BottomSheetDialog dialog=new BottomSheetDialog(context);
        dialog.setContentView(R.layout.dialog_add_transaction);

        Button btnExpense=dialog.findViewById(R.id.btnExpense);
        Button btnIncome=dialog.findViewById(R.id.btnIncome);
        LinearLayout inputLayout=dialog.findViewById(R.id.inputLayout);
        EditText categoryInput=dialog.findViewById(R.id.inputCategory);
        EditText dateInput=dialog.findViewById(R.id.inputDate);
        EditText amountInput=dialog.findViewById(R.id.inputAmount);
        EditText payMode=dialog.findViewById(R.id.inputMode);
        Button addButton=dialog.findViewById(R.id.btnAdd);

        inputLayout.setVisibility(View.GONE);

        btnExpense.setOnClickListener(view -> {
            transactionType="Expense";
            inputLayout.setVisibility(View.VISIBLE);
        });
        btnIncome.setOnClickListener(view -> {
            transactionType="Income";
            inputLayout.setVisibility(View.VISIBLE);
        });

        addButton.setOnClickListener(view -> {
            String category=categoryInput.getText().toString();
            String date=dateInput.getText().toString();
            String amount=amountInput.getText().toString();
            String mode=payMode.getText().toString();

            if(transactionType.isEmpty()){
                Toast.makeText(context,"Select Expense or Income",Toast.LENGTH_SHORT).show();
                return;
            }
            if(category.isEmpty() || date.isEmpty() || amount.isEmpty() || mode.isEmpty()){
                Toast.makeText(context,"Please fill all the fileds",Toast.LENGTH_SHORT).show();
                return;
            }
            Transaction transaction=new Transaction(category,date,amount,mode);
            listener.onTransactionAdded(transaction);
            dialog.dismiss();
        });
        dialog.show();
    }

}
