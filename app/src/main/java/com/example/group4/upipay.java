package com.example.group4;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
public class upipay extends AppCompatActivity
{
    EditText amountET,notET,nameET,upiET;
    Button send;
    final int UPI_PAYMENT = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upipay);
        initializeViews();
        send.setOnClickListener(view -> {
            String amount=amountET.getText().toString();
            String note=notET.getText().toString();
            String name=nameET.getText().toString();
            String upi=upiET.getText().toString();
            if(amount.isEmpty()||note.isEmpty()||name.isEmpty()||upi.isEmpty())
            {
                Toast.makeText(this, "Please, Fill all the fields", Toast.LENGTH_SHORT).show();
            }
            else { payUsingUpi(amount, upi, name, note); }
        });
    }
    private void initializeViews()
    {
        send=findViewById(R.id.send);
        amountET=findViewById(R.id.amount_et);
        notET=findViewById(R.id.note);
        nameET=findViewById(R.id.name);
        upiET=findViewById(R.id.upi_id);
    }
    @SuppressLint("QueryPermissionsNeeded")
    private void payUsingUpi(String amount, String upi, String name, String note)
    {
        Uri uri=Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa",upi)
                .appendQueryParameter("pn",name)
                .appendQueryParameter("tn",note)
                .appendQueryParameter("am",amount)
                .appendQueryParameter("cu","INR")
                .build();
        Intent upiPayIntent=new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);
        Intent chooser = Intent.createChooser(upiPayIntent,"Pay with");
        if(null!=chooser.resolveActivity(getPackageManager()))
        {
            startActivityForResult(chooser,UPI_PAYMENT);
        }
        else
        {
            Toast.makeText(this, "No UPI app found, please install one to continue", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UPI_PAYMENT) {
            if ((RESULT_OK == resultCode) || (resultCode == 11)) {
                if (data != null) {
                    String text = data.getStringExtra("response");
                    Log.d("upi", "onActivityResult:" + text);
                    ArrayList<String> datalist = new ArrayList<>();
                    datalist.add(text);
                    upiPaymentDataOperation(datalist);
                } else {
                    Log.d("upi", "onActivityResult:" + "Return data is null");
                    ArrayList<String> datalist = new ArrayList<>();
                    datalist.add("nothing");
                    upiPaymentDataOperation(datalist);
                }
            } else {
                Log.d("upi", "onActivityResult" + "Return data is null");
                ArrayList<String> datalist = new ArrayList<>();
                datalist.add("nothing");
                upiPaymentDataOperation(datalist);
            }
        }
    }
    private void upiPaymentDataOperation(ArrayList<String> data)
    {
        if(isConnectionAvailable(upipay.this))
        {
            String str=data.get(0);
            Log.d("UPIPAY","upiPaymentDataOperation:"+str);
            if(str==null) str="Discard";
            String status="";
            String approvalRefNo="";
            String[] response =str.split("4");
            for (String s : response) {
                String[] equalStr = s.split("=");
                if (equalStr.length >= 2) {
                    if (equalStr[0].equalsIgnoreCase("status")) {
                        status = equalStr[1].toLowerCase();
                    } else if (equalStr[0].equalsIgnoreCase("ApprovalRefNo") || equalStr[0].equalsIgnoreCase("txnRef")) {
                        approvalRefNo = equalStr[1];
                    }
                } else {
                    Toast.makeText(this, "User cancel the payment", Toast.LENGTH_SHORT).show();
                }
            }
            if(status.equals("success"))
            {
                Toast.makeText(this,"Transaction Successfull",Toast.LENGTH_SHORT).show();
                Log.d("upi","responseStr:"+approvalRefNo);
            }
            else {
                Toast.makeText(this, "Transaction failed,please try again", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Internet connection is not available. please check and try again", Toast.LENGTH_SHORT).show();
        }
    }
    public static boolean isConnectionAvailable(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable();
        }
        return false;
    }
}