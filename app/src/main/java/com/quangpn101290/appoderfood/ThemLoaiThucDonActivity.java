package com.quangpn101290.appoderfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.quangpn101290.appoderfood.DAO.LoaiMonAnDAO;

/**
 * Created by spaba on 6/13/2017.
 */

public class ThemLoaiThucDonActivity extends AppCompatActivity implements OnClickListener {
    Button btnDongYThemLoaiThucDon;
  EditText edTenLoai;

  LoaiMonAnDAO loaiMonAnDAO;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_themloaithucdon);
    loaiMonAnDAO = new LoaiMonAnDAO(this);

    btnDongYThemLoaiThucDon = (Button) findViewById(R.id.btnDongYThemLoaiThucDon);
    edTenLoai = (EditText) findViewById(R.id.edThemLoaiThucDon);

    btnDongYThemLoaiThucDon.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    String sTenLoaiThucDon = edTenLoai.getText().toString();
    if (sTenLoaiThucDon !=null || sTenLoaiThucDon.equals("")){
        boolean kiemtra = loaiMonAnDAO.ThemLoaiMonAn(sTenLoaiThucDon);
      Intent iDulieu = new Intent();
      iDulieu.putExtra("kiemtraloaithucdon",kiemtra);
      setResult(Activity.RESULT_OK,iDulieu);
      finish();

    }else {
      Toast.makeText(this, getResources().getString(R.string.vuilongnhapdulieu), Toast.LENGTH_SHORT).show();
    }


  }
}
