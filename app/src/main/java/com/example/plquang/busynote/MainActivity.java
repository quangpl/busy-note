package com.example.plquang.busynote;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Database database;
    ListView lvCongViec;
    ArrayList<CongViec> arrayCongViec;
 
    CongViecAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCongViec=(ListView) findViewById(R.id.listviewCongViec);
        arrayCongViec=new ArrayList<>();
        adapter = new CongViecAdapter(this,R.layout.dong_cong_viec,arrayCongViec);
        lvCongViec.setAdapter(adapter);



        database = new Database(this, "ghichu.sqlite", null, 1);

        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT,TenCV VARCHAR(200))");
        //Insert database
        // database.QueryData("INSERT INTO CongViec VALUES(null,'2')");
        GetDataCongViec();
    }
    private void GetDataCongViec()
    {arrayCongViec.clear();
        Cursor dataCongViec = database.GetData("SELECT * FROM CongViec ");

        while (dataCongViec.moveToNext()) {
            String ten = dataCongViec.getString(1);
            int id=dataCongViec.getInt(0);
            arrayCongViec.add(new CongViec(id,ten));
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menuAdd);
        DialogThem();
        return super.onOptionsItemSelected(item);
    }


    public void DialogSuaCongViec(String ten, final int id)
    {

        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_sua);
        dialog.show();
        final EditText edtSuaCV=(EditText) dialog.findViewById(R.id.edittextSua);

        Button btnHuySua=(Button) dialog.findViewById(R.id.buttonHuySua);
        Button btnSuaCV=(Button) dialog.findViewById(R.id.buttonXacNhan);
        edtSuaCV.setText(ten);
        btnHuySua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnSuaCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenmoi=edtSuaCV.getText().toString().trim();
                database.QueryData("UPDATE CongViec SET TenCV='"+ tenmoi+"' WHERE Id='"+id+"'");
                Toast.makeText(MainActivity.this ,"Cập nhật thành công",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                GetDataCongViec();
            }
        });


    }
    public void DialogXoaCV(final String tencv, final int id)
    {
        AlertDialog.Builder dialogXoa=new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn đã hoàn thành công việc " +tencv + " đúng không?");
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogXoa.setPositiveButton("Đúng vậy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.QueryData("DELETE FROM CongViec WHERE Id='"+id+"' ");
                Toast.makeText(MainActivity.this,"Đã hoàn thành công việc "+tencv+" !",Toast.LENGTH_SHORT).show();
                GetDataCongViec();
            }
        });
        dialogXoa.show();

    }
    public void DialogThem()
    {
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_them_cong_viec);
        final EditText edtTen=(EditText) dialog.findViewById(R.id.edittextTenCV);
        Button btnThem=(Button) dialog.findViewById(R.id.buttonThem) ;
        Button btnHuy=(Button) dialog.findViewById(R.id.buttonHuy) ;
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tencv=edtTen.getText().toString();
                if(tencv.length()==0)  Toast.makeText(MainActivity.this,"Vui lòng nhập nội dung",Toast.LENGTH_SHORT).show();
                else {
                    database.QueryData("INSERT INTO CongViec VALUES(null,'"+ tencv +"')");
                    dialog.dismiss();
                    GetDataCongViec();
                    Toast.makeText(MainActivity.this,"Đã thêm thành công !",Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }
}
